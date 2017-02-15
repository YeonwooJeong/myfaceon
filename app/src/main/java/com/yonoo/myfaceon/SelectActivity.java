package com.yonoo.myfaceon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.multidex.MultiDex;
import com.mocoplex.adlib.AdlibActivity;
import com.mocoplex.adlib.AdlibConfig;
import com.mocoplex.adlib.AdlibManager;

import java.util.Calendar;
import java.util.Locale;
//import android.view.MotionEvent;


public class SelectActivity extends AdlibActivity implements OnClickListener{
	String tag;
	private static final int MSG_TIMER_EXPIRED = 1;

	private static final int BACKEY_TIMEOUT = 2000;

	private boolean mIsBackKeyPressed = false;

	private long mCurrentTimeInMillis = 0;
	private AdlibManager _amanager;
	String language;

	public boolean onKeyDown(int keyCode, KeyEvent event){
		//Back키 눌렀을 때 dialog 닫히는것 막기
		Locale locale = getResources().getConfiguration().locale;
		language =  locale.getLanguage();
		if(language.equals("en") || language.equals("th") || language.equals("vi")){
			_amanager.showAdDialog("Cancel", "OK", "Are you want to quit the app?");
		}else{
			_amanager.showAdDialog("취소", "확인", "App 을 정말로 종료하시겠습니까?");
		}
		if(keyCode == KeyEvent.KEYCODE_BACK){
			// 종료 대화상자 광고를 노출하기 위해서 호출합니다.


		}
		return super.onKeyDown(keyCode, event);
	}
//	@Override
//	public void onBackPressed() {
//		if (mIsBackKeyPressed == false) {
//			mIsBackKeyPressed = true;
//
//			mCurrentTimeInMillis = Calendar.getInstance().getTimeInMillis();
//
//			Toast.makeText(this, "뒤로 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT)
//					.show();
//			startTimer();
//		} else {
//			mIsBackKeyPressed = false;
//
//			if (Calendar.getInstance().getTimeInMillis() <= (mCurrentTimeInMillis + (BACKEY_TIMEOUT))) {
//				finish();
//			}
//		}
//	}

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

	protected void initAds() {
		// 광고 스케줄링 설정을 위해 아래 내용을 프로그램 실행시 한번만 실행합니다. (처음 실행되는 activity에서 한번만
		// 호출해주세요.)
		// 광고 subview 의 패키지 경로를 설정합니다. (실제로 작성된 패키지 경로로 수정해주세요.)
		// 쓰지 않을 광고플랫폼은 삭제해주세요.

		AdlibConfig.getInstance().bindPlatform("ADMOB",	"test.adlib.project.ads.SubAdlibAdViewAdmob");

		// 쓰지 않을 플랫폼은 JAR 파일 및 test.adlib.project.ads 경로에서 삭제하면 최종 바이너리 크기를 줄일 수
		// 있습니다.
		// SMART* dialog 노출 시점 선택시 / setAdlibKey 키가 호출되는 activity 가 시작 activity
		// 이며 해당 activity가 종료되면 app 종료로 인식합니다.
		// adlibr.com 에서 발급받은 api 키를 입력합니다.
		// https://sec.adlibr.com/admin/dashboard.jsp
		_amanager = new AdlibManager(AdlibTestProjectConstants.ADLIB_API_KEY);
		_amanager.onCreate(this);
//		setAdlibKey("51e8043ce4b05aca86e7231b");
		// AdlibConfig.getInstance().setAdInfo("M", "20", "31.111", "127.111");

	}

	@Override
	protected void attachBaseContext(Context context) {
		super.attachBaseContext(context);
		MultiDex.install(this);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//액티비티 생성
		setContentView(R.layout.select);//select.xml출력
		initAds();

//		 this.setAdsContainer(R.id.ads);
		// 실제 광고 호출이 될 adview 를 연결합니다.

//		Button btn = (Button)findViewById(R.id.button_original);
//		btn.setOnClickListener(this);
		Button btn1 = (Button)findViewById(R.id.button1);
		btn1.setOnClickListener(this);

		Button btn2 = (Button)findViewById(R.id.button_custom);
		btn2.setOnClickListener(this);

//		btn.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/NEXONFootballGothicB.ttf"));
		btn2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/NEXONFootballGothicB.ttf"));

		ImageView iv = (ImageView) findViewById(R.id.img);

		iv.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				startActivity(new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://m.facebook.com/myfaceonprofile")));
			}

		});

		ImageView club = (ImageView) findViewById(R.id.club);

		club.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				startActivity(new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://m.facebook.com/tonystarkclub")));
			}

		});


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public void onClick(View v){
		Intent it = new Intent(this, ManualActivity.class);
		//Intent it = new Intent(this, OriginalActivity.class);
//		if(v.getId() == R.id.button_original){
//			startActivity(it);
//			
//		}
		if(v.getId() == R.id.button_custom){
			String st1 = getString(R.string.select);
			final Intent it1 = new Intent(this, ProfileActivity.class);
			final Intent it2 = new Intent(this, NewProfileActivity.class);
			AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
			alt_bld.setMessage(st1).setCancelable(false)
					.setPositiveButton("New Update Ver.", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int id) {
							startActivity(it2);
						}
					}).setNegativeButton("Original Ver.", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int id) {
					// Action for 'NO' Button
					startActivity(it1);
				}
			});
			AlertDialog alert = alt_bld.create();
			// Title for AlertDialog
			alert.setCancelable(true);
			alert.setCanceledOnTouchOutside(true);
			alert.setTitle("Select Version");
			// Icon for AlertDialog
			alert.show();

			//Intent it2 = new Intent(this, SelectActivity2.class);

		}
		if(v.getId() == R.id.button1){
			String st1 = getString(R.string.select);
			final Intent it1 = new Intent(this, ProfileActivity.class);
			final Intent it2 = new Intent(this, NewProfileActivity.class);
			AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
			alt_bld.setMessage(st1).setCancelable(false)
					.setPositiveButton("New Update Ver.", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int id) {
							startActivity(it1);
						}
					}).setNegativeButton("Original Ver.", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int id) {
					// Action for 'NO' Button
					startActivity(it2);
				}
			});
			AlertDialog alert = alt_bld.create();
			// Title for AlertDialog
			alert.setCancelable(true);
			alert.setCanceledOnTouchOutside(true);
			alert.setTitle("Select Version");
			// Icon for AlertDialog
			alert.show();
		}
	}

	protected void onResume() {
		_amanager.onResume(this);
		super.onResume();
	}

	protected void onPause() {
		_amanager.onPause(this);
		super.onPause();
	}

	protected void onDestroy() {
		_amanager.onDestroy(this);
		super.onDestroy();
	}


}
