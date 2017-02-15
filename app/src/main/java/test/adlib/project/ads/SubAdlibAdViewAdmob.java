/*
 * adlibr - Library for mobile AD mediation.
 * http://adlibr.com
 * Copyright (c) 2012-2013 Mocoplex, Inc.  All rights reserved.
 * Licensed under the BSD open source license.
 */


package test.adlib.project.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Gravity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.mocoplex.adlib.AdlibConfig;
import com.mocoplex.adlib.AdlibManagerCore;
import com.mocoplex.adlib.SubAdlibAdViewCore;

/*

 <meta-data android:name="com.google.android.gms.version"
	android:value="@integer/google_play_services_version"/>
 <activity android:name="com.google.android.gms.ads.AdActivity"
	android:configChanges="keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize"/>
*/

public class SubAdlibAdViewAdmob extends SubAdlibAdViewCore {
	
	protected AdView ad;
	protected boolean bGotAd = false;
	
	protected String admobID = "ca-app-pub-7301217422221072/4814079742";
	protected static String admobInterstitialID = "ca-app-pub-7301217422221072/3897469340";
    
    private AdRequest request = new AdRequest.Builder().build();
    
    public SubAdlibAdViewAdmob(Context context) {
		this(context,null);
	}
	
	public SubAdlibAdViewAdmob(Context context, AttributeSet attrs) {
		
		super(context, attrs);
		
		initAdmobView();
	}
	
	public void initAdmobView() {
		ad = new AdView(getContext());
		ad.setAdUnitId(admobID);
		ad.setAdSize(AdSize.SMART_BANNER);
		
		this.setGravity(Gravity.CENTER);
		
		ad.setAdListener( new AdListener() {

			@Override
			public void onAdFailedToLoad(int errorCode) {
				
				bGotAd = true;
				failed();
			}

			@Override
			public void onAdLoaded() {
				
				bGotAd = true;
				queryAd();
				gotAd();
				
				AdlibConfig.getInstance().bannerImp(SubAdlibAdViewAdmob.this);
			}
			
			@Override
			public void onAdOpened() {
			}
			
			@Override
			public void onAdLeftApplication() {
				AdlibConfig.getInstance().bannerClk(SubAdlibAdViewAdmob.this);
			}
		});
	}
	@Override
	public void query() {
		if(ad == null)
			initAdmobView();
		
        this.removeAllViews();
		this.addView(ad);
		
		ad.loadAd(request);
        
		Handler adHandler = new Handler();
		adHandler.postDelayed(new Runnable() {
            
			@Override
			public void run() {
				if(bGotAd){
					return;
				}else{
					failed();
					if(ad != null) {
                    	SubAdlibAdViewAdmob.this.removeView(ad);
                    	ad.destroy();
                    	ad = null;
                    }
                    bGotAd = false;
				}
			}
            
		}, 5000);
	}
	
	@Override
	public void onDestroy() {
		if(ad != null){
			this.removeView(ad);
			ad.destroy();
			ad = null;
		}
		
		super.onDestroy();
	}
	
	@Override
	public void clearAdView() {
		if(ad != null){
        	this.removeView(ad);
		}
		
        super.clearAdView();
	}
	
	@Override
	public void onResume() {
        super.onResume();
	}
	
	@Override
	public void onPause() {
        super.onPause();
	}
	
	public static void loadInterstitial(Context ctx, final Handler h, final String adlibKey) {
		// Create the interstitial
		final InterstitialAd interstitial = new InterstitialAd(ctx);
		interstitial.setAdUnitId(admobInterstitialID);

	    // Create ad request
	    AdRequest adRequest = new AdRequest.Builder().build();

	    // Begin loading your interstitial
	    interstitial.loadAd(adRequest);

	    // Set Ad Listener to use the callbacks below
	    interstitial.setAdListener(new AdListener() {
	    	
			@Override
			public void onAdClosed() {
				try{
					if(h != null){
		 				h.sendMessage(Message.obtain(h, AdlibManagerCore.INTERSTITIAL_CLOSED, "ADMOB"));
		 			}
				}catch(Exception e){
				}
			}

			@Override
			public void onAdFailedToLoad(int errorCode) {
				try{
					if(h != null){
		 				h.sendMessage(Message.obtain(h, AdlibManagerCore.DID_ERROR, "ADMOB"));
		 			}
				}catch(Exception e){
				}
			}

			@Override
			public void onAdLoaded() {
				try{
					if(interstitial.isLoaded()){
						if(h != null){
			 				h.sendMessage(Message.obtain(h, AdlibManagerCore.DID_SUCCEED, "ADMOB"));
			 			}
						
						AdlibConfig.getInstance().interstitialImp(adlibKey, "ADMOB");
						
						interstitial.show();
					}
				}catch(Exception e){
				}
			}
			
			@Override
			public void onAdOpened() {
			}
			
			@Override
			public void onAdLeftApplication() {
				try{
					AdlibConfig.getInstance().interstitialClk(adlibKey, "ADMOB");
				}catch(Exception e){
				}
			}
	    	
	    });
	}
}