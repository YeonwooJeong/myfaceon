/*
package com.yonoo.myfaceon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import android.app.AlertDialog;
import android.app.ProgressDialog;
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



public class temporarily extends AdlibActivity implements OnClickListener{
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

	private static final int PICK_FROM_CAMERA = 0;
	private static final int PICK_FROM_ALBUM = 1;
	private static final int CROP_FROM_CAMERA = 2;
	LinearLayout bar,mother=null;
	FrameLayout container=null;
	Bitmap bm = null;

	// 	private ImageButton captureButton;
// 	private ImageButton mButton;
	String tag;

	Context m_context = this ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//액티비티 생성
		//createThreadAndDialog(); // 로딩메세지
		System.out.println("아웃풋 확인!!!");
		setContentView(R.layout.original);//result.xml출력

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
		String str_value34=it.getStringExtra("it_value34");

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

		ImageView position = (ImageView)findViewById(R.id.img_position);//포지션 이미지
		ImageView position2 = (ImageView)findViewById(R.id.img_position2);
		ImageView position3 = (ImageView)findViewById(R.id.img_position3);

		TextView txt_avg=(TextView)findViewById(R.id.avg);//평균 값
		TextView txt_avg2=(TextView)findViewById(R.id.avg2);
		TextView txt_avg3=(TextView)findViewById(R.id.avg3);

		TextView txt_hidden=(TextView)findViewById(R.id.edit_hidden);//히든스탯 메세지
		TextView txt_hidden1=(TextView)findViewById(R.id.edit_hidden1);
		TextView txt_hidden2=(TextView)findViewById(R.id.edit_hidden2);

//		TextView txt_position=(TextView)findViewById(R.id.position_msg);
//		TextView txt_position2=(TextView)findViewById(R.id.position_msg2);


		if(str_mode.equals("오리지날")){
			txt_hide.setVisibility(View.GONE);
			txt_hidden.setVisibility(View.GONE);
			txt_hidden1.setVisibility(View.GONE);
			txt_hidden2.setVisibility(View.GONE);

			if(str_position.equals("전체")){
//				params1.height = 1600;
//				System.out.println("1포지션"+allAvg().get(0));
//				System.out.println("1수치"+allAvg().get(1));
//				System.out.println("2포지션"+allAvg().get(2));
//				System.out.println("2수치"+allAvg().get(3));
//				System.out.println("3포지션"+allAvg().get(4));
//				System.out.println("3수치"+allAvg().get(5));
//				mother.setLayoutParams(params1);
//				container.setBackgroundResource(R.drawable.img4_1full);
				outputData(0);
				outputData(2);
				outputData(4);

			}else if(str_position.equals("ST")){
				BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.st);
				position.setImageDrawable(img_position);
				int avg = avg();
				TextView txt_value=(TextView)findViewById(R.id.avg);
				String s = Integer.toString(avg);
				txt_value.setTextColor(someColor8);
				txt_value.setText(s);

//				txt_position.setTextColor(someColor8);
//				txt_position.setText("ST");

			}else if(str_position.equals("CF")){
				txt_hide.setVisibility(View.GONE);
				BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.cf);
				position.setImageDrawable(img_position);
				int avg = avg();
				TextView txt_value=(TextView)findViewById(R.id.avg);
				String s = Integer.toString(avg);
				txt_value.setTextColor(someColor8);
				txt_value.setText(s);

//				txt_position.setTextColor(someColor8);
//				txt_position.setText("CF");
			}else if(str_position.equals("LW,RW")){
				txt_hide.setVisibility(View.GONE);
				BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.lw);
				position.setImageDrawable(img_position);
				int avg = avg();
				TextView txt_value=(TextView)findViewById(R.id.avg);
				String s = Integer.toString(avg);
				txt_value.setTextColor(someColor8);
				txt_value.setText(s);

//				txt_position.setTextColor(someColor8);
//				txt_position.setText("LW");
//
				BitmapDrawable img_position2 = (BitmapDrawable)getResources().getDrawable(R.drawable.rw);
				position2.setImageDrawable(img_position2);
				int avg1 = avg();
				TextView txt_value1=(TextView)findViewById(R.id.avg2);
				String s1 = Integer.toString(avg1);
				txt_value1.setTextColor(someColor8);
				txt_value1.setText(s1);
//
//				txt_position2.setTextColor(someColor8);
//				txt_position2.setText("RW");
			}else if(str_position.equals("CAM")){
				txt_hide.setVisibility(View.GONE);
				BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.cam);
				position.setImageDrawable(img_position);
				int avg = avg();
				TextView txt_value=(TextView)findViewById(R.id.avg);
				String s = Integer.toString(avg);
				txt_value.setTextColor(someColor8);
				txt_value.setText(s);
			}else if(str_position.equals("CM")){
				txt_hide.setVisibility(View.GONE);
				BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.cm);
				position.setImageDrawable(img_position);
				int avg = avg();
				TextView txt_value=(TextView)findViewById(R.id.avg);
				String s = Integer.toString(avg);
				txt_value.setTextColor(someColor8);
				txt_value.setText(s);
			}else if(str_position.equals("CDM")){
				txt_hide.setVisibility(View.GONE);
				BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.cdm);
				position.setImageDrawable(img_position);
				int avg = avg();
				TextView txt_value=(TextView)findViewById(R.id.avg);
				String s = Integer.toString(avg);
				txt_value.setTextColor(someColor8);
				txt_value.setText(s);
			}else if(str_position.equals("LM,RM")){
				txt_hide.setVisibility(View.GONE);
				BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.lm);
				position.setImageDrawable(img_position);
				int avg = avg();
				TextView txt_value=(TextView)findViewById(R.id.avg);
				String s = Integer.toString(avg);
				txt_value.setTextColor(someColor8);
				txt_value.setText(s);

				BitmapDrawable img_position2 = (BitmapDrawable)getResources().getDrawable(R.drawable.rm);
				position2.setImageDrawable(img_position2);
				int avg1 = avg();
				TextView txt_value1=(TextView)findViewById(R.id.avg2);
				String s1 = Integer.toString(avg1);
				txt_value1.setTextColor(someColor8);
				txt_value1.setText(s1);
			}else if(str_position.equals("CB")){
				txt_hide.setVisibility(View.GONE);
				BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.cb);
				position.setImageDrawable(img_position);
				int avg = avg();
				TextView txt_value=(TextView)findViewById(R.id.avg);
				String s = Integer.toString(avg);
				txt_value.setTextColor(someColor8);
				txt_value.setText(s);
			}else if(str_position.equals("LB,RB")){
				txt_hide.setVisibility(View.GONE);
				BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.lb);
				position.setImageDrawable(img_position);
				int avg = avg();
				TextView txt_value=(TextView)findViewById(R.id.avg);
				String s = Integer.toString(avg);
				txt_value.setTextColor(someColor8);
				txt_value.setText(s);

				BitmapDrawable img_position2 = (BitmapDrawable)getResources().getDrawable(R.drawable.rb);
				position2.setImageDrawable(img_position2);
				int avg1 = avg();
				TextView txt_value1=(TextView)findViewById(R.id.avg2);
				String s1 = Integer.toString(avg1);
				txt_value1.setTextColor(someColor8);
				txt_value1.setText(s1);
			}else if(str_position.equals("LWB,RWB")){
				txt_hide.setVisibility(View.GONE);
				BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.lwb);
				position.setImageDrawable(img_position);
				int avg = avg();
				TextView txt_value=(TextView)findViewById(R.id.avg);
				String s = Integer.toString(avg);
				txt_value.setTextColor(someColor8);
				txt_value.setText(s);

				BitmapDrawable img_position2 = (BitmapDrawable)getResources().getDrawable(R.drawable.rwb);
				position2.setImageDrawable(img_position2);
				int avg1 = avg();
				TextView txt_value1=(TextView)findViewById(R.id.avg2);
				String s1 = Integer.toString(avg1);
				txt_value1.setTextColor(someColor8);
				txt_value1.setText(s1);
			}else if(str_position.equals("SW")){
				txt_hide.setVisibility(View.GONE);
				BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.sw);
				position.setImageDrawable(img_position);
				int avg = avg();
				TextView txt_value=(TextView)findViewById(R.id.avg);
				String s = Integer.toString(avg);
				txt_value.setTextColor(someColor8);
				txt_value.setText(s);
			}else if(str_position.equals("GK")){
				txt_hide.setVisibility(View.GONE);
				BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.gk);
				position.setImageDrawable(img_position);
				int avg = avg();
				TextView txt_value=(TextView)findViewById(R.id.avg);
				String s = Integer.toString(avg);
				txt_value.setTextColor(someColor8);
				txt_value.setText(s);
			}
		}else if(str_mode.equals("커스텀")){
			txt_hide.setVisibility(View.VISIBLE);
			txt_hidden.setVisibility(View.VISIBLE);
			txt_hidden1.setVisibility(View.VISIBLE);
			txt_hidden2.setVisibility(View.VISIBLE);
			position.setVisibility(View.GONE);
			position2.setVisibility(View.GONE);
			position3.setVisibility(View.GONE);
			txt_avg.setVisibility(View.GONE);
			txt_avg2.setVisibility(View.GONE);
			txt_avg3.setVisibility(View.GONE);


		}




		String str_name=it.getStringExtra("it_name");
		TextView txt_name=(TextView)findViewById(R.id.edit_name);
		txt_name.setTextColor(someColor4);
		txt_name.setText(str_name);

//		국기삽입
		String str_national=it.getStringExtra("it_national");
		TextView txt_national=(TextView)findViewById(R.id.edit_national);
		txt_national.setTextColor(someColor4);
		txt_national.setText(str_national);
		ImageView country = (ImageView)findViewById(R.id.country_img); //국기이미지
		country.setImageDrawable(FaceonComp.getCountryBitmapDrawble(this, str_national));
//		if(str_national.equals("대한민국")){
//			BitmapDrawable img_country = (BitmapDrawable)getResources().getDrawable(R.drawable.korea);
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
				BitmapDrawable img = (BitmapDrawable)getResources().getDrawable(R.drawable.rightfoot);
				foot.setImageDrawable(img);
				TextView txt_foot_right=(TextView)findViewById(R.id.edit_foot_right);
				txt_foot_right.setTextColor(someColor4);
				txt_foot_right.setText(str_foot_right);
				TextView txt_foot_left=(TextView)findViewById(R.id.edit_foot_left);
				txt_foot_left.setTextColor(someColor4);
				txt_foot_left.setText(str_foot_left);

			}else if(temp_right < temp_left){
				foot = (ImageView)findViewById(R.id.foot);
				BitmapDrawable img = (BitmapDrawable)getResources().getDrawable(R.drawable.leftfoot);
				foot.setImageDrawable(img);
				TextView txt_foot_right=(TextView)findViewById(R.id.edit_foot_right);
				txt_foot_right.setTextColor(someColor4);
				txt_foot_right.setText(str_foot_right);
				TextView txt_foot_left=(TextView)findViewById(R.id.edit_foot_left);
				txt_foot_left.setTextColor(someColor4);
				txt_foot_left.setText(str_foot_left);

			}else if(temp_right == temp_left){
				foot = (ImageView)findViewById(R.id.foot);
				BitmapDrawable img = (BitmapDrawable)getResources().getDrawable(R.drawable.twofoot);
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

		String str_hidden1=it.getStringExtra("it_hidden1");
		//txt_hidden1.setTextColor(someColor4);
		txt_hidden1.setText(str_hidden1);

		String str_hidden2=it.getStringExtra("it_hidden2");
		//txt_hidden2.setTextColor(someColor4);
		txt_hidden2.setText(str_hidden2);

		*/
/*별 이미지셋*//*

		String str_star_msg=it.getStringExtra("it_star_msg");
		TextView txt_star=(TextView)findViewById(R.id.edit_star);
		txt_star.setTextColor(someColor4);
		txt_star.setText(str_star_msg);

		String str_star= it.getStringExtra("it_star");
		ImageView star = (ImageView)findViewById(R.id.star);
		star.setImageDrawable(FaceonComp.getStarBitmapDrawble(this, str_star));

		*/
/*별 이미지셋*//*


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

		String str_ability34 = it.getStringExtra("it_ability34");
		TextView txt_ability34 = (TextView) findViewById(R.id.edit_ability34);
		txt_ability34.setTextColor(someColor4);
		txt_ability34.setText(str_ability34);
		if (str_value34 == null || str_value34.length() == 0) {
			TextView txt_value34 = (TextView) findViewById(R.id.edit_value34);
			txt_value34.setText(str_value34);
		} else {

			// 색깔별값범위
			TextView txt_value34 = (TextView) findViewById(R.id.edit_value34);//
			color(txt_value34, str_value34);
		}

	}
	private ProgressDialog loagindDialog; // 로딩화면
	void createThreadAndDialog() {

	        */
/* ProgressDialog *//*

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
	};
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
		startActivityForResult(intent, PICK_FROM_CAMERA);

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
				intent.setDataAndType(mImageCaptureUri, "image*/
/*");

				intent.putExtra("outputX", 120);
				intent.putExtra("outputY", 130);
				intent.putExtra("aspectX", 1);
				intent.putExtra("aspectY", 1);
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

				fos = new FileOutputStream(fileRoute+"/FaceOn/"+str_mode+"-"+str_season+"-"+str_name+".jpeg");
				Log.d("[screenshot]", " : " + container.getDrawingCache());
				captureView.compress(Bitmap.CompressFormat.JPEG, 100, fos);

				Log.d("[screenshot]", "미디어스캐닝시작");
				sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://"
						+ Environment.getExternalStorageDirectory()+"/FaceOn/"+str_mode+"-"+str_season+"-"+str_name+".jpeg")));

				Log.d("[screenshot]", "미디어스캐닝시작");
				Toast.makeText(getApplicationContext(), "/sdcard/FaceOn으로 저장되었습니다.", Toast.LENGTH_LONG).show();
			}catch (FileNotFoundException e) {

				e.printStackTrace();
				Toast.makeText(getApplicationContext(), "저장실패.폴더생성에 실패했거나 USB연결로 인해 sdcard가 사용 중일수 있습니다.", Toast.LENGTH_LONG).show();

			}
			captureView.recycle();
			captureView = null;


		}
		else if(v.getId() == R.id.button_share){

			Intent it=getIntent();
			String str_name=it.getStringExtra("it_name");
			String str_season= it.getStringExtra("it_season");
			String str_mode = it.getStringExtra("it_mode");
			File fileRoute = null;
			fileRoute = Environment.getExternalStorageDirectory();


			File files = new File(fileRoute,"/FaceOn/"+str_mode+"-"+str_season+"-"+str_name+".jpeg");

			if(files.exists()==true)  //파일유무확인
			{
				Intent intentSend  = new Intent(Intent.ACTION_SEND);
				intentSend.setType("image*/
/*");
				intentSend.putExtra(Intent.EXTRA_STREAM, Uri.parse(fileRoute+"/FaceOn/"+str_mode+"-"+str_season+"-"+str_name+".jpeg"));
				startActivity(Intent.createChooser(intentSend, "공유"));
			}else{
				Toast.makeText(getApplicationContext(), "저장을 먼저 해주세요", Toast.LENGTH_LONG).show();
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

			new AlertDialog.Builder(this)
					.setTitle("업로드할 이미지 선택")
					.setPositiveButton("사진촬영", cameraListener)
					.setNeutralButton("앨범선택", albumListener)
					.setNegativeButton("취소", cancelListener)
					.show();

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

	public void outputData(int index){
		ImageView position = (ImageView)findViewById(R.id.img_position);//포지션 이미지
		ImageView position2 = (ImageView)findViewById(R.id.img_position2);
		ImageView position3 = (ImageView)findViewById(R.id.img_position3);
		if(allAvg().get(index).equals("ST")){
//			System.out.println("1포지션"+allAvg().get(0));
//			System.out.println("1수치"+allAvg().get(1));
//			System.out.println("2포지션"+allAvg().get(2));
//			System.out.println("2수치"+allAvg().get(3));
//			System.out.println("3포지션"+allAvg().get(4));
//			System.out.println("3수치"+allAvg().get(5));
			BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.st);
			setting(index);
			if(index == 0){
				position.setImageDrawable(img_position);
			}else if(index == 2){
				position2.setImageDrawable(img_position);
			}else if(index == 4){
				position3.setImageDrawable(img_position);
			}
		}else if(allAvg().get(index).equals("CF")){
			BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.cf);
			setting(index);
			if(index == 0){
				position.setImageDrawable(img_position);
			}else if(index == 2){
				position2.setImageDrawable(img_position);
			}else if(index == 4){
				position3.setImageDrawable(img_position);
			}
		}else if(allAvg().get(index).equals("LW")){
			BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.lw);
			setting(index);
			if(index == 0){
				position.setImageDrawable(img_position);
			}else if(index == 2){
				position2.setImageDrawable(img_position);
			}else if(index == 4){
				position3.setImageDrawable(img_position);
			}

		}else if(allAvg().get(index).equals("RW")){
			BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.rw);
			setting(index);
			if(index == 0){
				position.setImageDrawable(img_position);
			}else if(index == 2){
				position2.setImageDrawable(img_position);
			}else if(index == 4){
				position3.setImageDrawable(img_position);
			}

		}else if(allAvg().get(index).equals("CAM")){
			BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.cam);
			setting(index);
			if(index == 0){
				position.setImageDrawable(img_position);
			}else if(index == 2){
				position2.setImageDrawable(img_position);
			}else if(index == 4){
				position3.setImageDrawable(img_position);
			}
		}else if(allAvg().get(index).equals("CM")){
			BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.cm);
			setting(index);
			if(index == 0){
				position.setImageDrawable(img_position);
			}else if(index == 2){
				position2.setImageDrawable(img_position);
			}else if(index == 4){
				position3.setImageDrawable(img_position);
			}

		}else if(allAvg().get(index).equals("CDM")){
			BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.cdm);
			setting(index);
			if(index == 0){
				position.setImageDrawable(img_position);
			}else if(index == 2){
				position2.setImageDrawable(img_position);
			}else if(index == 4){
				position3.setImageDrawable(img_position);
			}

		}else if(allAvg().get(index).equals("LM")){
			BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.lm);
			setting(index);
			if(index == 0){
				position.setImageDrawable(img_position);
			}else if(index == 2){
				position2.setImageDrawable(img_position);
			}else if(index == 4){
				position3.setImageDrawable(img_position);
			}

		}else if(allAvg().get(index).equals("RM")){
			BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.rm);
			setting(index);
			if(index == 0){
				position.setImageDrawable(img_position);
			}else if(index == 2){
				position2.setImageDrawable(img_position);
			}else if(index == 4){
				position3.setImageDrawable(img_position);
			}

		}else if(allAvg().get(index).equals("CB")){
			BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.cb);
			setting(index);
			if(index == 0){
				position.setImageDrawable(img_position);
			}else if(index == 2){
				position2.setImageDrawable(img_position);
			}else if(index == 4){
				position3.setImageDrawable(img_position);
			}
		}else if(allAvg().get(index).equals("LB")){
			BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.lb);
			setting(index);
			if(index == 0){
				position.setImageDrawable(img_position);
			}else if(index == 2){
				position2.setImageDrawable(img_position);
			}else if(index == 4){
				position3.setImageDrawable(img_position);
			}

		}else if(allAvg().get(index).equals("RB")){
			BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.rb);
			setting(index);
			if(index == 0){
				position.setImageDrawable(img_position);
			}else if(index == 2){
				position2.setImageDrawable(img_position);
			}else if(index == 4){
				position3.setImageDrawable(img_position);
			}

		}else if(allAvg().get(index).equals("LWB")){
			BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.lwb);
			setting(index);
			if(index == 0){
				position.setImageDrawable(img_position);
			}else if(index == 2){
				position2.setImageDrawable(img_position);
			}else if(index == 4){
				position3.setImageDrawable(img_position);
			}
		}else if(allAvg().get(index).equals("RWB")){
			BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.rwb);
			setting(index);
			if(index == 0){
				position.setImageDrawable(img_position);
			}else if(index == 2){
				position2.setImageDrawable(img_position);
			}else if(index == 4){
				position3.setImageDrawable(img_position);
			}

		}else if(allAvg().get(index).equals("SW")){
			BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.sw);
			setting(index);
			if(index == 0){
				position.setImageDrawable(img_position);
			}else if(index == 2){
				position2.setImageDrawable(img_position);
			}else if(index == 4){
				position3.setImageDrawable(img_position);
			}
		}else if(allAvg().get(index).equals("GK")){
			BitmapDrawable img_position = (BitmapDrawable)getResources().getDrawable(R.drawable.gk);
			setting(index);
			if(index == 0){
				position.setImageDrawable(img_position);
			}else if(index == 2){
				position2.setImageDrawable(img_position);
			}else if(index == 4){
				position3.setImageDrawable(img_position);
			}
		}
	}

	public void setting(int index){

		if(index == 0){
			String avg = allAvg().get(index+1);
			TextView txt_value=(TextView)findViewById(R.id.avg);
			txt_value.setTextColor(someColor8);
			txt_value.setText(avg);
		}else if(index == 2){
			String avg = allAvg().get(index+1);
			TextView txt_value1=(TextView)findViewById(R.id.avg2);
			txt_value1.setTextColor(someColor8);
			txt_value1.setText(avg);
		}else if(index == 4){
			String avg = allAvg().get(index+1);
			TextView txt_value2=(TextView)findViewById(R.id.avg3);
			txt_value2.setTextColor(someColor8);
			txt_value2.setText(avg);
		}
	}


	public List<String> allAvg() {
		int temp = 0;
		Map<String, Double> map = new HashMap<String, Double>();
		ArrayList<Integer> list = new ArrayList<Integer>();// 총 합
		ValueComparator1 bvc = new ValueComparator1(map);
		TreeMap<String, Double> tm = new TreeMap<String, Double>(bvc);
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
		double st_temp = list.get(0) + list.get(1) + list.get(3) + list.get(4)
				+ list.get(7) + list.get(9) + list.get(10) + list.get(12)
				+ list.get(15) + list.get(17) + list.get(20) + list.get(21);
		double st_sum = st_temp;
		double st_avg = st_sum / 12;
		map.put("ST", st_avg);

		double cf_sum = list.get(0) + list.get(1) + list.get(3) + list.get(4)
				+ list.get(7) + list.get(9) + list.get(10) + list.get(12)
				+ list.get(15) + list.get(17) + list.get(19) + list.get(20)
				+ list.get(21);
		double cf_avg = cf_sum / 13;
		map.put("CF", cf_avg);

		double lw_sum = list.get(0) + list.get(1) + list.get(3) + list.get(9)
				+ list.get(10) + list.get(11) + list.get(12) + list.get(14)
				+ list.get(17) + list.get(18) + list.get(19) + list.get(20)
				+ list.get(21) + list.get(24);
		double lw_avg = lw_sum / 14;
		map.put("LW", lw_avg);

		double rw_sum = list.get(0) + list.get(1) + list.get(3) + list.get(9)
				+ list.get(10) + list.get(11) + list.get(12) + list.get(14)
				+ list.get(17) + list.get(18) + list.get(19) + list.get(20)
				+ list.get(21) + list.get(24);
		double rw_avg = rw_sum / 14;
		map.put("RW", rw_avg);

		double cam_sum = list.get(0) + list.get(1) + list.get(3) + list.get(7)
				+ list.get(8) + list.get(9) + list.get(12) + list.get(17)
				+ list.get(18) + list.get(20) + list.get(21) + list.get(24);
		double cam_avg = cam_sum / 12;
		map.put("CAM", cam_avg);

		double cm_sum = list.get(3) + list.get(7) + list.get(8) + list.get(9)
				+ list.get(12) + list.get(14) + list.get(15) + list.get(17)
				+ list.get(18) + list.get(20) + list.get(21) + list.get(24)
				+ list.get(25);
		double cm_avg = cm_sum / 13;
		map.put("CM", cm_avg);

		double cdm_sum = list.get(7) + list.get(8) + list.get(9) + list.get(12)
				+ list.get(14) + list.get(15) + list.get(17) + list.get(18)
				+ list.get(20) + list.get(24) + list.get(25) + list.get(26)
				+ list.get(27) + list.get(28);
		double cdm_avg = cdm_sum / 14;
		map.put("CDM", cdm_avg);

		double lm_sum = list.get(3) + list.get(8) + list.get(9) + list.get(10)
				+ list.get(11) + list.get(12) + list.get(14) + list.get(17)
				+ list.get(18) + list.get(19) + list.get(20) + list.get(24);
		double lm_avg = lm_sum / 12;
		map.put("LM", lm_avg);

		double rm_sum = list.get(3) + list.get(8) + list.get(9) + list.get(10)
				+ list.get(11) + list.get(12) + list.get(14) + list.get(17)
				+ list.get(18) + list.get(19) + list.get(20) + list.get(24);
		double rm_avg = rm_sum / 12;
		map.put("RM", rm_avg);

		double cb_sum = list.get(7) + list.get(8) + list.get(9) + list.get(12)
				+ list.get(13) + list.get(15) + list.get(17) + list.get(20)
				+ list.get(25) + list.get(26) + list.get(27) + list.get(28);
		double cb_avg = cb_sum / 12;
		map.put("CB", cb_avg);

		double lb_sum = list.get(7) + list.get(8) + list.get(9) + list.get(12)
				+ list.get(14) + list.get(15) + list.get(18) + list.get(19)
				+ list.get(20) + list.get(25) + list.get(26) + list.get(27)
				+ list.get(28);
		double lb_avg = lb_sum / 13;
		map.put("LB", lb_avg);

		double rb_sum = list.get(7) + list.get(8) + list.get(9) + list.get(12)
				+ list.get(14) + list.get(15) + list.get(18) + list.get(19)
				+ list.get(20) + list.get(25) + list.get(26) + list.get(27)
				+ list.get(28);
		double rb_avg = rb_sum / 13;
		map.put("RB", rb_avg);

		double rwb_sum = list.get(7) + list.get(8) + list.get(9) + list.get(10)
				+ list.get(12) + list.get(14) + list.get(17) + list.get(19)
				+ list.get(20) + list.get(21) + list.get(25) + list.get(26)
				+ list.get(27);
		double rwb_avg = rwb_sum / 13;
		map.put("RWB", rwb_avg);

		double lwb_sum = list.get(7) + list.get(8) + list.get(9) + list.get(10)
				+ list.get(12) + list.get(14) + list.get(17) + list.get(19)
				+ list.get(20) + list.get(21) + list.get(25) + list.get(26)
				+ list.get(27);
		double lwb_avg = lwb_sum / 13;
		map.put("LWB", lwb_avg);

		double sw_sum = list.get(7) + list.get(8) + list.get(10) + list.get(12)
				+ list.get(13) + list.get(15) + list.get(17) + list.get(20)
				+ list.get(23) + list.get(25) + list.get(26) + list.get(27);
		double sw_avg = sw_sum / 12;
		map.put("SW", sw_avg);

		double gk_sum = list.get(12) + list.get(13) + list.get(29)
				+ list.get(30) + list.get(31) + list.get(32) + list.get(33);
		double gk_avg = gk_sum / 7;
		map.put("GK", gk_avg);

		// 테스트
//		System.out.println("unsorted map");
//		for (String key : map.keySet()) {
//			int value = Integer
//					.parseInt(String.valueOf(Math.round(map.get(key))));
//			System.out
//					.println("key/value: " + key + "/" + value*/
/* map.get(key) *//*
);
//		}

		tm.putAll(map);
//		System.out.println("results");// 테스트
		ArrayList<String> resultList = new ArrayList<String>();
		ArrayList<Double> dou_list = new ArrayList<Double>();
		ArrayList<String> str_list = new ArrayList<String>();
		for (String key : tm.keySet()) {
//			System.out.println("key/value: " + key + "/" + tm.get(key)); // 테스트
			dou_list.add(tm.get(key));
			str_list.add(key);
		}
		for (int i = 0; i < 5; i++) {
			double dou = 0;
			resultList.add(str_list.get(i));
			if (dou_list.get(i) == null) {
				dou = dou_list.get(i - 1) - 0.0001;
				int value = (int) dou;
				String str = Integer.toString(value);
				resultList.add(str);
			} else {
				dou = dou_list.get(i);
				int value = (int) dou;
				String str = Integer.toString(value);
				resultList.add(str);
			}

		}
		// 테스트
//		for (int i = 0; i < resultList.size(); i++) {
//			System.out.println(i + "번째" + resultList.get(i));
//		}// 테스트
		return resultList;
	}

}



*/
