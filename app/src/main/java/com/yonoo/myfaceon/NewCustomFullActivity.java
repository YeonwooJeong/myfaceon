package com.yonoo.myfaceon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mocoplex.adlib.AdlibActivity;
import com.mocoplex.adlib.AdlibManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;



public class NewCustomFullActivity extends AdlibActivity implements OnClickListener{


	//private RelativeLayout mLayout; 
	private ImageView mPhotoImageView;//이미지 받기
	private ImageView foot;
	private Uri mImageCaptureUri;
	int someColor1 = Color.rgb(72,70,189);//100~109
	int someColor2 = Color.rgb(24,87,203);//90~99
	int someColor3 = Color.rgb(32,132,189);//80~89
	int someColor4 = Color.rgb(255,255,255);//70~79
	int someColor5 = Color.rgb(93,103,114);//60~69
	int someColor6 = Color.rgb(64, 64, 64);
	int someColor7 = Color.rgb(255,0,0);//180 180 180
	int someColor8 = Color.rgb(86,95,106);//포지션 평균 스탯색깔
	int someColor9 = Color.rgb(99,60,251);//110~119
	int someColor10 = Color.rgb(224,239,78);//120~
	int someColor11 = Color.rgb(77,121,20);//히든문구색깔

	private static final int PICK_FROM_CAMERA = 0;
	private static final int PICK_FROM_ALBUM = 1;
	private static final int CROP_FROM_CAMERA = 2;
	LinearLayout bar,mother=null;
	FrameLayout container=null;
	Bitmap bm = null;
	String language;

	private static final int REQUEST_CODE = 0;
	private static final String[] PERMISSIONS = new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA};
	private PermissionsChecker checker;

	// 	private ImageButton captureButton;
// 	private ImageButton mButton;
	String tag;

	Context m_context = this ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//액티비티 생성
		//createThreadAndDialog(); // 로딩메세지

		checker = new PermissionsChecker(this);

		Locale locale = getResources().getConfiguration().locale;
		language =  locale.getLanguage();

		setContentView(R.layout.new_custom_full);//result.xml출력
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

		ImageButton mButton = (ImageButton) findViewById(R.id.load);
		mPhotoImageView = (ImageView) findViewById(R.id.profile);
		mButton.setOnClickListener(this);

		ImageButton btn4 = (ImageButton)findViewById(R.id.button_share); //맨 앞으로 가기버튼
		btn4.setOnClickListener(this);

//		container.setLayoutParams(new LayoutParams(480, 900));
		bar = (LinearLayout)findViewById(R.id.bar);
		container = (FrameLayout)findViewById(R.id.main_container);

		//레이아웃 크기 조절
//		mother = (LinearLayout)findViewById(R.id.mother_container);
//		LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
//				android.view.ViewGroup.LayoutParams.MATCH_PARENT, mother.getHeight());
//		params1.height = 880;
//		mother.setLayoutParams(params1);

		//FrameLayout.LayoutParams params1 = new FrameLayout.LayoutParams(width_container, height_container);
		//FrameLayout params1 = new FrameLayout(this);
		//params1.setLayoutParams(new FrameLayout.LayoutParams(293, 589));
		//.LayoutParams(				LayoutParams.WRAP_CONTENT, container.getHeight());
		//container.setLayoutParams(new FrameLayout.LayoutParams(293, 1056));
//		params1.height = 1056;
		//container.setLayoutParams(params1);



		ImageButton captureButton = (ImageButton)findViewById(R.id.button_capture); //맨 앞으로 가기버튼
		captureButton.setOnClickListener(this);

		//선수명 받고 추출부분
		Intent it=getIntent();

		String str_value1=it.getStringExtra("it_value1");
		String str_value2=it.getStringExtra("it_value2");
		String str_value3=it.getStringExtra("it_value3");
		String str_value4=it.getStringExtra("it_value4");
		String str_value5=it.getStringExtra("it_value5");
		String str_value6=it.getStringExtra("it_value6");
		String str_value7=it.getStringExtra("it_value7");
		String str_value8=it.getStringExtra("it_value8");
		String str_value9=it.getStringExtra("it_value9");
		String str_value10=it.getStringExtra("it_value10");
		String str_value11=it.getStringExtra("it_value11");
		String str_value12=it.getStringExtra("it_value12");
		String str_value13=it.getStringExtra("it_value13");
		String str_value14=it.getStringExtra("it_value14");
		String str_value15=it.getStringExtra("it_value15");
		String str_value16=it.getStringExtra("it_value16");
		String str_value17=it.getStringExtra("it_value17");
		String str_value18=it.getStringExtra("it_value18");
		String str_value19=it.getStringExtra("it_value19");
		String str_value20=it.getStringExtra("it_value20");
		String str_value21=it.getStringExtra("it_value21");
		String str_value22=it.getStringExtra("it_value22");
		String str_value23=it.getStringExtra("it_value23");
		String str_value24=it.getStringExtra("it_value24");
		String str_value25=it.getStringExtra("it_value25");
		String str_value26=it.getStringExtra("it_value26");
		String str_value27=it.getStringExtra("it_value27");
		String str_value28=it.getStringExtra("it_value28");
		String str_value29=it.getStringExtra("it_value29");
		String str_value30=it.getStringExtra("it_value30");
		String str_value31=it.getStringExtra("it_value31");
		String str_value32=it.getStringExtra("it_value32");
		String str_value33=it.getStringExtra("it_value33");
//		String str_value34=it.getStringExtra("it_value34");
//		String str_value35=it.getStringExtra("it_value35");
//		String str_value36=it.getStringExtra("it_value36");



		//공격 참여도
		TextView txt_forward=(TextView)findViewById(R.id.edit_forward);
		txt_forward.setTextColor(someColor4);
		String str_forward_participation=it.getStringExtra("it_forward_participation");
		System.out.println(str_forward_participation);
		ImageView forward_participation = (ImageView)findViewById(R.id.forward_img);
		forward_participation.setImageDrawable(FaceonComp.getForwardParticipationBitmapDrawble(this, str_forward_participation));
		TextView forward_rate=(TextView)findViewById(R.id.forward_rate);
		forward_rate.setTextColor(someColor5);
		forward_rate.setText(FaceonComp.forward_rate);

		//수비 참여도
		TextView txt_defence=(TextView)findViewById(R.id.edit_defence);
		txt_defence.setTextColor(someColor4);
		String str_defence_participation=it.getStringExtra("it_defence_participation");
		System.out.println(str_defence_participation);
		ImageView defence_participation = (ImageView)findViewById(R.id.defence_img);
		defence_participation.setImageDrawable(FaceonComp.getDefenceParticipationBitmapDrawble(this, str_defence_participation));
		TextView defence_rate=(TextView)findViewById(R.id.defence_rate);
		defence_rate.setTextColor(someColor5);
		defence_rate.setText(FaceonComp.defence_rate);

		//칭호
		TextView txt_style=(TextView)findViewById(R.id.edit_style);
		txt_style.setTextColor(someColor4);
		String str_style1=it.getStringExtra("it_style1");
		System.out.println(str_style1);
		if(str_style1.equals("없음")|| str_style1.equals("None")){
			TextView txt_style_none=(TextView)findViewById(R.id.edit_style_none);
			txt_style_none.setTextColor(someColor5);
			txt_style_none.setText(str_style1);
		}else{
			ImageView style1 = (ImageView)findViewById(R.id.style1_img);
			style1.setImageDrawable(FaceonComp.getStyleBitmapDrawble(this, str_style1));
		}
		String str_style2=it.getStringExtra("it_style2");
		ImageView style2 = (ImageView)findViewById(R.id.style2_img);
		style2.setImageDrawable(FaceonComp.getStyleBitmapDrawble(this, str_style2));
		String str_style3=it.getStringExtra("it_style3");
		ImageView style3 = (ImageView)findViewById(R.id.style3_img);
		style3.setImageDrawable(FaceonComp.getStyleBitmapDrawble(this, str_style3));


		//팀 등번호
		String str_team=it.getStringExtra("it_team");
		TextView txt_team=(TextView)findViewById(R.id.edit_team);
		txt_team.setTextColor(someColor4);
		txt_team.setText(str_team);

		String str_number=it.getStringExtra("it_number");
		TextView txt_number=(TextView)findViewById(R.id.edit_number);
		if(str_number == null || str_number.length() == 0){
			txt_number.setText(null);
		}else{
			txt_number.setTextColor(someColor4);
			if(language.equals("en"))
				txt_number.setText("Number "+str_number);
			else
				txt_number.setText(str_number+"번");

		}


		//체격eee
		String str_body= it.getStringExtra("it_body");
		TextView txt_body=(TextView)findViewById(R.id.body);
		txt_body.setTextColor(someColor4);
		txt_body.setText(str_body);

		//강화
		String str_force= it.getStringExtra("it_force");
		ImageView force = (ImageView)findViewById(R.id.force_img);
		force.setImageDrawable(FaceonComp.getForceBitmapDrawble(this, str_force));


		String str_season= it.getStringExtra("it_season");
		ImageView season = (ImageView)findViewById(R.id.season_year);
		ImageView bg = (ImageView)findViewById(R.id.world);
		bg.setImageDrawable(FaceonComp.getBackGroundBitmapDrawble(this, str_season));
		season.setImageDrawable(FaceonComp.getSeasonBitmapDrawble(this, str_season));

		TextView txt_hide=(TextView)findViewById(R.id.edit_hide); //히든스탯 텍스트
		String str_mode = it.getStringExtra("it_mode");
		String str_position = it.getStringExtra("it_position");

//		ImageView position = (ImageView)findViewById(R.id.img_position);//포지션 이미지
//		ImageView position2 = (ImageView)findViewById(R.id.img_position2);
//		ImageView position3 = (ImageView)findViewById(R.id.img_position3);
//		ImageView position4 = (ImageView)findViewById(R.id.img_position4);
//
//		TextView txt_avg=(TextView)findViewById(R.id.avg);//평균 값
//		TextView txt_avg2=(TextView)findViewById(R.id.avg2);
//		TextView txt_avg3=(TextView)findViewById(R.id.avg3);

		TextView txt_hidden=(TextView)findViewById(R.id.edit_hidden);//히든스탯 메세지
		//주 부포지션
//		String str_position1= it.getStringExtra("it_position1").toUpperCase();
		String str_position2= it.getStringExtra("it_position2").toUpperCase();
		String str_position3= it.getStringExtra("it_position3").toUpperCase();
		String str_position4= it.getStringExtra("it_position4").toUpperCase();
		//가격
		String str_ep=it.getStringExtra("it_ep");
		TextView txt_ep=(TextView)findViewById(R.id.edit_ep);
		if(str_ep == null || str_ep.length() == 0){
			txt_ep.setText(null);
		}else{
			txt_ep.setTextColor(someColor4);
			long value = Long.parseLong(str_ep);
			DecimalFormat format = new DecimalFormat("###,###");//콤마
			format.format(value);
			String result_int = format.format(value);
			txt_ep.setText(result_int+" EP");
		}

		//체격
		String str_consist= it.getStringExtra("it_consist");
		TextView txt_consist=(TextView)findViewById(R.id.edit_consist);
		txt_consist.setTextColor(someColor4);
		txt_consist.setText(str_consist);


		if(str_mode.equals("Original")){
			txt_hide.setVisibility(View.GONE);
			txt_hidden.setVisibility(View.GONE);
//			txt_hidden1.setVisibility(View.GONE);
//			txt_hidden2.setVisibility(View.GONE);


		}else if(str_mode.equals("Custom")){
			if(str_position.equals("전체")|| str_position.equals("All")){

				txt_hidden.setVisibility(View.VISIBLE);
				allAvg(str_position2,str_position3, str_position4);
//				outputData(str_position,str_position2,str_position3);

			}


		}


		//호즐메 얼굴
		String str_name=it.getStringExtra("it_name");
		TextView txt_name=(TextView)findViewById(R.id.edit_name);
		txt_name.setTextColor(someColor4);
		txt_name.setText(str_name);
		if(str_name.equals("호즐메")){
			ImageView face = (ImageView)findViewById(R.id.profile);
			face.setImageDrawable(FaceonComp.getHozlmeBitmapDrawble(this, str_name));
		}


//		국기삽입
		String str_national=it.getStringExtra("it_national");
		TextView txt_national=(TextView)findViewById(R.id.edit_national);
		txt_national.setTextColor(someColor4);
		txt_national.setText(str_national);
		ImageView country = (ImageView)findViewById(R.id.country_img); //국기이미지
		if(language.equals("en"))
			country.setImageDrawable(FaceonComp.getCountryBitmapDrawbleEn(this, str_national));
		else
			country.setImageDrawable(FaceonComp.getCountryBitmapDrawble(this, str_national));
//		if(str_national.equals("대한민국")){
//			BitmapDrawable img_country = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.korea);
//			country.setImageDrawable(img_country);
//		}

		String str_birth=it.getStringExtra("it_birth");
		TextView txt_birth=(TextView)findViewById(R.id.edit_birth);
		txt_birth.setTextColor(someColor4);
		txt_birth.setText(str_birth);

		String str_height=it.getStringExtra("it_height");
		TextView txt_height=(TextView)findViewById(R.id.edit_height);
		txt_height.setTextColor(someColor4);
		txt_height.setText(str_height+"cm");

		String str_weight=it.getStringExtra("it_weight");
		TextView txt_weight=(TextView)findViewById(R.id.edit_weight);
		txt_weight.setTextColor(someColor4);
		txt_weight.setText(str_weight+"Kg");
		//발*******************

		String str_foot = it.getStringExtra("it_foot");/*********양발주	발********/
		String str_foot_right=it.getStringExtra("it_foot_right");
		String str_foot_left=it.getStringExtra("it_foot_left");



		if(str_foot_right == null || str_foot_right.length() == 0 || str_foot_left == null || str_foot_left.length() == 0){

			TextView txt_foot_right=(TextView)findViewById(R.id.edit_foot_right);
			txt_foot_right.setText(str_foot_right);
			TextView txt_foot_left=(TextView)findViewById(R.id.edit_foot_left);
			txt_foot_left.setText(str_foot_left);
		}else{
			int temp_right=Integer.parseInt(str_foot_right);
			int temp_left=Integer.parseInt(str_foot_left);
			if(temp_right > temp_left){
				foot = (ImageView)findViewById(R.id.foot);
				BitmapDrawable img = (BitmapDrawable) ContextCompat.getDrawable(m_context,R.drawable.rightfoot);
				foot.setImageDrawable(img);
				TextView txt_foot_right=(TextView)findViewById(R.id.edit_foot_right);
				txt_foot_right.setTextColor(someColor4);
				txt_foot_right.setText(str_foot_right);
				TextView txt_foot_left=(TextView)findViewById(R.id.edit_foot_left);
				txt_foot_left.setTextColor(someColor4);
				txt_foot_left.setText(str_foot_left);

			}else if(temp_right < temp_left){
				foot = (ImageView)findViewById(R.id.foot);
				BitmapDrawable img = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.leftfoot);
				foot.setImageDrawable(img);
				TextView txt_foot_right=(TextView)findViewById(R.id.edit_foot_right);
				txt_foot_right.setTextColor(someColor4);
				txt_foot_right.setText(str_foot_right);
				TextView txt_foot_left=(TextView)findViewById(R.id.edit_foot_left);
				txt_foot_left.setTextColor(someColor4);
				txt_foot_left.setText(str_foot_left);

			}else if(temp_right == temp_left){
				foot = (ImageView)findViewById(R.id.foot);
				BitmapDrawable img = null;
				if(str_foot.equals("left")){
					img = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.leftfoot);
				}else if(str_foot.equals("right")){
					img = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rightfoot);
				}else{
					img = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.twofoot);
				}


				foot.setImageDrawable(img);
				TextView txt_foot_right=(TextView)findViewById(R.id.edit_foot_right);
				txt_foot_right.setTextColor(someColor4);
				txt_foot_right.setText(str_foot_right);
				TextView txt_foot_left=(TextView)findViewById(R.id.edit_foot_left);
				txt_foot_left.setTextColor(someColor4);
				txt_foot_left.setText(str_foot_left);

			}
		}

		String str_hidden=it.getStringExtra("it_hidden");
		//txt_hidden.setTextColor(someColor4);
		txt_hidden.setText(str_hidden);
		txt_hidden.setTextColor(someColor11);
		txt_hidden.setText(str_hidden);

//		String str_hidden1=it.getStringExtra("it_hidden1");
//		//txt_hidden1.setTextColor(someColor4);
//		txt_hidden1.setText(str_hidden1);
//
//		String str_hidden2=it.getStringExtra("it_hidden2");
//		//txt_hidden2.setTextColor(someColor4);
//		txt_hidden2.setText(str_hidden2);

		/*별 이미지셋*/
		String str_star_msg=it.getStringExtra("it_star_msg");
		TextView txt_star=(TextView)findViewById(R.id.edit_star);
		txt_star.setTextColor(someColor4);
		txt_star.setText(str_star_msg);

		String str_star= it.getStringExtra("it_star");
		ImageView star = (ImageView)findViewById(R.id.star);
		star.setImageDrawable(FaceonComp.getStarBitmapDrawble(this, str_star));

		/*별 이미지셋*/

		String str_ability1=it.getStringExtra("it_ability1");
		TextView txt_ability1=(TextView)findViewById(R.id.edit_ability1);
		txt_ability1.setTextColor(someColor4);
		txt_ability1.setText(str_ability1);
		//색깔별 값 범위

		Log.d(tag,"컬러값1");
		if(str_value1 == null || str_value1.length() == 0){
			TextView txt_value1=(TextView)findViewById(R.id.edit_value1);
			txt_value1.setText(str_value1);
		}else{

			//색깔별 값 범위
			TextView txt_value1=(TextView)findViewById(R.id.edit_value1);

			//조건에 따른 색깔 지정
			color(txt_value1,str_value1);


		}


		String str_ability2=it.getStringExtra("it_ability2");
		TextView txt_ability2=(TextView)findViewById(R.id.edit_ability2);
		txt_ability2.setTextColor(someColor4);
		txt_ability2.setText(str_ability2);
		//색깔별 값 범위
		if(str_value2 == null || str_value2.length() == 0){
			TextView txt_value2=(TextView)findViewById(R.id.edit_value2);
			txt_value2.setText(str_value2);
		}else{

			//색깔별 값 범위
			TextView txt_value2=(TextView)findViewById(R.id.edit_value2);//

			//조건에 따른 색깔 지정
			color(txt_value2,str_value2);
		}


		String str_ability3=it.getStringExtra("it_ability3");
		TextView txt_ability3=(TextView)findViewById(R.id.edit_ability3);
		txt_ability3.setTextColor(someColor4);
		txt_ability3.setText(str_ability3);
		//색깔별 값 범위
		if(str_value3 == null || str_value3.length() == 0){
			TextView txt_value3=(TextView)findViewById(R.id.edit_value3);
			txt_value3.setText(str_value3);
		}else{

			//색깔별 값 범위
			TextView txt_value3=(TextView)findViewById(R.id.edit_value3);//

			//조건에 따른 색깔 지정
			color(txt_value3,str_value3);
		}



		String str_ability4=it.getStringExtra("it_ability4");
		TextView txt_ability4=(TextView)findViewById(R.id.edit_ability4);
		txt_ability4.setTextColor(someColor4);
		txt_ability4.setText(str_ability4);
		//색깔별 값 범위
		if(str_value4 == null || str_value4.length() == 0){
			TextView txt_value4=(TextView)findViewById(R.id.edit_value4);
			txt_value4.setText(str_value4);
		}else{

			//색깔별 값 범위
			TextView txt_value4=(TextView)findViewById(R.id.edit_value4);//

			//조건에 따른 색깔 지정
			color(txt_value4,str_value4);
		}


		String str_ability5=it.getStringExtra("it_ability5");
		TextView txt_ability5=(TextView)findViewById(R.id.edit_ability5);
		txt_ability5.setTextColor(someColor4);
		txt_ability5.setText(str_ability5);
		//색깔별 값 범위

		if(str_value5 == null || str_value5.length() == 0){
			TextView txt_value5=(TextView)findViewById(R.id.edit_value5);
			txt_value5.setText(str_value5);
		}else{

			//색깔별 값 범위
			TextView txt_value5=(TextView)findViewById(R.id.edit_value5);//

			//조건에 따른 색깔 지정
			color(txt_value5,str_value5);
		}


		String str_ability6=it.getStringExtra("it_ability6");
		TextView txt_ability6=(TextView)findViewById(R.id.edit_ability6);
		txt_ability6.setTextColor(someColor4);
		txt_ability6.setText(str_ability6);

		if(str_value6 == null || str_value6.length() == 0){
			TextView txt_value6=(TextView)findViewById(R.id.edit_value6);
			txt_value6.setText(str_value6);
		}else{

			//색깔별 값 범위
			TextView txt_value6=(TextView)findViewById(R.id.edit_value6);//

			//조건에 따른 색깔 지정
			color(txt_value6,str_value6);
		}

		String str_ability7=it.getStringExtra("it_ability7");
		TextView txt_ability7=(TextView)findViewById(R.id.edit_ability7);
		txt_ability7.setTextColor(someColor4);
		txt_ability7.setText(str_ability7);
		if(str_value7 == null || str_value7.length() == 0){
			TextView txt_value7=(TextView)findViewById(R.id.edit_value7);
			txt_value7.setText(str_value7);
		}else{

			//색깔별 값 범위
			TextView txt_value7=(TextView)findViewById(R.id.edit_value7);//

			//조건에 따른 색깔 지정
			color(txt_value7,str_value7);
		}

		String str_ability8=it.getStringExtra("it_ability8");
		TextView txt_ability8=(TextView)findViewById(R.id.edit_ability8);
		txt_ability8.setTextColor(someColor4);
		txt_ability8.setText(str_ability8);
		if(str_value8 == null || str_value8.length() == 0){
			TextView txt_value8=(TextView)findViewById(R.id.edit_value8);
			txt_value8.setText(str_value8);
		}else{

			//색깔별 값 범위
			TextView txt_value8=(TextView)findViewById(R.id.edit_value8);//

			//조건에 따른 색깔 지정
			color(txt_value8,str_value8);
		}

		String str_ability9=it.getStringExtra("it_ability9");
		TextView txt_ability9=(TextView)findViewById(R.id.edit_ability9);
		txt_ability9.setTextColor(someColor4);
		txt_ability9.setText(str_ability9);
		if(str_value9 == null || str_value9.length() == 0){
			TextView txt_value9=(TextView)findViewById(R.id.edit_value9);
			txt_value9.setText(str_value9);
		}else{

			//색깔별 값 범위
			TextView txt_value9=(TextView)findViewById(R.id.edit_value9);//

			//조건에 따른 색깔 지정
			color(txt_value9,str_value9);
		}

		String str_ability10=it.getStringExtra("it_ability10");
		TextView txt_ability10=(TextView)findViewById(R.id.edit_ability10);
		txt_ability10.setTextColor(someColor4);
		txt_ability10.setText(str_ability10);
		if(str_value10 == null || str_value10.length() == 0){
			TextView txt_value10=(TextView)findViewById(R.id.edit_value10);
			txt_value10.setText(str_value10);
		}else{

			//색깔별 값 범위
			TextView txt_value10=(TextView)findViewById(R.id.edit_value10);//

			//조건에 따른 색깔 지정
			color(txt_value10,str_value10);
		}

		String str_ability11=it.getStringExtra("it_ability11");
		TextView txt_ability11=(TextView)findViewById(R.id.edit_ability11);
		txt_ability11.setTextColor(someColor4);
		txt_ability11.setText(str_ability11);
		if(str_value11 == null || str_value11.length() == 0){
			TextView txt_value11=(TextView)findViewById(R.id.edit_value11);
			txt_value11.setText(str_value11);
		}else{

			//색깔별 값 범위
			TextView txt_value11=(TextView)findViewById(R.id.edit_value11);//

			//조건에 따른 색깔 지정
			color(txt_value11,str_value11);
		}
		String str_ability12=it.getStringExtra("it_ability12");
		TextView txt_ability12=(TextView)findViewById(R.id.edit_ability12);
		txt_ability12.setTextColor(someColor4);
		txt_ability12.setText(str_ability12);
		if(str_value12 == null || str_value12.length() == 0){
			TextView txt_value12=(TextView)findViewById(R.id.edit_value12);
			txt_value12.setText(str_value12);
		}else{

			//색깔별 값 범위
			TextView txt_value12=(TextView)findViewById(R.id.edit_value12);//

			//조건에 따른 색깔 지정
			color(txt_value12,str_value12);
		}

		String str_ability13=it.getStringExtra("it_ability13");
		TextView txt_ability13=(TextView)findViewById(R.id.edit_ability13);
		txt_ability13.setTextColor(someColor4);
		txt_ability13.setText(str_ability13);
		if(str_value13 == null || str_value13.length() == 0){
			TextView txt_value13=(TextView)findViewById(R.id.edit_value13);
			txt_value13.setText(str_value13);
		}else{

			//색깔별 값 범위
			TextView txt_value13=(TextView)findViewById(R.id.edit_value13);//
			//조건에 따른 색깔 지정
			color(txt_value13,str_value13);

		}

		String str_ability14=it.getStringExtra("it_ability14");
		TextView txt_ability14=(TextView)findViewById(R.id.edit_ability14);
		txt_ability14.setTextColor(someColor4);
		txt_ability14.setText(str_ability14);
		if(str_value14 == null || str_value14.length() == 0){
			TextView txt_value14=(TextView)findViewById(R.id.edit_value14);
			txt_value14.setText(str_value14);
		}else{

			//색깔별 값 범위
			TextView txt_value14=(TextView)findViewById(R.id.edit_value14);//
			color(txt_value14,str_value14);
		}

		String str_ability15 = it.getStringExtra("it_ability15");
		TextView txt_ability15 = (TextView) findViewById(R.id.edit_ability15);
		txt_ability15.setTextColor(someColor4);
		txt_ability15.setText(str_ability15);
		if (str_value15 == null || str_value15.length() == 0) {
			TextView txt_value15 = (TextView) findViewById(R.id.edit_value15);
			txt_value15.setText(str_value15);
		} else {

			// 색깔별값범위
			TextView txt_value15 = (TextView) findViewById(R.id.edit_value15);//
			color(txt_value15, str_value15);
		}

		String str_ability16 = it.getStringExtra("it_ability16");
		TextView txt_ability16 = (TextView) findViewById(R.id.edit_ability16);
		txt_ability16.setTextColor(someColor4);
		txt_ability16.setText(str_ability16);
		if (str_value16 == null || str_value16.length() == 0) {
			TextView txt_value16 = (TextView) findViewById(R.id.edit_value16);
			txt_value16.setText(str_value16);
		} else {

			// 색깔별값범위
			TextView txt_value16 = (TextView) findViewById(R.id.edit_value16);//
			color(txt_value16, str_value16);
		}

		String str_ability17 = it.getStringExtra("it_ability17");
		TextView txt_ability17 = (TextView) findViewById(R.id.edit_ability17);
		txt_ability17.setTextColor(someColor4);
		txt_ability17.setText(str_ability17);
		if (str_value17 == null || str_value17.length() == 0) {
			TextView txt_value17 = (TextView) findViewById(R.id.edit_value17);
			txt_value17.setText(str_value17);
		} else {

			// 색깔별값범위
			TextView txt_value17 = (TextView) findViewById(R.id.edit_value17);//
			color(txt_value17, str_value17);
		}

		String str_ability18 = it.getStringExtra("it_ability18");
		TextView txt_ability18 = (TextView) findViewById(R.id.edit_ability18);
		txt_ability18.setTextColor(someColor4);
		txt_ability18.setText(str_ability18);
		if (str_value18 == null || str_value18.length() == 0) {
			TextView txt_value18 = (TextView) findViewById(R.id.edit_value18);
			txt_value18.setText(str_value18);
		} else {

			// 색깔별값범위
			TextView txt_value18 = (TextView) findViewById(R.id.edit_value18);//
			color(txt_value18, str_value18);
		}

		String str_ability19 = it.getStringExtra("it_ability19");
		TextView txt_ability19 = (TextView) findViewById(R.id.edit_ability19);
		txt_ability19.setTextColor(someColor4);
		txt_ability19.setText(str_ability19);
		if (str_value19 == null || str_value19.length() == 0) {
			TextView txt_value19 = (TextView) findViewById(R.id.edit_value19);
			txt_value19.setText(str_value19);
		} else {

			// 색깔별값범위
			TextView txt_value19 = (TextView) findViewById(R.id.edit_value19);//
			color(txt_value19, str_value19);
		}

		String str_ability20 = it.getStringExtra("it_ability20");
		TextView txt_ability20 = (TextView) findViewById(R.id.edit_ability20);
		txt_ability20.setTextColor(someColor4);
		txt_ability20.setText(str_ability20);
		if (str_value20 == null || str_value20.length() == 0) {
			TextView txt_value20 = (TextView) findViewById(R.id.edit_value20);
			txt_value20.setText(str_value20);
		} else {

			// 색깔별값범위
			TextView txt_value20 = (TextView) findViewById(R.id.edit_value20);//
			color(txt_value20, str_value20);
		}

		String str_ability21 = it.getStringExtra("it_ability21");
		TextView txt_ability21 = (TextView) findViewById(R.id.edit_ability21);
		txt_ability21.setTextColor(someColor4);
		txt_ability21.setText(str_ability21);
		if (str_value21 == null || str_value21.length() == 0) {
			TextView txt_value21 = (TextView) findViewById(R.id.edit_value21);
			txt_value21.setText(str_value21);
		} else {

			// 색깔별값범위
			TextView txt_value21 = (TextView) findViewById(R.id.edit_value21);//
			color(txt_value21, str_value21);
		}

		String str_ability22 = it.getStringExtra("it_ability22");
		TextView txt_ability22 = (TextView) findViewById(R.id.edit_ability22);
		txt_ability22.setTextColor(someColor4);
		txt_ability22.setText(str_ability22);
		if (str_value22 == null || str_value22.length() == 0) {
			TextView txt_value22 = (TextView) findViewById(R.id.edit_value22);
			txt_value22.setText(str_value22);
		} else {

			// 색깔별값범위
			TextView txt_value22 = (TextView) findViewById(R.id.edit_value22);//
			color(txt_value22, str_value22);
		}

		String str_ability23 = it.getStringExtra("it_ability23");
		TextView txt_ability23 = (TextView) findViewById(R.id.edit_ability23);
		txt_ability23.setTextColor(someColor4);
		txt_ability23.setText(str_ability23);
		if (str_value23 == null || str_value23.length() == 0) {
			TextView txt_value23 = (TextView) findViewById(R.id.edit_value23);
			txt_value23.setText(str_value23);
		} else {

			// 색깔별값범위
			TextView txt_value23 = (TextView) findViewById(R.id.edit_value23);//
			color(txt_value23, str_value23);
		}

		String str_ability24 = it.getStringExtra("it_ability24");
		TextView txt_ability24 = (TextView) findViewById(R.id.edit_ability24);
		txt_ability24.setTextColor(someColor4);
		txt_ability24.setText(str_ability24);
		if (str_value24 == null || str_value24.length() == 0) {
			TextView txt_value24 = (TextView) findViewById(R.id.edit_value24);
			txt_value24.setText(str_value24);
		} else {

			// 색깔별값범위
			TextView txt_value24 = (TextView) findViewById(R.id.edit_value24);//
			color(txt_value24, str_value24);
		}

		String str_ability25 = it.getStringExtra("it_ability25");
		TextView txt_ability25 = (TextView) findViewById(R.id.edit_ability25);
		txt_ability25.setTextColor(someColor4);
		txt_ability25.setText(str_ability25);
		if (str_value25 == null || str_value25.length() == 0) {
			TextView txt_value25 = (TextView) findViewById(R.id.edit_value25);
			txt_value25.setText(str_value25);
		} else {

			// 색깔별값범위
			TextView txt_value25 = (TextView) findViewById(R.id.edit_value25);//
			color(txt_value25, str_value25);
		}

		String str_ability26 = it.getStringExtra("it_ability26");
		TextView txt_ability26 = (TextView) findViewById(R.id.edit_ability26);
		txt_ability26.setTextColor(someColor4);
		txt_ability26.setText(str_ability26);
		if (str_value26 == null || str_value26.length() == 0) {
			TextView txt_value26 = (TextView) findViewById(R.id.edit_value26);
			txt_value26.setText(str_value26);
		} else {

			// 색깔별값범위
			TextView txt_value26 = (TextView) findViewById(R.id.edit_value26);//
			color(txt_value26, str_value26);
		}

		String str_ability27 = it.getStringExtra("it_ability27");
		TextView txt_ability27 = (TextView) findViewById(R.id.edit_ability27);
		txt_ability27.setTextColor(someColor4);
		txt_ability27.setText(str_ability27);
		if (str_value27 == null || str_value27.length() == 0) {
			TextView txt_value27 = (TextView) findViewById(R.id.edit_value27);
			txt_value27.setText(str_value27);
		} else {

			// 색깔별값범위
			TextView txt_value27 = (TextView) findViewById(R.id.edit_value27);//
			color(txt_value27, str_value27);
		}

		String str_ability28 = it.getStringExtra("it_ability28");
		TextView txt_ability28 = (TextView) findViewById(R.id.edit_ability28);
		txt_ability28.setTextColor(someColor4);
		txt_ability28.setText(str_ability28);
		if (str_value28 == null || str_value28.length() == 0) {
			TextView txt_value28 = (TextView) findViewById(R.id.edit_value28);
			txt_value28.setText(str_value28);
		} else {

			// 색깔별값범위
			TextView txt_value28 = (TextView) findViewById(R.id.edit_value28);//
			color(txt_value28, str_value28);
		}

		String str_ability29 = it.getStringExtra("it_ability29");
		TextView txt_ability29 = (TextView) findViewById(R.id.edit_ability29);
		txt_ability29.setTextColor(someColor4);
		txt_ability29.setText(str_ability29);
		if (str_value29 == null || str_value29.length() == 0) {
			TextView txt_value29 = (TextView) findViewById(R.id.edit_value29);
			txt_value29.setText(str_value29);
		} else {

			// 색깔별값범위
			TextView txt_value29 = (TextView) findViewById(R.id.edit_value29);//
			color(txt_value29, str_value29);
		}

		String str_ability30 = it.getStringExtra("it_ability30");
		TextView txt_ability30 = (TextView) findViewById(R.id.edit_ability30);
		txt_ability30.setTextColor(someColor4);
		txt_ability30.setText(str_ability30);
		if (str_value30 == null || str_value30.length() == 0) {
			TextView txt_value30 = (TextView) findViewById(R.id.edit_value30);
			txt_value30.setText(str_value30);
		} else {

			// 색깔별값범위
			TextView txt_value30 = (TextView) findViewById(R.id.edit_value30);//
			color(txt_value30, str_value30);
		}

		String str_ability31 = it.getStringExtra("it_ability31");
		TextView txt_ability31 = (TextView) findViewById(R.id.edit_ability31);
		txt_ability31.setTextColor(someColor4);
		txt_ability31.setText(str_ability31);
		if (str_value31 == null || str_value31.length() == 0) {
			TextView txt_value31 = (TextView) findViewById(R.id.edit_value31);
			txt_value31.setText(str_value31);
		} else {

			// 색깔별값범위
			TextView txt_value31 = (TextView) findViewById(R.id.edit_value31);//
			color(txt_value31, str_value31);
		}

		String str_ability32 = it.getStringExtra("it_ability32");
		TextView txt_ability32 = (TextView) findViewById(R.id.edit_ability32);
		txt_ability32.setTextColor(someColor4);
		txt_ability32.setText(str_ability32);
		if (str_value32 == null || str_value32.length() == 0) {
			TextView txt_value32 = (TextView) findViewById(R.id.edit_value32);
			txt_value32.setText(str_value32);
		} else {

			// 색깔별값범위
			TextView txt_value32 = (TextView) findViewById(R.id.edit_value32);//
			color(txt_value32, str_value32);
		}

		String str_ability33 = it.getStringExtra("it_ability33");
		TextView txt_ability33 = (TextView) findViewById(R.id.edit_ability33);
		txt_ability33.setTextColor(someColor4);
		txt_ability33.setText(str_ability33);
		if (str_value33 == null || str_value33.length() == 0) {
			TextView txt_value33 = (TextView) findViewById(R.id.edit_value33);
			txt_value33.setText(str_value33);
		} else {

			// 색깔별값범위
			TextView txt_value33 = (TextView) findViewById(R.id.edit_value33);//
			color(txt_value33, str_value33);
		}

//		String str_ability34 = it.getStringExtra("it_ability34");
//		TextView txt_ability34 = (TextView) findViewById(R.id.edit_ability34);
//		txt_ability34.setTextColor(someColor4);
//		txt_ability34.setText(str_ability34);
//		if (str_value34 == null || str_value34.length() == 0) {
//			TextView txt_value34 = (TextView) findViewById(R.id.edit_value34);
//			txt_value34.setText(str_value34);
//		} else {
//
//			// 색깔별값범위
//			TextView txt_value34 = (TextView) findViewById(R.id.edit_value34);//
//			color(txt_value34, str_value34);
//		}
/*
		String str_ability35 = it.getStringExtra("it_ability35");
		TextView txt_ability35 = (TextView) findViewById(R.id.edit_ability35);
		txt_ability35.setTextColor(someColor4);
		txt_ability35.setText(str_ability35);
		if (str_value35 == null || str_value35.length() == 0) {
			TextView txt_value35 = (TextView) findViewById(R.id.edit_value35);
			txt_value35.setText(str_value35);
		} else {

			// 색깔별값범위
			TextView txt_value35 = (TextView) findViewById(R.id.edit_value35);//
			color(txt_value35, str_value35);
		}

		String str_ability36 = it.getStringExtra("it_ability36");
		TextView txt_ability36 = (TextView) findViewById(R.id.edit_ability36);
		txt_ability36.setTextColor(someColor4);
		txt_ability36.setText(str_ability36);
		if (str_value36 == null || str_value36.length() == 0) {
			TextView txt_value36 = (TextView) findViewById(R.id.edit_value36);
			txt_value36.setText(str_value36);
		} else {

			// 색깔별값범위
			TextView txt_value36 = (TextView) findViewById(R.id.edit_value36);//
			color(txt_value36, str_value36);
		}*/

	}
	/*	private ProgressDialog loagindDialog; // 로딩화면
	    void createThreadAndDialog() {

	         ProgressDialog
	        loagindDialog = ProgressDialog.show(this, "MyFaceOn-나만의 프로필",
	                "프로필 생성중...", true, false);

	        Thread thread = new Thread(new Runnable() {
	         	private static final int LOADING_TIME = 2000;
	            @Override
				public void run() {
	                // 시간걸리는 처리
	            	handler.sendEmptyMessageDelayed(0, LOADING_TIME);
	            }
	        });
	        thread.start();
	    }

	    private Handler handler = new Handler() {
	        @Override
			public void handleMessage(Message msg) {
	            loagindDialog.dismiss(); // 다이얼로그 삭제
	            // View갱신
	        }
	    };*/

	private void startPermissionsActivity() {
		PermissionsActivity.startActivityForResult(this, REQUEST_CODE, PERMISSIONS);
	}

	private void doTakePhotoAction()
	{
		Log.d(tag,"사진1");
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

		// 임시로 사용할 파일의 경로를 생성
		String url = "tmp.jpg";

		mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));

		intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);

		// 특정기기에서 사진을 저장못하는 문제가 있어 다음을 주석처리 합니다.
		//intent.putExtra("return-data", true);
		try{
			startActivityForResult(intent, PICK_FROM_CAMERA);
		}catch (SecurityException e) {
			if (checker.lacksPermissions(PERMISSIONS)) {
				startPermissionsActivity();
			}

			e.printStackTrace();
			if(language.equals("en") || language.equals("th") || language.equals("vi"))
				Toast.makeText(getApplicationContext(), "check phone settinig >  application manager > MyFaceon > app permission Camera approve", Toast.LENGTH_LONG).show();
			else
				Toast.makeText(getApplicationContext(), "설정 > 애플리케이션 관리자 > MyFaceOn > 앱권한에서 카메라 권한을 허용해주세요", Toast.LENGTH_LONG).show();

		}


	}


	private void doTakeAlbumAction()
	{
		// 앨범 호출
		Intent intent = new Intent(Intent.ACTION_PICK);
		intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
		startActivityForResult(intent, PICK_FROM_ALBUM);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if(resultCode != RESULT_OK)
		{
			return;
		}

		switch(requestCode)
		{
			case CROP_FROM_CAMERA:
			{
				// 크롭이 된 이후의 이미지를 넘겨 받습니다.
				// 이미지뷰에 이미지를 보여준다거나 부가적인 작업 이후에
				// 임시 파일을 삭제합니다.
				final Bundle extras = data.getExtras();

				if(extras != null)
				{
					Bitmap photo = extras.getParcelable("data");
					mPhotoImageView.setImageBitmap(photo);
				}


				// 임시 파일 삭제
				File f = new File(mImageCaptureUri.getPath());
				if(f.exists())
				{
					f.delete();
				}

				break;
			}

			case PICK_FROM_ALBUM:
			{
				// 이후의 처리가 카메라와 같으므로 일단  break없이 진행합니다.
				// 실제 코드에서는 좀더 합리적인 방법을 선택하시기 바랍니다.

				mImageCaptureUri = data.getData();
			}

			case PICK_FROM_CAMERA:
			{
				// 이미지를 가져온 이후의 리사이즈할 이미지 크기를 결정합니다.
				// 이후에 이미지 크롭 어플리케이션을 호출하게 됩니다.

				Intent intent = new Intent("com.android.camera.action.CROP");
				intent.setDataAndType(mImageCaptureUri, "image/*");

				intent.putExtra("outputX", 100);
				intent.putExtra("outputY", 100);
//	        intent.putExtra("aspectX", 1);
//	        intent.putExtra("aspectY", 1);
				intent.putExtra("scale", true);
				intent.putExtra("return-data", true);

				startActivityForResult(intent, CROP_FROM_CAMERA);


				break;
			}
		}



	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {

		View layoutMainView = this.findViewById(R.id.main_container);

		Log.w("Layout Width - ", String.valueOf(layoutMainView.getWidth()));
		Log.w("Layout Height - ", String.valueOf(layoutMainView.getHeight()));
	}
	@Override
	public void onClick(View v){
		if(v.getId() == R.id.button_capture){

			int width = bar.getWidth() ;//상단 바 레이아웃 크기
			int height = bar.getHeight() ;//상단 바 레이아웃 크기
			int width_container = container.getWidth() ;//캡쳐할 레이아웃 크기
			int height_container = container.getHeight() ;//캡쳐할 레이아웃 크기

//			container.measure(width_container,height_container);

//			  Log.d("[가로]", " : " + width);
//			  Log.d("[세로]", " : " + height);
//
//			  Log.d("[가로container]", " : " +width_container);
//			  Log.d("[세로container]", " : " + height_container);
//
			container.setDrawingCacheEnabled(true);
			container.buildDrawingCache(true);
			Bitmap captureView = Bitmap.createBitmap(width_container,
					height_container, Bitmap.Config.ARGB_8888);
			Canvas screenShotCanvas = new Canvas(captureView);
			container.draw(screenShotCanvas);
			container.setDrawingCacheEnabled(false);

//			 Log.d("[screenshot]", " : " + container.getDrawingCache());
			FileOutputStream fos;

			Intent it=getIntent();
			String new_str = it.getStringExtra("it_new");
			String str_name=it.getStringExtra("it_name");
			String str_season= it.getStringExtra("it_season");
			String str_mode = it.getStringExtra("it_mode");
			File fileRoute = null;
			fileRoute = Environment.getExternalStorageDirectory();


			try {

				File path = new File(fileRoute,"FaceOn");
				if(!path.exists()){//if(!path.isDirectory()){
					path.mkdirs();
				}

				fos = new FileOutputStream(fileRoute+"/FaceOn/"+new_str+str_mode+"-"+str_season+"-"+str_name+".png");//
				Log.d("[screenshot]", " : " + container.getDrawingCache());
				captureView.compress(Bitmap.CompressFormat.PNG, 100, fos);


				Log.d("[screenshot]", "미디어스캐닝시작");
				sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://"
						+ Environment.getExternalStorageDirectory()+"/FaceOn/"+new_str+str_mode+"-"+str_season+"-"+str_name+".png")));

				Log.d("[screenshot]", "미디어스캐닝시작");
				if(language.equals("en") || language.equals("th") || language.equals("vi"))
					Toast.makeText(getApplicationContext(), "Save complete on /sdcard/FaceOn", Toast.LENGTH_LONG).show();
				else
					Toast.makeText(getApplicationContext(), "/sdcard/FaceOn으로 저장되었습니다.", Toast.LENGTH_LONG).show();
			}catch (FileNotFoundException e) {
				if (checker.lacksPermissions(PERMISSIONS[1])) {
					startPermissionsActivity();
				}
				e.printStackTrace();
				if(language.equals("en") || language.equals("th") || language.equals("vi"))
					Toast.makeText(getApplicationContext(), "Save Failed, check phone settinig > application manager > MyFaceon > app permission storage approve", Toast.LENGTH_LONG).show();
				else
					Toast.makeText(getApplicationContext(), "저장실패.설정 > 애플리케이션 관리자 > MyFaceOn > 앱권한에서 저장공간 권한을 허용해주세요", Toast.LENGTH_LONG).show();
			}
			captureView.recycle();
			captureView = null;


		}
		else if(v.getId() == R.id.button_share){

			Intent it=getIntent();
			String new_str = it.getStringExtra("it_new");
			String str_name=it.getStringExtra("it_name");
			String str_season= it.getStringExtra("it_season");
			String str_mode = it.getStringExtra("it_mode");
			File fileRoute = null;
			fileRoute = Environment.getExternalStorageDirectory();


			File files = new File(fileRoute,"/FaceOn/"+new_str+str_mode+"-"+str_season+"-"+str_name+".png");

			if(files.exists()==true)  //파일유무확인
			{
				Intent intentSend  = new Intent(Intent.ACTION_SEND);
				intentSend.setType("image/*");
				intentSend.putExtra(Intent.EXTRA_STREAM, Uri.parse(fileRoute+"/FaceOn/"+new_str+str_mode+"-"+str_season+"-"+str_name+".png"));
				startActivity(Intent.createChooser(intentSend, "공유"));
			}else{
				Toast.makeText(getApplicationContext(), "저장을 먼저 해주세요. Please save first", Toast.LENGTH_LONG).show();
			}
		}else if(v.getId()== R.id.load){
			DialogInterface.OnClickListener cameraListener = new DialogInterface.OnClickListener()
			{
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					doTakePhotoAction();
				}
			};

			DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener()
			{
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					doTakeAlbumAction();
				}
			};

			DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener()
			{
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					dialog.dismiss();
				}
			};

			if(language.equals("en") || language.equals("th") || language.equals("vi")){
				new AlertDialog.Builder(this)
						.setTitle("Select Image")
						.setPositiveButton("Camera", cameraListener)
						.setNeutralButton("Album", albumListener)
						.setNegativeButton("Cancel", cancelListener)
						.show();
			}else{
				new AlertDialog.Builder(this)
						.setTitle("업로드할 이미지 선택")
						.setPositiveButton("사진촬영", cameraListener)
						.setNeutralButton("앨범선택", albumListener)
						.setNegativeButton("취소", cancelListener)
						.show();
			}

		}

	}
	public void color(TextView tv,String value){
		int temp13=Integer.parseInt(value);

		//색깔별 값 범위
		TextView txt_value13=tv;
		if( (99 < temp13 )&& (temp13 < 110 ) ) {
			txt_value13.setTextColor(someColor1);
			txt_value13.setText(value);//
		} else if ((89 < temp13) && (temp13 < 100)) {
			txt_value13.setTextColor(someColor2);
			txt_value13.setText(value);//
		} else if ((79 < temp13) && (temp13 < 90)) {
			txt_value13.setTextColor(someColor3);
			txt_value13.setText(value);//
		} else if ((69 < temp13) && (temp13 < 80)) {
			txt_value13.setTextColor(someColor4);
			txt_value13.setText(value);//
		} else if ((59 < temp13) && (temp13 < 70)) {
			txt_value13.setTextColor(someColor5);
			txt_value13.setText(value);//
		}  else if (60 > temp13) {
			txt_value13.setTextColor(someColor6);
			txt_value13.setText(value);//
		}  else if((109<temp13) && (temp13 < 120)){
			txt_value13.setTextColor(someColor9);
			txt_value13.setText(value);
		}else if((119<temp13)){
			txt_value13.setTextColor(someColor10);
			txt_value13.setText(value);
		}

	}
	public int avg(){
		int temp=0;
		int tempSum=0;
		ArrayList<String> list = new ArrayList<String>();
		Intent it=getIntent();
		String str_value;
		for(int i=1;i<35;i++){
			str_value=it.getStringExtra("it_value"+i);
			if(str_value == null || str_value.length() == 0){

			}else{
				list.add(str_value);
			}

			//int temp1=Integer.parseInt(str_value1);
		}
		for(int i=0;i<list.size();i++){
			String value=list.get(i);
			System.out.println("값"+value);
			temp=Integer.parseInt(value);
			tempSum +=temp;
		}
		int cnt= list.size();
		if ( cnt == 0){
			cnt = 1;
		}
		System.out.println("카운트"+cnt);
		int avg = tempSum/cnt;
		System.out.println(avg);
		return avg;
	}


//	public void outputData(String str1, String str2, String str3){
//
//			setting1(str1);
//			System.out.println("문자열------------"+str1);
//			System.out.println("값------------"+map.get(str1));
//			String avg = Integer.toString(map.get(str1));
//			TextView txt_value1=(TextView)findViewById(R.id.avg);
//			txt_value1.setTextColor(someColor8);
//			txt_value1.setText(avg);
//
//			setting2(str2);
//			String avg2 = Integer.toString(map.get(str2));
//			TextView txt_value2=(TextView)findViewById(R.id.avg2);
//			txt_value2.setTextColor(someColor8);
//			txt_value2.setText(avg2);
//
//			setting3(str3);
//			String avg3 = Integer.toString(map.get(str3));
//			TextView txt_value3=(TextView)findViewById(R.id.avg3);
//			txt_value3.setTextColor(someColor8);
//			txt_value3.setText(avg3);
//	}

	/*public void setting1(String str){
		ImageView position = (ImageView)findViewById(R.id.img_position);//포지션 이미지
		BitmapDrawable img_position = null;
		if(str.equals("ST")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.st);
			position.setImageDrawable(img_position);
		}else if(str.equals("RS")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rs);
			position.setImageDrawable(img_position);
		}else if(str.equals("LS")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.ls);
			position.setImageDrawable(img_position);
		}else if(str.equals("CF")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cf);
			position.setImageDrawable(img_position);
		}else if(str.equals("RF")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rf);
			position.setImageDrawable(img_position);
		}else if(str.equals("LF")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lf);
			position.setImageDrawable(img_position);
		}else if(str.equals("LW")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lw);
			position.setImageDrawable(img_position);
		}else if(str.equals("RW")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rw);
			position.setImageDrawable(img_position);
		}else if(str.equals("CAM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cam);
			position.setImageDrawable(img_position);
		}else if(str.equals("CM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cm);
			position.setImageDrawable(img_position);
		}else if(str.equals("CDM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cdm);
			position.setImageDrawable(img_position);
		}else if(str.equals("LM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lm);
			position.setImageDrawable(img_position);
		}else if(str.equals("RM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rm);
			position.setImageDrawable(img_position);
		}else if(str.equals("CB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cb);
			position.setImageDrawable(img_position);
		}else if(str.equals("LB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lb);
			position.setImageDrawable(img_position);
		}else if(str.equals("RB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rb);
			position.setImageDrawable(img_position);
		}else if(str.equals("LWB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lwb);
			position.setImageDrawable(img_position);
		}else if(str.equals("RWB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rwb);
			position.setImageDrawable(img_position);
		}else if(str.equals("SW")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.sw);
			position.setImageDrawable(img_position);
		}else if(str.equals("GK")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.gk);
			position.setImageDrawable(img_position);
		}
	}*/

	public void setting2(String str){
		ImageView position2 = (ImageView)findViewById(R.id.img_position2);//포지션 이미지
		BitmapDrawable img_position = null;
		if(str.equals("ST")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.st);
			position2.setImageDrawable(img_position);
		}else if(str.equals("RS")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rs);
			position2.setImageDrawable(img_position);
		}else if(str.equals("LS")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.ls);
			position2.setImageDrawable(img_position);
		}else if(str.equals("CF")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cf);
			position2.setImageDrawable(img_position);
		}else if(str.equals("RF")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rf);
			position2.setImageDrawable(img_position);
		}else if(str.equals("LF")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lf);
			position2.setImageDrawable(img_position);
		}else if(str.equals("LW")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lw);
			position2.setImageDrawable(img_position);
		}else if(str.equals("RW")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rw);
			position2.setImageDrawable(img_position);
		}else if(str.equals("CAM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cam);
			position2.setImageDrawable(img_position);
		}else if(str.equals("CM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cm);
			position2.setImageDrawable(img_position);
		}else if(str.equals("CDM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cdm);
			position2.setImageDrawable(img_position);
		}else if(str.equals("LM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lm);
			position2.setImageDrawable(img_position);
		}else if(str.equals("RM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rm);
			position2.setImageDrawable(img_position);
		}else if(str.equals("CB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cb);
			position2.setImageDrawable(img_position);
		}else if(str.equals("LB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lb);
			position2.setImageDrawable(img_position);
		}else if(str.equals("RB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rb);
			position2.setImageDrawable(img_position);
		}else if(str.equals("LWB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lwb);
			position2.setImageDrawable(img_position);
		}else if(str.equals("RWB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rwb);
			position2.setImageDrawable(img_position);
		}else if(str.equals("SW")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.sw);
			position2.setImageDrawable(img_position);
		}else if(str.equals("GK")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.gk);
			position2.setImageDrawable(img_position);
		}
	}

	public void setting3(String str){
		ImageView position3 = (ImageView)findViewById(R.id.img_position3);//포지션 이미지
		BitmapDrawable img_position = null;
		if(str.equals("ST")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.st);
			position3.setImageDrawable(img_position);
		}else if(str.equals("RS")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rs);
			position3.setImageDrawable(img_position);
		}else if(str.equals("LS")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.ls);
			position3.setImageDrawable(img_position);
		}else if(str.equals("CF")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cf);
			position3.setImageDrawable(img_position);
		}else if(str.equals("RF")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rf);
			position3.setImageDrawable(img_position);
		}else if(str.equals("LF")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lf);
			position3.setImageDrawable(img_position);
		}else if(str.equals("LW")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lw);
			position3.setImageDrawable(img_position);
		}else if(str.equals("RW")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rw);
			position3.setImageDrawable(img_position);
		}else if(str.equals("CAM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cam);
			position3.setImageDrawable(img_position);
		}else if(str.equals("CM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cm);
			position3.setImageDrawable(img_position);
		}else if(str.equals("CDM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cdm);
			position3.setImageDrawable(img_position);
		}else if(str.equals("LM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lm);
			position3.setImageDrawable(img_position);
		}else if(str.equals("RM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rm);
			position3.setImageDrawable(img_position);
		}else if(str.equals("CB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cb);
			position3.setImageDrawable(img_position);
		}else if(str.equals("LB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lb);
			position3.setImageDrawable(img_position);
		}else if(str.equals("RB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rb);
			position3.setImageDrawable(img_position);
		}else if(str.equals("LWB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lwb);
			position3.setImageDrawable(img_position);
		}else if(str.equals("RWB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rwb);
			position3.setImageDrawable(img_position);
		}else if(str.equals("SW")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.sw);
			position3.setImageDrawable(img_position);
		}else if(str.equals("GK")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.gk);
			position3.setImageDrawable(img_position);
		}
	}

	public void setting4(String str){
		ImageView position4 = (ImageView)findViewById(R.id.img_position4);//포지션 이미지
		BitmapDrawable img_position = null;
		if(str.equals("ST")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.st);
			position4.setImageDrawable(img_position);
		}else if(str.equals("RS")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rs);
			position4.setImageDrawable(img_position);
		}else if(str.equals("LS")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.ls);
			position4.setImageDrawable(img_position);
		}else if(str.equals("CF")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cf);
			position4.setImageDrawable(img_position);
		}else if(str.equals("RF")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rf);
			position4.setImageDrawable(img_position);
		}else if(str.equals("LF")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lf);
			position4.setImageDrawable(img_position);
		}else if(str.equals("LW")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lw);
			position4.setImageDrawable(img_position);
		}else if(str.equals("RW")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rw);
			position4.setImageDrawable(img_position);
		}else if(str.equals("CAM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cam);
			position4.setImageDrawable(img_position);
		}else if(str.equals("CM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cm);
			position4.setImageDrawable(img_position);
		}else if(str.equals("CDM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cdm);
			position4.setImageDrawable(img_position);
		}else if(str.equals("LM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lm);
			position4.setImageDrawable(img_position);
		}else if(str.equals("RM")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rm);
			position4.setImageDrawable(img_position);
		}else if(str.equals("CB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.cb);
			position4.setImageDrawable(img_position);
		}else if(str.equals("LB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lb);
			position4.setImageDrawable(img_position);
		}else if(str.equals("RB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rb);
			position4.setImageDrawable(img_position);
		}else if(str.equals("LWB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.lwb);
			position4.setImageDrawable(img_position);
		}else if(str.equals("RWB")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.rwb);
			position4.setImageDrawable(img_position);
		}else if(str.equals("SW")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.sw);
			position4.setImageDrawable(img_position);
		}else if(str.equals("GK")){
			img_position = (BitmapDrawable)ContextCompat.getDrawable(m_context,R.drawable.gk);
			position4.setImageDrawable(img_position);
		}
	}

	public void allAvg(String str2, String str3, String str4) {
		int temp = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();// 총 합
		Intent it = getIntent();
		String str_value;
		for (int i = 1; i < 35; i++) {
			str_value = it.getStringExtra("it_value" + i);
			if (str_value == null || str_value.length() == 0) {
				list.add(temp);
			} else {
				int tempVal = Integer.parseInt(str_value);
				list.add(tempVal);
			}

			// int temp1=Integer.parseInt(str_value1);
		}
		// for(int i=0; i<34 ;i ++){
		// System.out.println(i+"번째 값 "+list.get(i));
		// }
		int st_temp = list.get(0)*18 + list.get(1)*10 + list.get(3)*3 + list.get(4)*2
				+ list.get(7)*10 + list.get(8)*13/*위치선정*/ +list.get(9)*5 + list.get(10)*4 + list.get(12)*8
				+ list.get(15)*5 + list.get(17)*5 + list.get(20)*10 + list.get(21)*7;
		int st_sum = st_temp;
		int st_avg = (st_sum / 100);
		map.put("ST", st_avg);
		map.put("RS", st_avg);
		map.put("LS", st_avg);

		int cf_sum = list.get(0)*11 + list.get(1)*5 + list.get(3)*4
				+ list.get(7)*2 + list.get(8)*13/*위치선정*/ + list.get(9)*5 + list.get(10)*5 + list.get(12)*9
				+ list.get(17)*9 + list.get(20)*15
				+ list.get(21)*14 + list.get(23)*8/*시야*/;
		int cf_avg = (cf_sum / 100);
		map.put("CF", cf_avg);

		int lf_sum = list.get(0)*11 + list.get(1)*5 + list.get(3)*4
				+ list.get(7)*2 + list.get(8)*13/*위치선정*/ + list.get(9)*5 + list.get(10)*5 + list.get(12)*9
				+ list.get(17)*9 + list.get(20)*15
				+ list.get(21)*14 + list.get(23)*8/*시야*/;
		int lf_avg = lf_sum / 100;
		map.put("LF", lf_avg);
		map.put("RF", lf_avg);

		int lw_sum = list.get(0)*4 + list.get(3)*3 + list.get(8)*12/*위치선정*/ + list.get(9)*9
				+ list.get(10)*11 + list.get(11)*5 + list.get(12)*5
				+ list.get(17)*10 + list.get(19)*12 + list.get(20)*10
				+ list.get(21)*15 + list.get(23)*4;
		int lw_avg = (lw_sum / 100);
		map.put("LW", lw_avg);
		map.put("RW", lw_avg);

		int cam_sum = list.get(0)*7 + list.get(3)*5
				+ list.get(8)*9 + list.get(9)*3 + list.get(10)*4/*가속력*/ + list.get(11)*3/*민첩성*/
				+ list.get(12)*7 + list.get(17)*16
				+ list.get(18)*4 + list.get(20)*15 + list.get(21)*13 + list.get(23)*14;
		int cam_avg = cam_sum / 100;
		map.put("CAM", cam_avg);
		map.put("RAM", cam_avg);
		map.put("LAM", cam_avg);

		int cm_sum = list.get(0)*10/*골결정력*/ + list.get(3)*5 + list.get(8)*6
				+ list.get(12)*5 + list.get(14)*5 + list.get(17)*15
				+ list.get(18)*12 + list.get(20)*10 + list.get(21)*10 + list.get(22)*8/*가로채기*/
				+ list.get(23)*10 + list.get(24)*5;
		int cm_avg = cm_sum / 100;
		map.put("CM", cm_avg);
		map.put("RCM", cm_avg);
		map.put("LCM", cm_avg);

		int cdm_sum = list.get(12)*7
				+ list.get(14)*6 + list.get(15)*4 + list.get(17)*14+ list.get(18)*10 +
				list.get(20)*10+ list.get(22)*14/*가로채기*/ + list.get(23)*4 + list.get(24)*12
				+ list.get(25)*5 + list.get(26)*9 + list.get(27)*5;
		int cdm_avg = (cdm_sum / 100);
		map.put("CDM", cdm_avg);
		map.put("RDM", cdm_avg);
		map.put("LDM", cdm_avg);

		int lm_sum = list.get(0)*6/*골결정력*/ + list.get(8)*8 + list.get(9)*6 + list.get(10)*7
				+ list.get(12)*7 + list.get(14)*5 + list.get(17)*11
				+ list.get(18)*5 + list.get(19)*10 + list.get(20)*13 +  list.get(21)*15
				+ list.get(23)*7;
		int lm_avg = lm_sum / 100;
		map.put("LM", lm_avg);
		map.put("RM", lm_avg);

		int cb_sum = list.get(7)*10 + list.get(9)*2 + list.get(12)*5
				+ list.get(13)*3 + list.get(15)*10 + list.get(17)*5 + list.get(20)*4
				+ list.get(22)*13/*가로채기*/ + list.get(24)*17 + list.get(25)*10
				+ list.get(26)*14 + list.get(27)*7;
		int cb_avg = (cb_sum / 100);
		map.put("CB", cb_avg);
		map.put("RCB", cb_avg);
		map.put("LCB", cb_avg);


		int lb_sum = list.get(7)*4 + list.get(9)*7 + list.get(10)*5/*가속력*/ + list.get(12)*8
				+ list.get(14)*8 + list.get(17)*7 + list.get(19)*9
				+ list.get(20)*7 + list.get(22)*12/*가로채기*/ + list.get(24)*11 + list.get(25)*14
				+ list.get(26)*8;
		int lb_avg = (lb_sum / 100);
		map.put("LB", lb_avg);
		map.put("RB", lb_avg);


		int rwb_sum = list.get(9)*8 + list.get(10)*7
				+ list.get(12)*5 + list.get(14)*8 + list.get(17)*8 + list.get(19)*8
				+ list.get(20)*10 + list.get(21)*5 + list.get(22)*7/*가로채기*/ + list.get(24)*12 + list.get(25)*10
				+ list.get(26)*12;
		int rwb_avg = rwb_sum / 100;
		map.put("RWB", rwb_avg);
		map.put("LWB", rwb_avg);

		int sw_sum = list.get(7)*8 + list.get(12)*9
				+ list.get(13)*5 + list.get(15)*5 + list.get(17)*6 + list.get(20)*7
				+ list.get(22)*10/*가로채기*/ + list.get(24)*15 + list.get(25)*10 + list.get(26)*15
				+ list.get(27)*10 /*적극성*/;
		int sw_avg = sw_sum / 100;
		map.put("SW", sw_avg);

		int gk_sum = list.get(12)*11 + list.get(28)*21
				+ list.get(29)*21 + list.get(30)*5 + list.get(31)*21 + list.get(32)*21;
		int gk_avg = (gk_sum / 100);
		map.put("GK", gk_avg);

		try{
			if(str2.length() != 0){
				setting2(str2);
				String avg2 = Integer.toString(map.get(str2));
				TextView txt_value2=(TextView)findViewById(R.id.avg2);
				txt_value2.setTextColor(someColor8);
				txt_value2.setText(avg2);
			}
			if(str3.length() != 0 ){
				setting3(str3);
				String avg3 = Integer.toString(map.get(str3));
				TextView txt_value3=(TextView)findViewById(R.id.avg3);
				txt_value3.setTextColor(someColor8);
				txt_value3.setText(avg3);
			}
			if(str4.length() != 0 ){
				setting4(str4);
				String avg4 = Integer.toString(map.get(str4));
				TextView txt_value4=(TextView)findViewById(R.id.avg4);
				txt_value4.setTextColor(someColor8);
				txt_value4.setText(avg4);
			}

		}catch(NullPointerException e){
			Toast.makeText(getApplicationContext(), "잘못 입력된 포지션이 있습니다.", Toast.LENGTH_LONG).show();
		}

		// System.out.println("unsorted map");
		// for (String key : map.keySet()) {
		// int value =
		// Integer.parseInt(String.valueOf(Math.round(map.get(key))));
		// System.out.println("key/value: " + key + "/" +
		// value/*map.get(key)*/);
		// }

		// System.out.println("results");


		// for(int i=0; i<resultList.size();i ++){
		// System.out.println(i+"번째"+resultList.get(i));
		// }
	}

}

/*class ValueComparator implements Comparator<Object> {
	Map<String, Double> base;

	public ValueComparator(Map<String, Double> base) {
		this.base = base;
	}

	@Override
	public int compare(Object a, Object b) {
		if (base.get(a) < base.get(b)) {
			return 1;
		} else if (base.get(a) == base.get(b)) {
			return 0;
		} else {
			return -1;
		}
	}

}
*/



