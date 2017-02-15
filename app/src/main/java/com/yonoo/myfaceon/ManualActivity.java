package com.yonoo.myfaceon;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.mocoplex.adlib.AdlibActivity;
import com.mocoplex.adlib.AdlibManager;

public class ManualActivity extends AdlibActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//액티비티 생성
		setContentView(R.layout.manual);//
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
		// Xml 에 정의된 TextView 를 가지고 온다
		TextView tx = (TextView)findViewById(R.id.link);

		// 링크 걸기
		tx.setText( Html.fromHtml("<a href = \"https://www.facebook.com/myfaceonprofile\">MyFaceOn Facebook") );
		tx.setMovementMethod(LinkMovementMethod.getInstance());

		TextView txtemail = (TextView)findViewById(R.id.email);
		Linkify.addLinks(txtemail, Linkify.EMAIL_ADDRESSES);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}





}
