package com.yonoo.myfaceon;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

//SplashActivity
public class SplashActivity extends Activity {

	//after 2000ms(2sec) finish
	private static final int LOADING_TIME = 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		initialize();
		//Show ProgressDialog
		ProgressDialog.show(SplashActivity.this, "", "프로필 생성중...");
	}

	private void initialize() {
		Handler handler = new Handler(){

			@Override
			public void handleMessage(Message msg) {
				finish();
			}
		};
		handler.sendEmptyMessageDelayed(0, LOADING_TIME);
	}
}
