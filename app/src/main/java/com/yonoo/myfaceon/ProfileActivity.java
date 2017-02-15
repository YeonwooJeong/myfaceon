package com.yonoo.myfaceon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mocoplex.adlib.AdlibActivity;
import com.mocoplex.adlib.AdlibManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


public class ProfileActivity extends AdlibActivity implements OnClickListener{

	EditText et_name,et_national,et_birth,et_height,et_weight,et_foot_right,et_foot_left,hidden,position2,position3,position4,et_star,
			et_team,et_number,et_ep,
			et_ability1,et_ability2,et_ability3,et_ability4,et_ability5,et_ability6,et_ability7,et_ability8,et_ability9,et_ability10,et_ability11
			,et_ability12,et_ability13,et_ability14,et_ability15,et_ability16,et_ability17,et_ability18,et_ability19,et_ability20
			,et_ability21,et_ability22,et_ability23,et_ability24,et_ability25,et_ability26,et_ability27,et_ability28,et_ability29,
			et_ability30,et_ability31,et_ability32,et_ability33,et_ability34,et_ability35,et_ability36
			,et_value1,et_value2,et_value3,et_value4,et_value5,et_value6,et_value7,et_value8,et_value9,et_value10
			,et_value11,et_value12,et_value13,et_value14,et_value15,et_value16,et_value17,et_value18,et_value19,
			et_value20,et_value21,et_value22,et_value23,et_value24,et_value25,et_value26,et_value27,et_value28,et_value29,
			et_value30,et_value31,et_value32,et_value33,et_value34,et_value35,et_value36;

	String tag,season;
	Spinner spinner,spinner2,spinner3,spinner4,country,hiddenStat,force,body,consist,legend_spinner,special_spinner;
	String language;
	TextView season_select;


	private AutoCompleteTextView autoComplete;
	private ArrayList<String> list;
	private ArrayAdapter<String> adapter;
	FaceonComp comp = new FaceonComp();
	Button alert; //팝업
	ImageButton test;
	private static final int MSG_TIMER_EXPIRED = 1;

	private static final int BACKEY_TIMEOUT = 2000;

	private boolean mIsBackKeyPressed = false;

	private long mCurrentTimeInMillis = 1;


	@Override
	public void onBackPressed() {
		Locale locale = getResources().getConfiguration().locale;
		language =  locale.getLanguage();
		if (mIsBackKeyPressed == false) {
			mIsBackKeyPressed = true;

			mCurrentTimeInMillis = Calendar.getInstance().getTimeInMillis();
			if(language.equals("en"))
				Toast.makeText(this, "Press again to go back.\nThis will be deleted the entered value when you go to the back", Toast.LENGTH_SHORT)
						.show();
			else if(language.equals("th"))
				Toast.makeText(this, "กดอีกครั้งเพื่อกลับไป\nนี้จะถูกลบเมื่อค่าที่ป้อนกลับไปด้านบน", Toast.LENGTH_SHORT)
						.show();
			else if(language.equals("vi"))
				Toast.makeText(this, "Nhấn nó một lần sẽ bị xóa Quay lại đầu trang.\ngiá trị bạn nhập khi đi lại.", Toast.LENGTH_SHORT)
						.show();
			else
				Toast.makeText(this, "한번 더 누르면 뒤로가기 됩니다.\n뒤로 가기시 입력한 값이 삭제됩니다.", Toast.LENGTH_SHORT)
						.show();

			startTimer();
		} else {
			mIsBackKeyPressed = false;

			if (Calendar.getInstance().getTimeInMillis() <= (mCurrentTimeInMillis + (BACKEY_TIMEOUT))) {
				finish();

			}
		}
	}
	private void startTimer() {
		mTimerHander.sendEmptyMessageDelayed(MSG_TIMER_EXPIRED, BACKEY_TIMEOUT);
	}

	private Handler mTimerHander = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case MSG_TIMER_EXPIRED: {
					mIsBackKeyPressed = false;
				}
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//액티비티 생성
		setContentView(R.layout.profile);//custom.xml출력
		// 각 애드립 액티비티에 애드립 앱 키값을 필수로 넣어주어야 합니다.
		setAdlibKey(AdlibTestProjectConstants.ADLIB_API_KEY);

		this.setAdsHandler(new Handler() {
			public void handleMessage(Message message) {
				try
				{
					switch (message.what) {
						case AdlibManager.DID_SUCCEED:
							Log.d("ADLIBr", "[Banner] onReceiveAd " + (String) message.obj);
							break;
						case AdlibManager.DID_ERROR:
							Log.d("ADLIBr", "[Banner] onFailedToReceiveAd " + (String)message.obj);
							break;
					}
				}
				catch(Exception e)
				{

				}
			}
		});

		this.setAdsContainer(R.id.ads);


		LinearLayout mode_select = (LinearLayout) findViewById(R.id.mode);
		mode_select.setVisibility(View.GONE);

		Locale locale = getResources().getConfiguration().locale;
		language =  locale.getLanguage();
		System.out.println("언어언어"+language);

//		Toast.makeText(getApplicationContext(), language, Toast.LENGTH_LONG).show();

		//히든 팝업
		alert=(Button)findViewById(R.id.alert);
		alert.setOnClickListener(this);

		test = (ImageButton)findViewById(R.id.test);
		test.setOnClickListener(this);

		//자동완성 코드
		autoComplete = (AutoCompleteTextView)findViewById(R.id.edit_national);
		if(language.equals("en") || language.equals("th") || language.equals("vi"))
			list = comp.listAddEn();
		else
			list = comp.listAdd();

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, list);

		autoComplete.setAdapter(adapter);
        
        /*강화*/
		force = (Spinner)findViewById(R.id.spinner_force);

		ArrayAdapter<CharSequence> forceAdapter = ArrayAdapter.createFromResource(this, R.array.force_array,
				android.R.layout.simple_spinner_item);

		forceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		force.setAdapter(forceAdapter);
		/*강화*/
		
        /*국기선택*/
		et_national=(EditText)findViewById(R.id.edit_national);

		country = (Spinner)findViewById(R.id.spinner_country);

		ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.country_array,
				android.R.layout.simple_spinner_item);

		adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		country.setAdapter(adapter5);

		OnItemSelectedListener countrySelected = new OnItemSelectedListener() {


			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
									   int arg2, long arg3) {
				String str_country = country.getSelectedItem().toString();
				// TODO Auto-generated method stub
				if((str_country.equals("직접 입력") || str_country.equals("User Input")) && str_country.length() > 0){
					et_national.setText(null);

				}else {
					et_national.setText(str_country);

				}
				setResult(arg2);

			}
		};
		country.setOnItemSelectedListener(countrySelected);

		/*국기선택*/
		
		/*hidden*/
		hiddenStat = (Spinner)findViewById(R.id.spinner_hidden);

		ArrayAdapter<CharSequence> hiddenAdapter = ArrayAdapter.createFromResource(this, R.array.hidden_array,
				android.R.layout.simple_spinner_item);

		hiddenAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		hiddenStat.setAdapter(hiddenAdapter);

		OnItemSelectedListener hidddenSelected = new OnItemSelectedListener() {


			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
									   int arg2, long arg3) {

				if(hiddenStat.getSelectedItem().equals("초기화") || hiddenStat.getSelectedItem().equals("reset")){
					hidden.setText(null);
				}else{
//					   String str_hidden = "";
					String str_hidden = (hidden.length() == 0) ? hiddenStat.getSelectedItem().toString() : hidden.getText()+", "+hiddenStat.getSelectedItem().toString();
					hidden.setText(str_hidden);
					System.out.println(hidden.getText());
				}

				setResult(arg2);

			}
		};
		hiddenStat.setOnItemSelectedListener(hidddenSelected);
		/*hidden*/

		special_spinner = (Spinner)findViewById(R.id.spinner_special);
		ArrayAdapter<CharSequence> special = ArrayAdapter.createFromResource(this, R.array.special_array,android.R.layout.simple_spinner_item);

		special.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		special_spinner.setAdapter(special);

		OnItemSelectedListener specialSelected = new OnItemSelectedListener() {
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
									   int arg2, long arg3) {
				season = special_spinner.getSelectedItem().toString();
				// TODO Auto-generated method stub
				season_select.setText(season);
				setResult(arg2);
			}
		};
		special_spinner.setOnItemSelectedListener(specialSelected);

		legend_spinner = (Spinner)findViewById(R.id.spinner_legned);
		ArrayAdapter<CharSequence> legend = ArrayAdapter.createFromResource(this, R.array.legend_array,android.R.layout.simple_spinner_item);

		legend.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		legend_spinner.setAdapter(legend);

		OnItemSelectedListener legendSelected = new OnItemSelectedListener() {
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
									   int arg2, long arg3) {
				season = legend_spinner.getSelectedItem().toString();
				// TODO Auto-generated method stub
				season_select.setText(season);
				setResult(arg2);
			}
		};
		legend_spinner.setOnItemSelectedListener(legendSelected);

		/*시즌선택*/
		season_select = (TextView)findViewById(R.id.season_select);
		spinner = (Spinner)findViewById(R.id.spinner_season);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.season_array,android.R.layout.simple_spinner_item);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		OnItemSelectedListener seasonSelected = new OnItemSelectedListener() {
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
									   int arg2, long arg3) {
				season = spinner.getSelectedItem().toString();
				Log.v("시즌", season);
				// TODO Auto-generated method stub
				season_select.setText(season);
				setResult(arg2);
			}
		};
		spinner.setOnItemSelectedListener(seasonSelected);
		/*시즌선택*/
		
		/*체격 선택*/
		body = (Spinner)findViewById(R.id.spinner_body);

		ArrayAdapter<CharSequence> adapter_body = ArrayAdapter.createFromResource(this, R.array.body_array,
				android.R.layout.simple_spinner_item);

		adapter_body.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		body.setAdapter(adapter_body);
		/*체격선택*/
		
		/*별 선택*/
		spinner2 = (Spinner)findViewById(R.id.spinner_star);

		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.star_array,
				android.R.layout.simple_spinner_item);

		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(adapter2);
		/*별 선택*/
		
		
	
		/*모드 선택
		*/

		spinner3 = (Spinner)findViewById(R.id.spinner_mode);


		ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.mode_array,
				android.R.layout.simple_spinner_item);

		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner3.setAdapter(adapter3);

		OnItemSelectedListener mOnItemSelected = new OnItemSelectedListener() {
			LinearLayout mode = (LinearLayout) findViewById(R.id.position_lay);
			LinearLayout hidden_stat = (LinearLayout) findViewById(R.id.hidden_lay);
			LinearLayout half = (LinearLayout) findViewById(R.id.half_lay);
			LinearLayout team = (LinearLayout) findViewById(R.id.team);
			LinearLayout poten = (LinearLayout) findViewById(R.id.lay35);
			LinearLayout gk1on1 = (LinearLayout) findViewById(R.id.lay36);
			LinearLayout ep = (LinearLayout) findViewById(R.id.ep_lay);
			TextView txt_body = (TextView) findViewById(R.id.txt_body);
			TextView viewPosition = (TextView) findViewById(R.id.view_position);
			//아니오 부분


			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
									   int arg2, long arg3) {
				String str_mode = spinner3.getSelectedItem().toString();
				if(str_mode.equals("Original")){
					mode.setVisibility(View.GONE);
					hidden.setText(null);
					hidden_stat.setVisibility(View.GONE);
					team.setVisibility(View.GONE);
					txt_body.setVisibility(View.GONE);
					body.setVisibility(View.GONE);
					ep.setVisibility(View.GONE);
					poten.setVisibility(View.GONE);
					gk1on1.setVisibility(View.GONE);
					half.setVisibility(View.VISIBLE);
					spinner4.setSelection(0);
//						viewPosition.setVisibility(View.GONE);
//						position1.setVisibility(View.GONE);
//						position2.setVisibility(View.GONE);
//						position3.setVisibility(View.GONE);
//						position4.setVisibility(View.GONE);
					if(language.equals("en")){
						all_en();
					}else if(language.equals("th")){
						all_th();
					}else if(language.equals("vi")){
						all_vi();
					}
					else{
						all();
					}


				}else if(str_mode.equals("Custom")){
					mode.setVisibility(View.VISIBLE);
					team.setVisibility(View.VISIBLE);
					txt_body.setVisibility(View.VISIBLE);
					body.setVisibility(View.VISIBLE);
					ep.setVisibility(View.VISIBLE);
					poten.setVisibility(View.VISIBLE);
					gk1on1.setVisibility(View.VISIBLE);
					hidden_stat.setVisibility(View.VISIBLE);
//						viewPosition.setVisibility(View.VISIBLE);
//						position1.setVisibility(View.VISIBLE);
//						position2.setVisibility(View.VISIBLE);
//						position3.setVisibility(View.VISIBLE);
//						position4.setVisibility(View.VISIBLE);
				}
				setResult(arg2);

			}
		};
		spinner3.setOnItemSelectedListener(mOnItemSelected);

				/*모드 선택*/
			  
			  /*포지션 선택*/


		spinner4 = (Spinner)findViewById(R.id.spinner_position);


		ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.position_array,
				android.R.layout.simple_spinner_item);

		adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner4.setAdapter(adapter4);

		OnItemSelectedListener positionSelected = new OnItemSelectedListener() {
			LinearLayout hidden_stat = (LinearLayout) findViewById(R.id.hidden_lay);
			LinearLayout inputPosition = (LinearLayout) findViewById(R.id.input_position);
			TextView viewPosition = (TextView) findViewById(R.id.view_position);

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
									   int arg2, long arg3) {
				LinearLayout half = (LinearLayout) findViewById(R.id.half_lay);
				String str_position = spinner4.getSelectedItem().toString();
				String str_mode = spinner3.getSelectedItem().toString();
				if((str_position.equals("직접 입력") || str_position.equals("User Input"))&& str_mode.equals("Custom")){
					hidden_stat.setVisibility(View.VISIBLE);
					half.setVisibility(View.GONE);
					position2.setVisibility(View.GONE);
					position3.setVisibility(View.GONE);
					position4.setVisibility(View.GONE);
					inputPosition.setVisibility(View.GONE);
					reset();
				}else if((str_position.equals("전체")|| str_position.equals("All")) && str_mode.equals("Custom")){
					half.setVisibility(View.VISIBLE);
					hidden_stat.setVisibility(View.VISIBLE);
					position2.setVisibility(View.VISIBLE);
					position3.setVisibility(View.VISIBLE);
					position4.setVisibility(View.VISIBLE);
					inputPosition.setVisibility(View.VISIBLE);
					if(language.equals("en")){
						all_en();
					}else if(language.equals("th")){
						all_th();
					}else if(language.equals("vi")){
						all_vi();
					}else{
						all();
					}

				}else if(str_position.equals("ST")){
					inputPosition.setVisibility(View.GONE);
					half.setVisibility(View.GONE);
					position2.setText(null);
					position3.setText(null);
					position4.setText(null);
					if(language.equals("en"))
						st_en();
					else if(language.equals("th"))
						st_th();
					else if(language.equals("vi"))
						st_vi();
					else
						st();
				}else if(str_position.equals("CF")){
					inputPosition.setVisibility(View.GONE);
					half.setVisibility(View.GONE);
					position2.setText(null);
					position3.setText(null);
					position4.setText(null);
					if(language.equals("en"))
						cf_en();
					else if(language.equals("th"))
						cf_th();
					else if(language.equals("vi"))
						cf_vi();
					else
						cf();
				}else if(str_position.equals("LW,RW")){
					inputPosition.setVisibility(View.GONE);
					half.setVisibility(View.GONE);
					position2.setText(null);
					position3.setText(null);
					position4.setText(null);
					if(language.equals("en"))
						w_en();
					else if(language.equals("th"))
						w_th();
					else if(language.equals("vi"))
						w_vi();
					else
						w();
				}else if(str_position.equals("CAM")){
					inputPosition.setVisibility(View.GONE);
					half.setVisibility(View.GONE);
					position2.setText(null);
					position3.setText(null);
					position4.setText(null);
					if(language.equals("en"))
						cam_en();
					else if(language.equals("th"))
						cam_th();
					else if(language.equals("vi"))
						cam_vi();
					else
						cam();
				}else if(str_position.equals("CM")){
					inputPosition.setVisibility(View.GONE);
					half.setVisibility(View.GONE);
					position2.setText(null);
					position3.setText(null);
					position4.setText(null);
					if(language.equals("en"))
						cm_en();
					else if(language.equals("th"))
						cm_th();
					else if(language.equals("vi"))
						cm_vi();
					else
						cm();
				}else if(str_position.equals("CDM")){
					inputPosition.setVisibility(View.GONE);
					half.setVisibility(View.GONE);
					position2.setText(null);
					position3.setText(null);
					position4.setText(null);
					if(language.equals("en"))
						cdm_en();
					else if(language.equals("th"))
						cdm_th();
					else if(language.equals("vi"))
						cdm_vi();
					else
						cdm();
				}else if(str_position.equals("LM,RM")){
					inputPosition.setVisibility(View.GONE);
					half.setVisibility(View.GONE);
					position2.setText(null);
					position3.setText(null);
					position4.setText(null);
					if(language.equals("en"))
						wm_en();
					else if(language.equals("th"))
						wm_th();
					else if(language.equals("vi"))
						wm_vi();
					else
						wm();
				}else if(str_position.equals("CB")){
					inputPosition.setVisibility(View.GONE);
					half.setVisibility(View.GONE);
					position2.setText(null);
					position3.setText(null);
					position4.setText(null);
					if(language.equals("en"))
						cb_en();
					else if(language.equals("th"))
						cb_th();
					else if(language.equals("vi"))
						cb_vi();
					else
						cb();
				}else if(str_position.equals("LB,RB")){
					inputPosition.setVisibility(View.GONE);
					half.setVisibility(View.GONE);
					position2.setText(null);
					position3.setText(null);
					position4.setText(null);
					if(language.equals("en"))
						b_en();
					else if(language.equals("th"))
						b_th();
					else if(language.equals("vi"))
						b_vi();
					else
						b();
				}else if(str_position.equals("LWB,RWB")){
					inputPosition.setVisibility(View.GONE);
					half.setVisibility(View.GONE);
					position2.setText(null);
					position3.setText(null);
					position4.setText(null);
					if(language.equals("en"))
						wb_en();
					else if(language.equals("th"))
						wb_th();
					else if(language.equals("vi"))
						wb_vi();
					else
						wb();
				}else if(str_position.equals("SW")){
					inputPosition.setVisibility(View.GONE);
					half.setVisibility(View.GONE);
					position2.setText(null);
					position3.setText(null);
					position4.setText(null);
					if(language.equals("en"))
						sw_en();
					else if(language.equals("th"))
						sw_th();
					else if(language.equals("vi"))
						sw_vi();
					else
						sw();

				}else if(str_position.equals("GK")){
					inputPosition.setVisibility(View.GONE);
					half.setVisibility(View.GONE);
					position2.setText(null);
					position3.setText(null);
					position4.setText(null);
					if(language.equals("en"))
						gk_en();
					else if(language.equals("th"))
						gk_th();
					else if(language.equals("vi"))
						gk_vi();
					else
						gk();

				}else if(str_position.equals("직접 입력") || str_position.equals("User Input")){
					position2.setText(null);
					position3.setText(null);
					position4.setText(null);
					reset();
				}
				setResult(arg2);

			}
		};
		spinner4.setOnItemSelectedListener(positionSelected);

						/*포지션 선택*/







		ImageButton btn3 = (ImageButton)findViewById(R.id.button_result);
		btn3.setOnClickListener(this);

		et_name=(EditText)findViewById(R.id.edit_name);




		et_birth=(EditText)findViewById(R.id.edit_birth);


		et_height=(EditText)findViewById(R.id.edit_height);

		et_weight=(EditText)findViewById(R.id.edit_weight);

		et_team=(EditText)findViewById(R.id.edit_team);
		et_number=(EditText)findViewById(R.id.edit_number);


		/*********양발주	발********/
		findViewById(R.id.option1).setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v){
				printChecked(v);
			}
		});
		findViewById(R.id.option2).setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v){
				printChecked(v);
			}
		});
		et_foot_right=(EditText)findViewById(R.id.edit_foot_right);
		et_foot_right.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				if(s.toString().length() > 0){
					Log.d(tag,"2");
					if(Integer.parseInt(s.toString()) > 5){
						Log.d(tag,"3");
						et_foot_right.setText(null);
						Toast.makeText(getApplicationContext(), "1부터 5까지만 입력해주세요. Please 1 to 5 enter", Toast.LENGTH_LONG).show();
					}
				}

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
				// TODO Auto-generated method stub
				Log.w("onTextChanged", s.toString());
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Log.w("onTextChanged", s.toString());
			}
		});

		et_foot_left=(EditText)findViewById(R.id.edit_foot_left);
		et_foot_left.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				if(s.toString().length() > 0){
					Log.d(tag,"2");
					if(Integer.parseInt(s.toString()) > 5){
						Log.d(tag,"3");
						et_foot_left.setText(null);
						Toast.makeText(getApplicationContext(), "1부터 5까지만 입력해주세요. Please 1 to 5 enter", Toast.LENGTH_LONG).show();
					}
				}

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
				// TODO Auto-generated method stub
				Log.w("onTextChanged", s.toString());
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Log.w("onTextChanged", s.toString());
			}
		});


		et_ep=(EditText)findViewById(R.id.edit_ep);//가격
		et_ep.addTextChangedListener(new EpTextWatcher(getApplicationContext(), et_ep));
	 	/*일관성 선택*/
		consist = (Spinner)findViewById(R.id.spinner_consist);

		ArrayAdapter<CharSequence> adapter_consist = ArrayAdapter.createFromResource(this, R.array.consist_array,
				android.R.layout.simple_spinner_item);

		adapter_consist.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		consist.setAdapter(adapter_consist);
		/*일관성 선택*/

		hidden = (EditText) findViewById(R.id.edit_hidden);

//		position1 = (EditText) findViewById(R.id.position1);
		position2 = (EditText) findViewById(R.id.position2);
		position3 = (EditText) findViewById(R.id.position3);
		position4 = (EditText) findViewById(R.id.position4);

//		hidden1 = (EditText) findViewById(R.id.edit_hidden1);
//
//		hidden2 = (EditText) findViewById(R.id.edit_hidden2);

		// 능력치 모음
		et_star = (EditText)findViewById(R.id.edit_star);

		et_ability1 = (EditText) findViewById(R.id.edit_ability1);
		et_value1 = (EditText) findViewById(R.id.edit_value1);
		et_value1.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value1));

		et_ability2 = (EditText) findViewById(R.id.edit_ability2);
		et_value2 = (EditText) findViewById(R.id.edit_value2);
		et_value2.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value2));


		et_ability3 = (EditText) findViewById(R.id.edit_ability3);
		et_value3 = (EditText) findViewById(R.id.edit_value3);
		et_value3.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value3));

		et_ability4 = (EditText) findViewById(R.id.edit_ability4);
		et_value4 = (EditText) findViewById(R.id.edit_value4);
		et_value4.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value4));

		et_ability5 = (EditText) findViewById(R.id.edit_ability5);
		et_value5 = (EditText) findViewById(R.id.edit_value5);
		et_value5.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value5));


		et_ability6 = (EditText) findViewById(R.id.edit_ability6);
		et_value6 = (EditText) findViewById(R.id.edit_value6);
		et_value6.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value6));


		et_ability7 = (EditText) findViewById(R.id.edit_ability7);
		et_value7 = (EditText) findViewById(R.id.edit_value7);
		et_value7.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value7));


		et_ability8 = (EditText) findViewById(R.id.edit_ability8);
		et_value8 = (EditText) findViewById(R.id.edit_value8);
		et_value8.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value8));


		et_ability9 = (EditText) findViewById(R.id.edit_ability9);
		et_value9 = (EditText) findViewById(R.id.edit_value9);
		et_value9.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value9));

		et_ability10 = (EditText) findViewById(R.id.edit_ability10);
		et_value10 = (EditText) findViewById(R.id.edit_value10);
		et_value10.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value10));

		et_ability11 = (EditText) findViewById(R.id.edit_ability11);
		et_value11 = (EditText) findViewById(R.id.edit_value11);
		et_value11.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value11));

		et_ability12 = (EditText) findViewById(R.id.edit_ability12);
		et_value12 = (EditText) findViewById(R.id.edit_value12);
		et_value12.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value12));

		et_ability13 = (EditText) findViewById(R.id.edit_ability13);
		et_value13 = (EditText) findViewById(R.id.edit_value13);
		et_value13.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value13));

		et_ability14 = (EditText) findViewById(R.id.edit_ability14);
		et_value14 = (EditText) findViewById(R.id.edit_value14);
		et_value14.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value14));

		et_ability15 = (EditText) findViewById(R.id.edit_ability15);
		et_value15 = (EditText) findViewById(R.id.edit_value15);
		et_value15.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value15));

		et_ability16 = (EditText) findViewById(R.id.edit_ability16);
		et_value16 = (EditText) findViewById(R.id.edit_value16);
		et_value16.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value16));

		et_ability17 = (EditText) findViewById(R.id.edit_ability17);
		et_value17 = (EditText) findViewById(R.id.edit_value17);
		et_value17.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value17));

		et_ability18 = (EditText) findViewById(R.id.edit_ability18);
		et_value18 = (EditText) findViewById(R.id.edit_value18);
		et_value18.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value18));

		et_ability19 = (EditText) findViewById(R.id.edit_ability19);
		et_value19 = (EditText) findViewById(R.id.edit_value19);
		et_value19.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value19));

		et_ability20 = (EditText) findViewById(R.id.edit_ability20);
		et_value20 = (EditText) findViewById(R.id.edit_value20);
		et_value20.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value20));

		et_ability21 = (EditText) findViewById(R.id.edit_ability21);
		et_value21 = (EditText) findViewById(R.id.edit_value21);
		et_value21.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value21));

		et_ability22 = (EditText) findViewById(R.id.edit_ability22);
		et_value22 = (EditText) findViewById(R.id.edit_value22);
		et_value22.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value22));

		et_ability23 = (EditText) findViewById(R.id.edit_ability23);
		et_value23 = (EditText) findViewById(R.id.edit_value23);
		et_value23.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value23));

		et_ability24 = (EditText) findViewById(R.id.edit_ability24);
		et_value24 = (EditText) findViewById(R.id.edit_value24);
		et_value24.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value24));

		et_ability25 = (EditText) findViewById(R.id.edit_ability25);
		et_value25 = (EditText) findViewById(R.id.edit_value25);
		et_value25.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value25));

		et_ability26 = (EditText) findViewById(R.id.edit_ability26);
		et_value26 = (EditText) findViewById(R.id.edit_value26);
		et_value26.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value26));

		et_ability27 = (EditText) findViewById(R.id.edit_ability27);
		et_value27 = (EditText) findViewById(R.id.edit_value27);
		et_value27.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value27));

		et_ability28 = (EditText) findViewById(R.id.edit_ability28);
		et_value28 = (EditText) findViewById(R.id.edit_value28);
		et_value28.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value28));

		et_ability29 = (EditText) findViewById(R.id.edit_ability29);
		et_value29 = (EditText) findViewById(R.id.edit_value29);
		et_value29.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value29));

		et_ability30 = (EditText) findViewById(R.id.edit_ability30);
		et_value30 = (EditText) findViewById(R.id.edit_value30);
		et_value30.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value30));

		et_ability31 = (EditText) findViewById(R.id.edit_ability31);
		et_value31 = (EditText) findViewById(R.id.edit_value31);
		et_value31.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value31));

		et_ability32 = (EditText) findViewById(R.id.edit_ability32);
		et_value32 = (EditText) findViewById(R.id.edit_value32);
		et_value32.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value32));

		et_ability33 = (EditText) findViewById(R.id.edit_ability33);
		et_value33 = (EditText) findViewById(R.id.edit_value33);
		et_value33.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value33));

		et_ability34 = (EditText) findViewById(R.id.edit_ability34);
		et_value34 = (EditText) findViewById(R.id.edit_value34);
		et_value34.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value34));

		et_ability35 = (EditText) findViewById(R.id.edit_ability35);
		et_value35 = (EditText) findViewById(R.id.edit_value35);
		et_value35.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value35));

		et_ability36 = (EditText) findViewById(R.id.edit_ability36);
		et_value36 = (EditText) findViewById(R.id.edit_value36);
		et_value36.addTextChangedListener(new CustomTextWatcher(getApplicationContext(), et_value36));

	}

	/*********양발주	발********/
	public String printChecked(View v) {
		// TODO Auto-generated method stub
		CheckBox option1 = (CheckBox) findViewById(R.id.option1);
		CheckBox option2 = (CheckBox) findViewById(R.id.option2);

		String resultText = "";
		if (option1.isChecked()) {
			resultText = "left";
		}
		if (option2.isChecked()) {
			resultText = "right";
		}
		if (option1.isChecked() && option2.isChecked()) {
			resultText = "two";
		}

		return resultText;
	}
	@Override
	public void onClick(View v)
	{

		if(v.getId() == R.id.button_result){
			//선수명 입력받고 ResultActivity로 보내는 부분
			String str_mode = spinner3.getSelectedItem().toString();
			String str_position = spinner4.getSelectedItem().toString();
			//		 	String path=mImageCaptureUri.getPath();
			//		 	String str_country = country.getSelectedItem().toString();
//			 if((position1.length() == 0 || position2.length() == 0 || position3.length() == 0) && str_mode.equals("Custom") && str_position.equals("아니오")){
//				 Toast.makeText(getApplicationContext(), "포지션 3개 모두 입력해주세요.", Toast.LENGTH_LONG).show();
//			 }else{
			String str_season = season;
			String str_star = spinner2.getSelectedItem().toString();
			String str_force = force.getSelectedItem().toString(); //강화
			String str_body = body.getSelectedItem().toString(); //체격
			if(str_body.equals("미입력"))
				str_body="";
			String str_consist = consist.getSelectedItem().toString(); //일관성
			if(str_consist.equals("미입력"))
				str_consist="";
			Intent it=null;

			if(str_mode.equals("Original")){
				str_body = null;
				it = new Intent(this, OriginalActivity.class);
			}else if(str_position.equals("전체")|| str_position.equals("All") ){
				it = new Intent(this, CustomFullActivity.class);
			}else{
				it = new Intent(this, CustomActivity.class);
			}
			it.putExtra("it_name", et_name.getText().toString());
			it.putExtra("it_national", et_national.getText().toString());
			it.putExtra("it_birth", et_birth.getText().toString());
			it.putExtra("it_height", et_height.getText().toString());
			it.putExtra("it_weight", et_weight.getText().toString());
			it.putExtra("it_foot", printChecked(v)); /*********양발주발********/
			it.putExtra("it_foot_right", et_foot_right.getText().toString());
			it.putExtra("it_foot_left", et_foot_left.getText().toString());
			it.putExtra("it_hidden", hidden.getText().toString());
			it.putExtra("it_team", et_team.getText().toString());
			it.putExtra("it_number", et_number.getText().toString());
			it.putExtra("it_ep", et_ep.getText().toString());//가격

			it.putExtra("it_position2", position2.getText().toString());
			it.putExtra("it_position3", position3.getText().toString());
			it.putExtra("it_position4", position4.getText().toString());
//				 it.putExtra("it_hidden1", hidden1.getText().toString());
//				 it.putExtra("it_hidden2", hidden2.getText().toString());

			it.putExtra("it_star_msg", et_star.getText().toString());
			it.putExtra("it_ability1", et_ability1.getText().toString());
			it.putExtra("it_value1", et_value1.getText().toString());
			it.putExtra("it_ability2", et_ability2.getText().toString());
			it.putExtra("it_value2", et_value2.getText().toString());
			it.putExtra("it_ability3", et_ability3.getText().toString());
			it.putExtra("it_value3", et_value3.getText().toString());
			it.putExtra("it_ability4", et_ability4.getText().toString());
			it.putExtra("it_value4", et_value4.getText().toString());
			it.putExtra("it_ability5", et_ability5.getText().toString());
			it.putExtra("it_value5", et_value5.getText().toString());
			it.putExtra("it_ability6", et_ability6.getText().toString());
			it.putExtra("it_value6", et_value6.getText().toString());
			it.putExtra("it_ability7", et_ability7.getText().toString());
			it.putExtra("it_value7", et_value7.getText().toString());
			it.putExtra("it_ability8", et_ability8.getText().toString());
			it.putExtra("it_value8", et_value8.getText().toString());
			it.putExtra("it_ability9", et_ability9.getText().toString());
			it.putExtra("it_value9", et_value9.getText().toString());
			it.putExtra("it_ability10", et_ability10.getText().toString());
			it.putExtra("it_value10", et_value10.getText().toString());
			it.putExtra("it_ability11", et_ability11.getText().toString());
			it.putExtra("it_value11", et_value11.getText().toString());
			it.putExtra("it_ability12", et_ability12.getText().toString());
			it.putExtra("it_value12", et_value12.getText().toString());
			it.putExtra("it_ability13", et_ability13.getText().toString());
			it.putExtra("it_value13", et_value13.getText().toString());
			it.putExtra("it_ability14", et_ability14.getText().toString());
			it.putExtra("it_value14", et_value14.getText().toString());

			//전체화면 추가부분
			it.putExtra("it_ability15", et_ability15.getText().toString());
			it.putExtra("it_value15", et_value15.getText().toString());
			it.putExtra("it_ability16", et_ability16.getText().toString());
			it.putExtra("it_value16", et_value16.getText().toString());
			it.putExtra("it_ability17", et_ability17.getText().toString());
			it.putExtra("it_value17", et_value17.getText().toString());
			it.putExtra("it_ability18", et_ability18.getText().toString());
			it.putExtra("it_value18", et_value18.getText().toString());
			it.putExtra("it_ability19", et_ability19.getText().toString());
			it.putExtra("it_value19", et_value19.getText().toString());
			it.putExtra("it_ability20", et_ability20.getText().toString());
			it.putExtra("it_value20", et_value20.getText().toString());
			it.putExtra("it_ability21", et_ability21.getText().toString());
			it.putExtra("it_value21", et_value21.getText().toString());
			it.putExtra("it_ability22", et_ability22.getText().toString());
			it.putExtra("it_value22", et_value22.getText().toString());
			it.putExtra("it_ability23", et_ability23.getText().toString());
			it.putExtra("it_value23", et_value23.getText().toString());
			it.putExtra("it_ability24", et_ability24.getText().toString());
			it.putExtra("it_value24", et_value24.getText().toString());
			it.putExtra("it_ability25", et_ability25.getText().toString());
			it.putExtra("it_value25", et_value25.getText().toString());
			it.putExtra("it_ability26", et_ability26.getText().toString());
			it.putExtra("it_value26", et_value26.getText().toString());
			it.putExtra("it_ability27", et_ability27.getText().toString());
			it.putExtra("it_value27", et_value27.getText().toString());
			it.putExtra("it_ability28", et_ability28.getText().toString());
			it.putExtra("it_value28", et_value28.getText().toString());
			it.putExtra("it_ability29", et_ability29.getText().toString());
			it.putExtra("it_value29", et_value29.getText().toString());
			it.putExtra("it_ability30", et_ability30.getText().toString());
			it.putExtra("it_value30", et_value30.getText().toString());
			it.putExtra("it_ability31", et_ability31.getText().toString());
			it.putExtra("it_value31", et_value31.getText().toString());
			it.putExtra("it_ability32", et_ability32.getText().toString());
			it.putExtra("it_value32", et_value32.getText().toString());
			it.putExtra("it_ability33", et_ability33.getText().toString());
			it.putExtra("it_value33", et_value33.getText().toString());
			it.putExtra("it_ability34", et_ability34.getText().toString());
			it.putExtra("it_value34", et_value34.getText().toString());
			it.putExtra("it_ability35", et_ability35.getText().toString());
			it.putExtra("it_value35", et_value35.getText().toString());
			it.putExtra("it_ability36", et_ability36.getText().toString());
			it.putExtra("it_value36", et_value36.getText().toString());

//				 it.putExtra("it_country", str_country);	
			it.putExtra("it_season", str_season);
			it.putExtra("it_star", str_star);
			it.putExtra("it_position", str_position);
			it.putExtra("it_mode", str_mode);
			it.putExtra("it_force", str_force); //강화
			it.putExtra("it_body", str_body); //체격
			it.putExtra("it_consist", str_consist); //일관성

			it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(it);
//			 }
			//선수명 입력받고 ResultActivity로 보내는 부분
		}else if(v == alert){
			//히든 팝업창
			Context mContext = getApplicationContext();
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
			View layout = inflater.inflate(R.layout.dialog,(ViewGroup) findViewById(R.id.dialog));
			AlertDialog.Builder aDialog = new AlertDialog.Builder(ProfileActivity.this);

			aDialog.setTitle("히든스탯 목록");
			aDialog.setView(layout);


			aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
				}
			});
			AlertDialog ad = aDialog.create();
			ad.show();
		}else if(v == test){
			number();
		}


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//검사 함수
	public class CustomTextWatcher implements TextWatcher{

		Context mContext;
		TextView value;
		public CustomTextWatcher(Context context,TextView tv){
			value = tv;
			mContext = context;
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
			if(s.toString().length() > 0){
				Log.d(tag,"2");
				if(Integer.parseInt(s.toString()) > 999){
					Log.d(tag,"3");
					value.setText(null);
					Toast.makeText(getApplicationContext(), "999까지 가능합니다. limit 999", Toast.LENGTH_LONG).show();
				}
			}

		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
									  int after) {
			// TODO Auto-generated method stub
			Log.w("onTextChanged", s.toString());
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			Log.w("onTextChanged", s.toString());
		}
	}

	//검사 함수
	public class EpTextWatcher implements TextWatcher{

		Context mContext;
		TextView value;
		public EpTextWatcher(Context context,TextView tv){
			value = tv;
			mContext = context;
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
			if(s.toString().length() > 0){
				Log.d(tag,"2");
				if(Long.parseLong(s.toString()) > 99999999999999L){
					Log.d(tag,"3");
					value.setText(null);
					Toast.makeText(getApplicationContext(), "limit 99999999999999까지 가능합니다.", Toast.LENGTH_LONG).show();
				}
			}

		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
									  int after) {
			// TODO Auto-generated method stub
			Log.w("onTextChanged", s.toString());
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			Log.w("onTextChanged", s.toString());
		}
	}

	//	//검사 함수
//		public class PositionTextWatcher implements TextWatcher{
//			String[] position={"ST","CF","LW","RW","CAM","LM","RM","CM","CDM","CB","LB","RB","LWB","RWB","SW"};			
//			Context mContext;
//			TextView value;
//			public PositionTextWatcher(Context context,TextView tv){
//				value = tv;
//				mContext = context;
//			}
//			
//			
//			@Override
//			public void onTextChanged(CharSequence s, int start, int before, int count) {
//				// TODO Auto-generated method stub
//				if(s.toString().length() > 0){
//					Log.d(tag,"2");
//					if(find(position,s) == 0){
//						Log.d(tag,"3");
//						value.setText(null);
//						Toast.makeText(getApplicationContext(), "포지션을 잘못 입력하였습니다.", Toast.LENGTH_LONG).show();
//					}
//					}
//				
//			}
//			
//			@Override
//			public void beforeTextChanged(CharSequence s, int start, int count,
//					int after) {
//				// TODO Auto-generated method stub
//				Log.w("onTextChanged", s.toString());				
//			}
//			
//			@Override
//			public void afterTextChanged(Editable s) {
//				// TODO Auto-generated method stub
//				Log.w("onTextChanged", s.toString());				
//			}
//		}
	public void reset(){
		et_star.setText(null);
		et_ability1.setText(null);
		et_ability2.setText(null);
		et_ability3.setText(null);
		et_ability4.setText(null);
		et_ability5.setText(null);
		et_ability6.setText(null);
		et_ability7.setText(null);
		et_ability8.setText(null);
		et_ability9.setText(null);
		et_ability10.setText(null);
		et_ability11.setText(null);
		et_ability12.setText(null);
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);

	}
	public int find(String[] position, CharSequence s) {
		// TODO Auto-generated method stub
		return 0;
	}
	public void st(){
		et_star.setText("개인기");
		et_ability1.setText("골 결정력");
		et_ability2.setText("슛 파워");
		et_ability3.setText("중거리 슛");
		et_ability4.setText("발리 슛");
		et_ability5.setText("헤딩");
		et_ability6.setText("속력");
		et_ability7.setText("가속력");
		et_ability8.setText("반응 속도");
		et_ability9.setText("몸싸움");
		et_ability10.setText("짧은 패스");
		et_ability11.setText("볼 컨트롤");
		et_ability12.setText("드리블");
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void cf(){
		et_star.setText("개인기");
		et_ability1.setText("골 결정력");
		et_ability2.setText("슛 파워");
		et_ability3.setText("중거리 슛");
		et_ability4.setText("발리 슛");
		et_ability5.setText("헤딩");
		et_ability6.setText("속력");
		et_ability7.setText("가속력");
		et_ability8.setText("반응 속도");
		et_ability9.setText("몸싸움");
		et_ability10.setText("짧은 패스");
		et_ability11.setText("크로스");
		et_ability12.setText("볼 컨트롤");
		et_ability13.setText("드리블");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void w(){
		et_star.setText("개인기");
		et_ability1.setText("골 결정력");
		et_ability2.setText("슛 파워");
		et_ability3.setText("중거리 슛");
		et_ability4.setText("속력");
		et_ability5.setText("가속력");
		et_ability6.setText("민첩성");
		et_ability7.setText("반응 속도");
		et_ability8.setText("스태미너");
		et_ability9.setText("짧은 패스");
		et_ability10.setText("긴 패스");
		et_ability11.setText("크로스");
		et_ability12.setText("볼 컨트롤");
		et_ability13.setText("드리블");
		et_ability14.setText("시야");
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void cam(){
		et_star.setText("개인기");
		et_ability1.setText("골 결정력");
		et_ability2.setText("슛 파워");
		et_ability3.setText("중거리 슛");
		et_ability4.setText("헤딩");
		et_ability5.setText("위치 선정");
		et_ability6.setText("속력");
		et_ability7.setText("반응 속도");
		et_ability8.setText("짧은 패스");
		et_ability9.setText("긴 패스");
		et_ability10.setText("볼 컨트롤");
		et_ability11.setText("드리블");
		et_ability12.setText("시야");
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void cm(){
		et_star.setText("개인기");
		et_ability1.setText("중거리 슛");
		et_ability2.setText("헤딩");
		et_ability3.setText("위치 선정");
		et_ability4.setText("속력");
		et_ability5.setText("반응속도");
		et_ability6.setText("스태미너");
		et_ability7.setText("몸싸움");
		et_ability8.setText("짧은 패스");
		et_ability9.setText("긴 패스");
		et_ability10.setText("볼 컨트롤");
		et_ability11.setText("드리블");
		et_ability12.setText("시야");
		et_ability13.setText("태클");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void cdm(){
		et_star.setText("개인기");
		et_ability1.setText("헤딩");
		et_ability2.setText("위치 선정");
		et_ability3.setText("속력");
		et_ability4.setText("반응 속도");
		et_ability5.setText("스태미너");
		et_ability6.setText("몸싸움");
		et_ability7.setText("짧은 패스");
		et_ability8.setText("긴 패스");
		et_ability9.setText("볼 컨트롤");
		et_ability10.setText("시야");
		et_ability11.setText("태클");
		et_ability12.setText("슬라이딩 태클");
		et_ability13.setText("대인 수비");
		et_ability14.setText("적극성");
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void wm(){
		et_star.setText("개인기");
		et_ability1.setText("중거리 슛");
		et_ability2.setText("위치 선정");
		et_ability3.setText("속력");
		et_ability4.setText("가속력");
		et_ability5.setText("민첩성");
		et_ability6.setText("반응 속도");
		et_ability7.setText("스태미너");
		et_ability8.setText("짧은 패스");
		et_ability9.setText("긴 패스");
		et_ability10.setText("크로스");
		et_ability11.setText("볼 컨트롤");
		et_ability12.setText("드리블");
		et_ability13.setText("시야");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void wb(){
		et_star.setText("개인기");
		et_ability1.setText("헤딩");
		et_ability2.setText("위치 선정");
		et_ability3.setText("속력");
		et_ability4.setText("가속력");
		et_ability5.setText("반응 속도");
		et_ability6.setText("스태미너");
		et_ability7.setText("짧은 패스");
		et_ability8.setText("크로스");
		et_ability9.setText("볼 컨트롤");
		et_ability10.setText("드리블");
		et_ability11.setText("태클");
		et_ability12.setText("슬라이딩 태클");
		et_ability13.setText("대인 수비");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void b(){
		et_star.setText("개인기");
		et_ability1.setText("헤딩");
		et_ability2.setText("위치 선정");
		et_ability3.setText("속력");
		et_ability4.setText("반응 속도");
		et_ability5.setText("스태미너");
		et_ability6.setText("몸싸움");
		et_ability7.setText("짧은 패스");
		et_ability8.setText("크로스");
		et_ability9.setText("볼 컨트롤");
		et_ability10.setText("태클");
		et_ability11.setText("슬라이딩 태클");
		et_ability12.setText("대인 수비");
		et_ability13.setText("적극성");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}

	public void cb(){
		et_star.setText("개인기");
		et_ability1.setText("헤딩");
		et_ability2.setText("위치 선정");
		et_ability3.setText("속력");
		et_ability4.setText("반응 속도");
		et_ability5.setText("점프");
		et_ability6.setText("몸싸움");
		et_ability7.setText("짧은 패스");
		et_ability8.setText("볼 컨트롤");
		et_ability9.setText("태클");
		et_ability10.setText("슬라이딩 태클");
		et_ability11.setText("대인 수비");
		et_ability12.setText("적극성");
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}

	public void sw(){
		et_star.setText("개인기");
		et_ability1.setText("헤딩");
		et_ability2.setText("위치 선정");
		et_ability3.setText("가속력");
		et_ability4.setText("반응 속도");
		et_ability5.setText("점프");
		et_ability6.setText("몸싸움");
		et_ability7.setText("짧은 패스");
		et_ability8.setText("볼 컨트롤");
		et_ability9.setText("가로채기");
		et_ability10.setText("태클");
		et_ability11.setText("슬라이딩 태클");
		et_ability12.setText("대인 수비");
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void gk(){
		et_star.setText("개인기");
		et_ability1.setText("반응 속도");
		et_ability2.setText("점프");
		et_ability3.setText("GK 다이빙");
		et_ability4.setText("GK 핸들링");
		et_ability5.setText("GK 골킥");
		et_ability6.setText("GK 반응속도");
		et_ability7.setText("GK 위치 선정");
		et_ability8.setText("GK 일대일");
		et_ability9.setText(null);
		et_ability10.setText(null);
		et_ability11.setText(null);
		et_ability12.setText(null);
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value9.setText(null);
		et_value10.setText(null);
		et_value11.setText(null);
		et_value12.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}

	public void all(){
		et_star.setText("개인기");
		et_ability1.setText("골 결정력");
		et_ability2.setText("슛 파워");
		et_ability3.setText("슛 커브");
		et_ability4.setText("중거리 슛");
		et_ability5.setText("발리 슛");
		et_ability6.setText("프리킥");
		et_ability7.setText("페널티 킥");
		et_ability8.setText("헤딩");
		et_ability9.setText("위치선정");
		et_ability10.setText("속력");
		et_ability11.setText("가속력");
		et_ability12.setText("민첩성");
		et_ability13.setText("반응 속도");
		et_ability14.setText("점프");
		et_ability15.setText("스태미너");
		et_ability16.setText("몸싸움");
		et_ability17.setText("밸런스");
		et_ability18.setText("짧은 패스");
		et_ability19.setText("긴 패스");
		et_ability20.setText("크로스");
		et_ability21.setText("볼 컨트롤");
		et_ability22.setText("드리블");
		et_ability23.setText("드리블 스피드");
		et_ability24.setText("가로채기");
		et_ability25.setText("시야");
		et_ability26.setText("태클");
		et_ability27.setText("슬라이딩 태클");
		et_ability28.setText("대인 수비");
		et_ability29.setText("적극성");
		et_ability30.setText("GK 다이빙");
		et_ability31.setText("GK 핸들링");
		et_ability32.setText("GK 골킥");
		et_ability33.setText("GK 반응속도");
		et_ability34.setText("GK 위치선정");
		et_ability35.setText("GK 일대일");
		et_ability36.setText("잠재력");


	}

	public void number(){
		et_name.setText("호즐메");
		et_national.setText("안드로메다");
		et_birth.setText("1987.6.24");
		et_height.setText("192");
		et_weight.setText("95");
		et_foot_right.setText("5");
		et_foot_left.setText("5");
		hidden.setText("Tries To Beat Defensive Line, Technical Dribbler, Finess Shot, Finess Header, Takes Powerful Driven Free Kick, Long Shot Taker");
		position2.setText("st");
		position3.setText("cm");
		position4.setText("lw");
		et_team.setText("갤럭시");
		et_number.setText("9");
		et_ep.setText("4590000000");
		et_star.setText("개인기");
		et_value1.setText("83");
		et_value2.setText("90");
		et_value3.setText("96");
		et_value4.setText("89");
		et_value5.setText("92");
		et_value6.setText("97");
		et_value7.setText("88");
		et_value8.setText("89");
		et_value9.setText("89");
		et_value10.setText("92");
		et_value11.setText("90");
		et_value12.setText("85");
		et_value13.setText("91");
		et_value14.setText("88");
		et_value15.setText("97");
		et_value16.setText("95");
		et_value17.setText("91");
		et_value18.setText("88");
		et_value19.setText("92");
		et_value20.setText("92");
		et_value21.setText("92");
		et_value22.setText("90");
		et_value23.setText("84");
		et_value24.setText("94");
		et_value25.setText("87");
		et_value26.setText("82");
		et_value27.setText("87");
		et_value28.setText("83");
		et_value29.setText("11");
		et_value30.setText("19");
		et_value31.setText("18");
		et_value32.setText("17");
		et_value33.setText("18");
		et_value34.setText("16");
		et_value35.setText("15");
		et_value36.setText("82");

	}

	public void st_en(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Finishing");
		et_ability2.setText("Shot Power");
		et_ability3.setText("Long Shots");
		et_ability4.setText("Volleys");
		et_ability5.setText("Heading Accuracy");
		et_ability6.setText("Sprint Speed");
		et_ability7.setText("Acceleration");
		et_ability8.setText("Reactions");
		et_ability9.setText("Strength");
		et_ability10.setText("Short Pass");
		et_ability11.setText("Ball Control");
		et_ability12.setText("Dribbling");
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void cf_en(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Finishing");
		et_ability2.setText("Shot Power");
		et_ability3.setText("Long Shots");
		et_ability4.setText("Volleys");
		et_ability5.setText("Heading Accuracy");
		et_ability6.setText("Sprint Speed");
		et_ability7.setText("Acceleration");
		et_ability8.setText("Reactions");
		et_ability9.setText("Strength");
		et_ability10.setText("Short Pass");
		et_ability11.setText("Crossing");
		et_ability12.setText("Ball Control");
		et_ability13.setText("Dribbling");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void w_en(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Finishing");
		et_ability2.setText("Shot Power");
		et_ability3.setText("Long Shots");
		et_ability4.setText("Sprint Speed");
		et_ability5.setText("Acceleration");
		et_ability6.setText("Agility");
		et_ability7.setText("Reactions");
		et_ability8.setText("Stamina");
		et_ability9.setText("Short Pass");
		et_ability10.setText("Long Pass");
		et_ability11.setText("Crossing");
		et_ability12.setText("Ball Control");
		et_ability13.setText("Dribbling");
		et_ability14.setText("Vision");
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void cam_en(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Finishing");
		et_ability2.setText("Shot Power");
		et_ability3.setText("Long Shots");
		et_ability4.setText("Heading Accuracy");
		et_ability5.setText("Positioning");
		et_ability6.setText("Sprint Speed");
		et_ability7.setText("Reactions");
		et_ability8.setText("Short Pass");
		et_ability9.setText("Long Pass");
		et_ability10.setText("Ball Control");
		et_ability11.setText("Dribbling");
		et_ability12.setText("Vision");
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void cm_en(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Long Shots");
		et_ability2.setText("Heading Accuracy");
		et_ability3.setText("Positioning");
		et_ability4.setText("Sprint Speed");
		et_ability5.setText("Reflexes");
		et_ability6.setText("Stamina");
		et_ability7.setText("Strength");
		et_ability8.setText("Short Pass");
		et_ability9.setText("Long Pass");
		et_ability10.setText("Ball Control");
		et_ability11.setText("Dribbling");
		et_ability12.setText("Vision");
		et_ability13.setText("Standing Tackle");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void cdm_en(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Heading Accuracy");
		et_ability2.setText("Positioning");
		et_ability3.setText("Sprint Speed");
		et_ability4.setText("Reactions");
		et_ability5.setText("Stamina");
		et_ability6.setText("Strength");
		et_ability7.setText("Short Pass");
		et_ability8.setText("Long Pass");
		et_ability9.setText("Ball Control");
		et_ability10.setText("Vision");
		et_ability11.setText("Standing Tackle");
		et_ability12.setText("Sliding Tackle");
		et_ability13.setText("Marking");
		et_ability14.setText("Aggression");
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void wm_en(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Long Shots");
		et_ability2.setText("Positioning");
		et_ability3.setText("Sprint Speed");
		et_ability4.setText("Acceleration");
		et_ability5.setText("Agility");
		et_ability6.setText("Reactions");
		et_ability7.setText("Stamina");
		et_ability8.setText("Short Pass");
		et_ability9.setText("Long Pass");
		et_ability10.setText("Crossing");
		et_ability11.setText("Ball Control");
		et_ability12.setText("Dribbling");
		et_ability13.setText("Vision");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void wb_en(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Heading Accuracy");
		et_ability2.setText("Positioning");
		et_ability3.setText("Sprint Speed");
		et_ability4.setText("Acceleration");
		et_ability5.setText("Reactions");
		et_ability6.setText("Stamina");
		et_ability7.setText("Short Pass");
		et_ability8.setText("Crossing");
		et_ability9.setText("Ball Control");
		et_ability10.setText("Dribbling");
		et_ability11.setText("Standing Tackle");
		et_ability12.setText("Sliding Tackle");
		et_ability13.setText("Marking");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void b_en(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Heading Accuracy");
		et_ability2.setText("Positioning");
		et_ability3.setText("Sprint Speed");
		et_ability4.setText("Reactions");
		et_ability5.setText("Stamina");
		et_ability6.setText("Strength");
		et_ability7.setText("Short Pass");
		et_ability8.setText("Crossing");
		et_ability9.setText("Ball Control");
		et_ability10.setText("Standing Tackle");
		et_ability11.setText("Sliding Tackle");
		et_ability12.setText("Marking");
		et_ability13.setText("Aggression");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}

	public void cb_en(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Heading Accuracy");
		et_ability2.setText("Positioning");
		et_ability3.setText("Sprint Speed");
		et_ability4.setText("Reactions");
		et_ability5.setText("Jumping");
		et_ability6.setText("Strength");
		et_ability7.setText("Short Pass");
		et_ability8.setText("Ball Control");
		et_ability9.setText("Standing Tackle");
		et_ability10.setText("Sliding Tackle");
		et_ability11.setText("Marking");
		et_ability12.setText("Aggression");
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}

	public void sw_en(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Heading Accuracy");
		et_ability2.setText("Positioning");
		et_ability3.setText("Acceleration");
		et_ability4.setText("Reactions");
		et_ability5.setText("Jumping");
		et_ability6.setText("Strength");
		et_ability7.setText("Short Pass");
		et_ability8.setText("Ball Control");
		et_ability9.setText("Interceptions");
		et_ability10.setText("Standing Tackle");
		et_ability11.setText("Sliding Tackle");
		et_ability12.setText("Marking");
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void gk_en(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Reactions");
		et_ability2.setText("Jumping");
		et_ability3.setText("GK DIVING");
		et_ability4.setText("GK Handling");
		et_ability5.setText("GK Kicking");
		et_ability6.setText("GK Reflexes");
		et_ability7.setText("GK Positioning");
		et_ability8.setText("GK One On One");
		et_ability9.setText(null);
		et_ability10.setText(null);
		et_ability11.setText(null);
		et_ability12.setText(null);
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value9.setText(null);
		et_value10.setText(null);
		et_value11.setText(null);
		et_value12.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}

	public void all_en(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Finishing");
		et_ability2.setText("Shot Power");
		et_ability3.setText("Curve");
		et_ability4.setText("Long Shots");
		et_ability5.setText("Volleys");
		et_ability6.setText("Free Kick Accuracy");
		et_ability7.setText("Penalties");
		et_ability8.setText("Heading Accuracy");
		et_ability9.setText("Positioning");
		et_ability10.setText("Sprint Speed");
		et_ability11.setText("Acceleration");
		et_ability12.setText("Agility");
		et_ability13.setText("Reactions");
		et_ability14.setText("Jumping");
		et_ability15.setText("Stamina");
		et_ability16.setText("Strength");
		et_ability17.setText("Balance");
		et_ability18.setText("Short Pass");
		et_ability19.setText("Long Pass");
		et_ability20.setText("Crossing");
		et_ability21.setText("Ball Control");
		et_ability22.setText("Dribbling");
		et_ability23.setText("Dribble Speed");
		et_ability24.setText("Interceptions");
		et_ability25.setText("Vision");
		et_ability26.setText("Standing Tackle");
		et_ability27.setText("Sliding Tackle");
		et_ability28.setText("Marking");
		et_ability29.setText("Aggression");
		et_ability30.setText("GK DIVING");
		et_ability31.setText("GK Handling");
		et_ability32.setText("GK Kicking");
		et_ability33.setText("GK Reflexes");
		et_ability34.setText("GK Positioning");
		et_ability35.setText("GK One On One");
		et_ability36.setText("Potential");


	}


	public void st_th(){
		et_star.setText("Skill Moves");
		et_ability1.setText("จบสกอร์");
		et_ability2.setText("พลังการยิง");
		et_ability3.setText("ยิงไกล");
		et_ability4.setText("วอลเลย์");
		et_ability5.setText("โหม่งบอล");
		et_ability6.setText("ความเร็ว");
		et_ability7.setText("สปีดต้น");
		et_ability8.setText("ปฏิกิริยา");
		et_ability9.setText("แข็งแกร่ง");
		et_ability10.setText("ส่งสั้น");
		et_ability11.setText("ควบคุมบอล");
		et_ability12.setText("เลี้ยงบอล");
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void cf_th(){
		et_star.setText("Skill Moves");
		et_ability1.setText("จบสกอร์");
		et_ability2.setText("พลังการยิง");
		et_ability3.setText("ยิงไกล");
		et_ability4.setText("วอลเลย์");
		et_ability5.setText("โหม่งบอล");
		et_ability6.setText("ความเร็ว");
		et_ability7.setText("สปีดต้น");
		et_ability8.setText("ปฏิกิริยา");
		et_ability9.setText("แข็งแกร่ง");
		et_ability10.setText("ส่งสั้น");
		et_ability11.setText("เปิดบอล");
		et_ability12.setText("ควบคุมบอล");
		et_ability13.setText("เลี้ยงบอล");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void w_th(){
		et_star.setText("Skill Moves");
		et_ability1.setText("จบสกอร์");
		et_ability2.setText("พลังการยิง");
		et_ability3.setText("ยิงไกล");
		et_ability4.setText("ความเร็ว");
		et_ability5.setText("สปีดต้น");
		et_ability6.setText("คล่องตัว");
		et_ability7.setText("ปฏิกิริยา");
		et_ability8.setText("ความอึด");
		et_ability9.setText("ส่งสั้น");
		et_ability10.setText("ส่งไกล");
		et_ability11.setText("เปิดบอล");
		et_ability12.setText("ควบคุมบอล");
		et_ability13.setText("เลี้ยงบอล");
		et_ability14.setText("อ่านเกม");
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void cam_th(){
		et_star.setText("Skill Moves");
		et_ability1.setText("จบสกอร์");
		et_ability2.setText("พลังการยิง");
		et_ability3.setText("ยิงไกล");
		et_ability4.setText("โหม่งบอล");
		et_ability5.setText("ยืนตำแหน่ง");
		et_ability6.setText("ความเร็ว");
		et_ability7.setText("ปฏิกิริยา");
		et_ability8.setText("ส่งสั้น");
		et_ability9.setText("ส่งไกล");
		et_ability10.setText("ควบคุมบอล");
		et_ability11.setText("เลี้ยงบอล");
		et_ability12.setText("อ่านเกม");
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void cm_th(){
		et_star.setText("Skill Moves");
		et_ability1.setText("ยิงไกล");
		et_ability2.setText("โหม่งบอล");
		et_ability3.setText("ยืนตำแหน่ง");
		et_ability4.setText("ความเร็ว");
		et_ability5.setText("ปฏิกิริยา");
		et_ability6.setText("ความอึด");
		et_ability7.setText("แข็งแกร่ง");
		et_ability8.setText("ส่งสั้น");
		et_ability9.setText("ส่งไกล");
		et_ability10.setText("ควบคุมบอล");
		et_ability11.setText("เลี้ยงบอล");
		et_ability12.setText("อ่านเกม");
		et_ability13.setText("เข้าปะทะ");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void cdm_th(){
		et_star.setText("Skill Moves");
		et_ability1.setText("โหม่งบอล");
		et_ability2.setText("ยืนตำแหน่ง");
		et_ability3.setText("ความเร็ว");
		et_ability4.setText("ปฏิกิริยา");
		et_ability5.setText("ความอึด");
		et_ability6.setText("แข็งแกร่ง");
		et_ability7.setText("ส่งสั้น");
		et_ability8.setText("ส่งไกล");
		et_ability9.setText("ควบคุมบอล");
		et_ability10.setText("อ่านเกม");
		et_ability11.setText("เข้าปะทะ");
		et_ability12.setText("สไลด์");
		et_ability13.setText("ประกบตัว");
		et_ability14.setText("การบุก");
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void wm_th(){
		et_star.setText("Skill Moves");
		et_ability1.setText("ยิงไกล");
		et_ability2.setText("ยืนตำแหน่ง");
		et_ability3.setText("ความเร็ว");
		et_ability4.setText("สปีดต้น");
		et_ability5.setText("คล่องตัว");
		et_ability6.setText("ปฏิกิริยา");
		et_ability7.setText("ความอึด");
		et_ability8.setText("ส่งสั้น");
		et_ability9.setText("ส่งไกล");
		et_ability10.setText("เปิดบอล");
		et_ability11.setText("ควบคุมบอล");
		et_ability12.setText("เลี้ยงบอล");
		et_ability13.setText("อ่านเกม");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void wb_th(){
		et_star.setText("Skill Moves");
		et_ability1.setText("โหม่งบอล");
		et_ability2.setText("ยืนตำแหน่ง");
		et_ability3.setText("ความเร็ว");
		et_ability4.setText("สปีดต้น");
		et_ability5.setText("ปฏิกิริยา");
		et_ability6.setText("ความอึด");
		et_ability7.setText("ส่งสั้น");
		et_ability8.setText("เปิดบอล");
		et_ability9.setText("ควบคุมบอล");
		et_ability10.setText("เลี้ยงบอล");
		et_ability11.setText("เข้าปะทะ");
		et_ability12.setText("สไลด์");
		et_ability13.setText("ประกบตัว");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void b_th(){
		et_star.setText("Skill Moves");
		et_ability1.setText("โหม่งบอล");
		et_ability2.setText("ยืนตำแหน่ง");
		et_ability3.setText("ความเร็ว");
		et_ability4.setText("ปฏิกิริยา");
		et_ability5.setText("ความอึด");
		et_ability6.setText("แข็งแกร่ง");
		et_ability7.setText("ส่งสั้น");
		et_ability8.setText("เปิดบอล");
		et_ability9.setText("ควบคุมบอล");
		et_ability10.setText("เข้าปะทะ");
		et_ability11.setText("สไลด์");
		et_ability12.setText("ประกบตัว");
		et_ability13.setText("การบุก");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}

	public void cb_th(){
		et_star.setText("Skill Moves");
		et_ability1.setText("โหม่งบอล");
		et_ability2.setText("ยืนตำแหน่ง");
		et_ability3.setText("ความเร็ว");
		et_ability4.setText("ปฏิกิริยา");
		et_ability5.setText("กระโดด");
		et_ability6.setText("แข็งแกร่ง");
		et_ability7.setText("ส่งสั้น");
		et_ability8.setText("ควบคุมบอล");
		et_ability9.setText("เข้าปะทะ");
		et_ability10.setText("สไลด์");
		et_ability11.setText("ประกบตัว");
		et_ability12.setText("การบุก");
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}

	public void sw_th(){
		et_star.setText("Skill Moves");
		et_ability1.setText("โหม่งบอล");
		et_ability2.setText("ยืนตำแหน่ง");
		et_ability3.setText("สปีดต้น");
		et_ability4.setText("ปฏิกิริยา");
		et_ability5.setText("กระโดด");
		et_ability6.setText("แข็งแกร่ง");
		et_ability7.setText("ส่งสั้น");
		et_ability8.setText("ควบคุมบอล");
		et_ability9.setText("แย่งบอล");
		et_ability10.setText("เข้าปะทะ");
		et_ability11.setText("สไลด์");
		et_ability12.setText("ประกบตัว");
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void gk_th(){
		et_star.setText("Skill Moves");
		et_ability1.setText("ปฏิกิริยา");
		et_ability2.setText("กระโดด");
		et_ability3.setText("GK พุ่งรับ");
		et_ability4.setText("GK รับบอล");
		et_ability5.setText("GK ส่งบอล");
		et_ability6.setText("GK ปฏิกิริยา");
		et_ability7.setText("GK ยืนตำแหน่ง");
		et_ability8.setText("GK ยืนตำแหน่ง");
		et_ability9.setText(null);
		et_ability10.setText(null);
		et_ability11.setText(null);
		et_ability12.setText(null);
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value9.setText(null);
		et_value10.setText(null);
		et_value11.setText(null);
		et_value12.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}

	public void all_th(){
		et_star.setText("Skill Moves");
		et_ability1.setText("จบสกอร์");
		et_ability2.setText("พลังการยิง");
		et_ability3.setText("ยิงโค้ง");
		et_ability4.setText("ยิงไกล");
		et_ability5.setText("วอลเลย์");
		et_ability6.setText("ฟรีคิก");
		et_ability7.setText("เตะลูกโทษ");
		et_ability8.setText("โหม่งบอล");
		et_ability9.setText("ยืนตำแหน่ง");
		et_ability10.setText("ความเร็ว");
		et_ability11.setText("สปีดต้น");
		et_ability12.setText("คล่องตัว");
		et_ability13.setText("ปฏิกิริยา");
		et_ability14.setText("กระโดด");
		et_ability15.setText("ความอึด");
		et_ability16.setText("แข็งแกร่ง");
		et_ability17.setText("สมดุล");
		et_ability18.setText("ส่งสั้น");
		et_ability19.setText("ส่งไกล");
		et_ability20.setText("เปิดบอล");
		et_ability21.setText("ควบคุมบอล");
		et_ability22.setText("เลี้ยงบอล");
		et_ability23.setText("เลี้ยงบอลเร็ว");
		et_ability24.setText("แย่งบอล");
		et_ability25.setText("อ่านเกม");
		et_ability26.setText("เข้าปะทะ");
		et_ability27.setText("สไลด์");
		et_ability28.setText("ประกบตัว");
		et_ability29.setText("การบุก");
		et_ability30.setText("GK พุ่งรับ");
		et_ability31.setText("GK รับบอล");
		et_ability32.setText("GK ส่งบอล");
		et_ability33.setText("GK ปฏิกิริยา");
		et_ability34.setText("GK ยืนตำแหน่ง");
		et_ability35.setText("GK ยืนตำแหน่ง");
		et_ability36.setText("ศักยภาพ");


	}

	public void st_vi(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Dứt điểm");
		et_ability2.setText("Lực sút");
		et_ability3.setText("Sút xa");
		et_ability4.setText("Vô-lê");
		et_ability5.setText("Đánh đầu");
		et_ability6.setText("Tốc độ");
		et_ability7.setText("Tăng tốc");
		et_ability8.setText("Phản ứng");
		et_ability9.setText("Sức mạnh");
		et_ability10.setText("Chuyền ngắn");
		et_ability11.setText("Giữ bóng");
		et_ability12.setText("Rê bóng");
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void cf_vi(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Dứt điểm");
		et_ability2.setText("Lực sút");
		et_ability3.setText("Sút xa");
		et_ability4.setText("Vô-lê");
		et_ability5.setText("Đánh đầu");
		et_ability6.setText("Tốc độ");
		et_ability7.setText("Tăng tốc");
		et_ability8.setText("Phản ứng");
		et_ability9.setText("Sức mạnh");
		et_ability10.setText("Chuyền ngắn");
		et_ability11.setText("Tạt bóng");
		et_ability12.setText("Giữ bóng");
		et_ability13.setText("Rê bóng");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void w_vi(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Dứt điểm");
		et_ability2.setText("Lực sút");
		et_ability3.setText("Sút xa");
		et_ability4.setText("Tốc độ");
		et_ability5.setText("Tăng tốc");
		et_ability6.setText("Khéo léo");
		et_ability7.setText("Phản ứng");
		et_ability8.setText("Thể lực");
		et_ability9.setText("Chuyền ngắn");
		et_ability10.setText("Chuyền dài");
		et_ability11.setText("Tạt bóng");
		et_ability12.setText("Giữ bóng");
		et_ability13.setText("Rê bóng");
		et_ability14.setText("Tầm nhìn");
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void cam_vi(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Dứt điểm");
		et_ability2.setText("Lực sút");
		et_ability3.setText("Sút xa");
		et_ability4.setText("Đánh đầu");
		et_ability5.setText("Chọn vị trí");
		et_ability6.setText("Tốc độ");
		et_ability7.setText("Phản ứng");
		et_ability8.setText("Chuyền ngắn");
		et_ability9.setText("Chuyền dài");
		et_ability10.setText("Giữ bóng");
		et_ability11.setText("Rê bóng");
		et_ability12.setText("Tầm nhìn");
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void cm_vi(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Sút xa");
		et_ability2.setText("Đánh đầu");
		et_ability3.setText("Chọn vị trí");
		et_ability4.setText("Tốc độ");
		et_ability5.setText("Phản ứng");
		et_ability6.setText("Thể lực");
		et_ability7.setText("Sức mạnh");
		et_ability8.setText("Chuyền ngắn");
		et_ability9.setText("Chuyền dài");
		et_ability10.setText("Giữ bóng");
		et_ability11.setText("Rê bóng");
		et_ability12.setText("Tầm nhìn");
		et_ability13.setText("Xoạc bóng");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void cdm_vi(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Đánh đầu");
		et_ability2.setText("Chọn vị trí");
		et_ability3.setText("Tốc độ");
		et_ability4.setText("Phản ứng");
		et_ability5.setText("Thể lực");
		et_ability6.setText("Sức mạnh");
		et_ability7.setText("Chuyền ngắn");
		et_ability8.setText("Chuyền dài");
		et_ability9.setText("Giữ bóng");
		et_ability10.setText("Tầm nhìn");
		et_ability11.setText("Xoạc bóng");
		et_ability12.setText("Tranh bóng");
		et_ability13.setText("Kèm người");
		et_ability14.setText("Quyết đoán");
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void wm_vi(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Sút xa");
		et_ability2.setText("Chọn vị trí");
		et_ability3.setText("Tốc độ");
		et_ability4.setText("Tăng tốc");
		et_ability5.setText("Khéo léo");
		et_ability6.setText("Phản ứng");
		et_ability7.setText("Thể lực");
		et_ability8.setText("Chuyền ngắn");
		et_ability9.setText("Chuyền dài");
		et_ability10.setText("Tạt bóng");
		et_ability11.setText("Giữ bóng");
		et_ability12.setText("Rê bóng");
		et_ability13.setText("Tầm nhìn");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void wb_vi(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Đánh đầu");
		et_ability2.setText("Chọn vị trí");
		et_ability3.setText("Tốc độ");
		et_ability4.setText("Tăng tốc");
		et_ability5.setText("Phản ứng");
		et_ability6.setText("Thể lực");
		et_ability7.setText("Chuyền ngắn");
		et_ability8.setText("Tạt bóng");
		et_ability9.setText("Giữ bóng");
		et_ability10.setText("Rê bóng");
		et_ability11.setText("Xoạc bóng");
		et_ability12.setText("Tranh bóng");
		et_ability13.setText("Kèm người");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void b_vi(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Đánh đầu");
		et_ability2.setText("Chọn vị trí");
		et_ability3.setText("Tốc độ");
		et_ability4.setText("Phản ứng");
		et_ability5.setText("Thể lực");
		et_ability6.setText("Sức mạnh");
		et_ability7.setText("Chuyền ngắn");
		et_ability8.setText("Tạt bóng");
		et_ability9.setText("Giữ bóng");
		et_ability10.setText("Xoạc bóng");
		et_ability11.setText("Tranh bóng");
		et_ability12.setText("Kèm người");
		et_ability13.setText("Quyết đoán");
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}

	public void cb_vi(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Đánh đầu");
		et_ability2.setText("Chọn vị trí");
		et_ability3.setText("Tốc độ");
		et_ability4.setText("Phản ứng");
		et_ability5.setText("Nhảy");
		et_ability6.setText("Sức mạnh");
		et_ability7.setText("Chuyền ngắn");
		et_ability8.setText("Giữ bóng");
		et_ability9.setText("Xoạc bóng");
		et_ability10.setText("Tranh bóng");
		et_ability11.setText("Kèm người");
		et_ability12.setText("Quyết đoán");
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}

	public void sw_vi(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Đánh đầu");
		et_ability2.setText("Chọn vị trí");
		et_ability3.setText("Tăng tốc");
		et_ability4.setText("Phản ứng");
		et_ability5.setText("Nhảy");
		et_ability6.setText("Sức mạnh");
		et_ability7.setText("Chuyền ngắn");
		et_ability8.setText("Giữ bóng");
		et_ability9.setText("Cắt bóng");
		et_ability10.setText("Xoạc bóng");
		et_ability11.setText("Tranh bóng");
		et_ability12.setText("Kèm người");
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}
	public void gk_vi(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Phản ứng");
		et_ability2.setText("Nhảy");
		et_ability3.setText("TM đổ người");
		et_ability4.setText("TM bắt bóng");
		et_ability5.setText("TM phát bóng");
		et_ability6.setText("TM phản xạ");
		et_ability7.setText("TM Chọn vị trí");
		et_ability8.setText("TM One On One");
		et_ability9.setText(null);
		et_ability10.setText(null);
		et_ability11.setText(null);
		et_ability12.setText(null);
		et_ability13.setText(null);
		et_ability14.setText(null);
		et_ability15.setText(null);
		et_ability16.setText(null);
		et_ability17.setText(null);
		et_ability18.setText(null);
		et_ability19.setText(null);
		et_ability20.setText(null);
		et_ability21.setText(null);
		et_ability22.setText(null);
		et_ability23.setText(null);
		et_ability24.setText(null);
		et_ability25.setText(null);
		et_ability26.setText(null);
		et_ability27.setText(null);
		et_ability28.setText(null);
		et_ability29.setText(null);
		et_ability30.setText(null);
		et_ability31.setText(null);
		et_ability32.setText(null);
		et_ability33.setText(null);
		et_ability34.setText(null);
		et_ability35.setText(null);
		et_ability36.setText(null);
		et_value9.setText(null);
		et_value10.setText(null);
		et_value11.setText(null);
		et_value12.setText(null);
		et_value13.setText(null);
		et_value14.setText(null);
		et_value15.setText(null);
		et_value16.setText(null);
		et_value17.setText(null);
		et_value18.setText(null);
		et_value19.setText(null);
		et_value20.setText(null);
		et_value21.setText(null);
		et_value22.setText(null);
		et_value23.setText(null);
		et_value24.setText(null);
		et_value25.setText(null);
		et_value26.setText(null);
		et_value27.setText(null);
		et_value28.setText(null);
		et_value29.setText(null);
		et_value30.setText(null);
		et_value31.setText(null);
		et_value32.setText(null);
		et_value33.setText(null);
		et_value34.setText(null);
		et_value35.setText(null);
		et_value36.setText(null);
	}

	public void all_vi(){
		et_star.setText("Skill Moves");
		et_ability1.setText("Dứt điểm");
		et_ability2.setText("Lực sút");
		et_ability3.setText("Sút xoáy");
		et_ability4.setText("Sút xa");
		et_ability5.setText("Vô-lê");
		et_ability6.setText("Sút phạt");
		et_ability7.setText("Penalty");
		et_ability8.setText("Đánh đầu");
		et_ability9.setText("Chọn vị trí");
		et_ability10.setText("Tốc độ");
		et_ability11.setText("Tăng tốc");
		et_ability12.setText("Khéo léo");
		et_ability13.setText("Phản ứng");
		et_ability14.setText("Nhảy");
		et_ability15.setText("Thể lực");
		et_ability16.setText("Sức mạnh");
		et_ability17.setText("Thăng bằng");
		et_ability18.setText("Chuyền ngắn");
		et_ability19.setText("Chuyền dài");
		et_ability20.setText("Tạt bóng");
		et_ability21.setText("Giữ bóng");
		et_ability22.setText("Rê bóng");
		et_ability23.setText("Tốc độ rê bóng");
		et_ability24.setText("Cắt bóng");
		et_ability25.setText("Tầm nhìn");
		et_ability26.setText("Xoạc bóng");
		et_ability27.setText("Tranh bóng");
		et_ability28.setText("Kèm người");
		et_ability29.setText("Quyết đoán");
		et_ability30.setText("TM đổ người");
		et_ability31.setText("TM bắt bóng");
		et_ability32.setText("TM phát bóng");
		et_ability33.setText("TM phản xạ");
		et_ability34.setText("TM Chọn vị trí");
		et_ability35.setText("TM One On One");
		et_ability36.setText("Potential");


	}

}
