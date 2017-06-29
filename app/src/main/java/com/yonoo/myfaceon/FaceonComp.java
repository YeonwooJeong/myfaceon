package com.yonoo.myfaceon;

import java.util.ArrayList;
import java.util.HashMap;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;

public class FaceonComp {

	public static String forward_rate,defence_rate;
	private ArrayList<String> list;


//	Context context;
//
//	public FaceonComp(Context context) {
//	    this.context = context;
//	}

	private static HashMap<String, Integer> map ;

	public static HashMap<String, Integer> getMap() {
		if (map == null) {
			map = new HashMap<String, Integer>();

			map.put("유럽 리그 전설", R.drawable.legend);
			map.put("2002 전설", R.drawable.year02);
			map.put("한국 전설", R.drawable.korean_legend);
			map.put("16시즌 한국 레전드", R.drawable.korea16);
			map.put("16 Korea Legend", R.drawable.korea16);
			map.put("EU Legend", R.drawable.legend);
			map.put("2002 Legend", R.drawable.year02);
			map.put("Korean Legend", R.drawable.korean_legend);
			map.put("Special", R.drawable.special);
			map.put("WORLD BEST", R.drawable.world);
			map.put("World Legend", R.drawable.worldlegend);
			map.put("U-23", R.drawable.u23);
			map.put("U-20", R.drawable.u20);
			map.put("K League Legend", R.drawable.kl);
			map.put("Ultimate Tiger", R.drawable.ut);
			map.put("얼티밋 타이거", R.drawable.ut);
			map.put("얼티밋 레전드", R.drawable.ul);
			map.put("Ultimate Legend", R.drawable.ul);


			map.put("08 E", R.drawable.e08);
			map.put("12 E", R.drawable.e12);
			map.put("07 U", R.drawable.eu07);
			map.put("09 U", R.drawable.eu09);
			map.put("10 U", R.drawable.eu10);
			map.put("11 U", R.drawable.eu11);
			map.put("12 U", R.drawable.eu12);
			map.put("13 U", R.drawable.eu13);
			map.put("14 U", R.drawable.eu14);
			map.put("15 U", R.drawable.eu15);
			map.put("06 U", R.drawable.eu06);
			map.put("ManU E", R.drawable.manu);
			map.put("15 중국리그", R.drawable.china15);
			map.put("15 china", R.drawable.china15);

			map.put("02 World Cup", R.drawable.wc02);
			map.put("06 World Cup", R.drawable.wc06);
			map.put("10 World Cup", R.drawable.wc10);
			map.put("14 World Cup", R.drawable.wc14);
			map.put("18 World Cup", R.drawable.wc18);
			map.put("22 World Cup", R.drawable.wc22);

			map.put("14 TOTS", R.drawable.tots14);
			map.put("15 TOTS", R.drawable.tots15);
			map.put("16 TOTS", R.drawable.tots16);

			map.put("16 유럽 아메리카", R.drawable.ec16);
			map.put("16 EC", R.drawable.ec16);

			map.put("LP", R.drawable.lp);
			map.put("CP", R.drawable.cp);

			map.put("98", R.drawable.year98);
			map.put("99", R.drawable.year99);
			map.put("00", R.drawable.year00);
			map.put("01", R.drawable.year01);
			map.put("02", R.drawable.season02);
			map.put("03", R.drawable.year03);
			map.put("04", R.drawable.year04);
			map.put("05", R.drawable.year05);
			map.put("06", R.drawable.year06);
			map.put("07", R.drawable.year07);
			map.put("08", R.drawable.year08);
			map.put("09", R.drawable.year09);
			map.put("10", R.drawable.year10);
			map.put("11", R.drawable.year11);
			map.put("12", R.drawable.year);
			map.put("13", R.drawable.year13);
			map.put("14", R.drawable.year14);
			map.put("15", R.drawable.year15);
			map.put("16", R.drawable.year16);
			map.put("17", R.drawable.year17);
			map.put("22", R.drawable.year22);



			map.put("+1", R.drawable.force1);
			map.put("+2", R.drawable.force2);
			map.put("+3", R.drawable.force3);
			map.put("+4", R.drawable.force4);
			map.put("+5", R.drawable.force5);
			map.put("+6", R.drawable.force6);
			map.put("+7", R.drawable.force7);
			map.put("+8", R.drawable.force8);
			map.put("+9", R.drawable.force9);
			map.put("+10", R.drawable.force10);


			map.put("0.5", R.drawable.star_one_half);
			map.put("1", R.drawable.star_one);
			map.put("1.5", R.drawable.star_two_half);
			map.put("2", R.drawable.star_two);
			map.put("2.5", R.drawable.star_three_half);
			map.put("3", R.drawable.star_three);
			map.put("3.5", R.drawable.star_four_half);
			map.put("4", R.drawable.star_four);
			map.put("4.5", R.drawable.star_five_half);
			map.put("5", R.drawable.star_five);

			map.put("COMPLETE FORWARD", R.drawable.complete_forward);
			map.put("완벽한 공격수", R.drawable.complete_forward);
			map.put("COMPLETE MIDFIELDER", R.drawable.complete_midfielder);
			map.put("완벽한 미드필더", R.drawable.complete_midfielder);
			map.put("COMPLETE DEFENDER", R.drawable.complete_defender);
			map.put("완벽한 수비수", R.drawable.complete_defender);
			map.put("POACHER", R.drawable.poacher);
			map.put("골게터", R.drawable.poacher);
			map.put("AERIAL THREAT", R.drawable.aerial_threat);
			map.put("공중의 지배자", R.drawable.aerial_threat);
			map.put("SPEEDSTER", R.drawable.speedster);
			map.put("날쌘돌이", R.drawable.speedster);
			map.put("두 개의 심장", R.drawable.engine);
			map.put("ENGINE", R.drawable.engine);
			map.put("마에스트로", R.drawable.playmaker);
			map.put("PLAYMAKER", R.drawable.playmaker);
			map.put("아크로바틱", R.drawable.acrobat);
			map.put("ACROBAT", R.drawable.acrobat);
			map.put("통곡의 벽", R.drawable.tackling);
			map.put("TACKLING", R.drawable.tackling);
			map.put("진공 청소기", R.drawable.tactician);
			map.put("TACTICIAN", R.drawable.tactician);
			map.put("캐논 슈터", R.drawable.longshottaker);
			map.put("LONG SHOT TAKER", R.drawable.longshottaker);
			map.put("택배 크로스", R.drawable.crosser);
			map.put("CROSSER", R.drawable.crosser);
			map.put("탱커", R.drawable.strength);
			map.put("STRENGTH", R.drawable.strength);
			map.put("테크니션", R.drawable.dribbler);
			map.put("DRIBBLER", R.drawable.dribbler);
			map.put("프리킥 스페셜리스트", R.drawable.fk_specialist);
			map.put("FK SPECIALIST", R.drawable.fk_specialist);
			map.put("해결사", R.drawable.clinical_finisher);
			map.put("CLINICAL FINISHER", R.drawable.clinical_finisher);


			map.put("공격 높음", R.drawable.attackhigh);
			map.put("F High", R.drawable.attackhigh);
			map.put("공격 보통", R.drawable.attackmiddle);
			map.put("F Medium", R.drawable.attackmiddle);
			map.put("공격 낮음", R.drawable.attacklow);
			map.put("F Low", R.drawable.attacklow);

			map.put("수비 높음", R.drawable.defhigh);
			map.put("D High", R.drawable.defhigh);
			map.put("D Medium", R.drawable.defmiddle);
			map.put("수비 보통", R.drawable.defmiddle);
			map.put("D Low", R.drawable.deflow);
			map.put("수비 낮음", R.drawable.deflow);
		}
		return map;
	}
	//개인기
	public static BitmapDrawable getStarBitmapDrawble(Context context, String str_star){


		BitmapDrawable img_star = null;
		img_star = (BitmapDrawable)ContextCompat.getDrawable(context,getMap().get(str_star));

		return img_star;
	}

	//호즐메
	public static BitmapDrawable getHozlmeBitmapDrawble(Context context, String str_name){

		BitmapDrawable img_face = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.hozlme);

		return img_face;
	}
	//시즌
	public static BitmapDrawable getSeasonBitmapDrawble(Context context, String str_season){

		BitmapDrawable img_season = null;
		img_season = (BitmapDrawable) ContextCompat.getDrawable(context, getMap().get(str_season));

		return img_season;
	}

	public static BitmapDrawable getBackGroundBitmapDrawble(Context context, String str_season){

		BitmapDrawable img_season = null;
		BitmapDrawable img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.bg1);
		if(str_season.equals("09 U")|| str_season.equals("10 U")|| str_season.equals("06 U")|| str_season.equals("07 U")|| str_season.equals("11 U") || str_season.equals("12 U") || str_season.equals("13 U")
				|| str_season.equals("14 U")|| str_season.equals("15 U")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.back10u);
		}else if(str_season.equals("08 E") || str_season.equals("12 E")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.back08e);
		}else if(str_season.equals("WORLD BEST")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.bg);
		}else if(str_season.equals("06 World Cup") || str_season.equals("14 World Cup") || str_season.equals("02 World Cup") || str_season.equals("10 World Cup") || str_season.equals("18 World Cup") || str_season.equals("22 World Cup")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.worldimg);
		}else if(str_season.equals("World Legend")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.worldlegendimg);
		}else if(str_season.equals("14 TOTS") || str_season.equals("15 TOTS") || str_season.equals("16 TOTS")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.tots);
		}else if(str_season.equals("ManU E")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.backmanu);
		}else if(str_season.equals("2002 전설") || str_season.equals("2002 Legend") || str_season.equals("16 Korea Legend") || str_season.equals("16시즌 한국 레전드")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.background02);
		}else if(str_season.equals("한국 전설") || str_season.equals("Korean Legend")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.bgkorealegend);
		}else if(str_season.equals("16 유럽 아메리카") || str_season.equals("16 EC")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.ec);
		}else if(str_season.equals("U-23")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.backu23);
		}else if(str_season.equals("유럽 리그 전설") || str_season.equals("EU Legend")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.eu_legend);
		}else if(str_season.equals("LP")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.backlp);
		}else if(str_season.equals("K League Legend")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.backkl);
		}else if(str_season.equals("Ultimate Tiger") || str_season.equals("얼티밋 타이거")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.backut);
		}else if(str_season.equals("CP")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.backcp);
		}else if(str_season.equals("Ultimate Legend") || str_season.equals("얼티밋 레전드")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.backul);
		}else if(str_season.equals("U-20")){
			img_bg = (BitmapDrawable)ContextCompat.getDrawable(context,R.drawable.backu20);
		}

		return img_bg;
	}

	//강화
	public static BitmapDrawable getForceBitmapDrawble(Context context, String str_force){

		BitmapDrawable img_force = null;
		img_force = (BitmapDrawable)ContextCompat.getDrawable(context,getMap().get(str_force));

		return img_force;
	}


	//공격 참여도
	public static BitmapDrawable getForwardParticipationBitmapDrawble(Context context, String str_forward_participation){

		BitmapDrawable img_forward_participation = null;
		img_forward_participation = (BitmapDrawable)ContextCompat.getDrawable(context,getMap().get(str_forward_participation));
		System.out.println("str_forward_participation"+str_forward_participation);
		if(str_forward_participation.equals("공격 높음")){
			forward_rate = "높음";
		}else if(str_forward_participation.equals("F High")){
			forward_rate = "High";
		}else if(str_forward_participation.equals("공격 보통")){
			forward_rate = "보통";
		}else if(str_forward_participation.equals("F Medium")){
			forward_rate = "Medium";
		}else if(str_forward_participation.equals("공격 낮음")){
			forward_rate = "낮음";
		}else if(str_forward_participation.equals("F Low")){
			forward_rate = "Low";
		}
		System.out.println("forward_rate"+forward_rate);
		return img_forward_participation;
	}

	//수비 참여도
	public static BitmapDrawable getDefenceParticipationBitmapDrawble(Context context, String str_defence_participation){

		BitmapDrawable img_defence_participation = null;
		img_defence_participation = (BitmapDrawable)ContextCompat.getDrawable(context,getMap().get(str_defence_participation));
		System.out.println("str_defence_participation"+str_defence_participation);
		System.out.println("dddd"+(str_defence_participation == "D High"));
		if(str_defence_participation.equals("수비 높음")){
			defence_rate = "높음";
		}else if(str_defence_participation.equals("D High")){
			defence_rate = "High";
		}else if(str_defence_participation.equals("수비 보통")){
			defence_rate = "보통";
		}else if(str_defence_participation.equals("D Medium")){
			defence_rate = "Medium";
		}else if(str_defence_participation.equals("수비 낮음")){
			defence_rate = "낮음";
		}else if(str_defence_participation.equals("D Low")){
			defence_rate = "Low";
		}
		System.out.println("defence_rate"+defence_rate);
		return img_defence_participation;
	}

	//칭호 참여도
	public static BitmapDrawable getStyleBitmapDrawble(Context context, String str_style){
		BitmapDrawable img_style = null;
		if(str_style.equals("없음")|| str_style.equals("None")){

		}else
			img_style = (BitmapDrawable)ContextCompat.getDrawable(context,getMap().get(str_style));

		return img_style;
	}



	public static BitmapDrawable getCountryBitmapDrawble(Context context, String str_national){

		BitmapDrawable img_country = null;
		if (str_national.equals("가나")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.ghana);
		} else if (str_national.equals("가봉")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.gabon);
		} else if (str_national.equals("가이아나")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.guyana);
		} else if (str_national.equals("감비아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.gambia);
		} else if (str_national.equals("과테말라")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.guatemala);
		} else if (str_national.equals("괌")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.guam);
		} else if (str_national.equals("그레나다")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.grenada);
		} else if (str_national.equals("그리스")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.greece);
		} else if (str_national.equals("기니")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.guinea);
		} else if (str_national.equals("기니 비사우")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.guinebissau);
		} else if (str_national.equals("나미비아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.namibia);
		} else if (str_national.equals("나이지리아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.nigeria);
		} else if (str_national.equals("남아프리카공화국")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.southafrica);
		} else if (str_national.equals("네덜란드")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.netherlands);
		} else if (str_national.equals("네팔")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.nepal);
		}else if (str_national.equals("노르웨이")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.norway);
		} else if (str_national.equals("뉴질랜드")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.newzealand);
		} else if (str_national.equals("대한민국")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.korea);
		} else if (str_national.equals("대만")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.taiwan);
		} else if (str_national.equals("덴마크")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.denmark);
		} else if (str_national.equals("독일")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.germany);
		} else if (str_national.equals("라이베리아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.liberia);
		} else if (str_national.equals("러시아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.russia);
		} else if (str_national.equals("레바논")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.lebanon);
		} else if (str_national.equals("루마니아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.rumania);
		} else if (str_national.equals("룩셈부르크")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.luxemburg);
		} else if (str_national.equals("리비아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.libya);
		}else if (str_national.equals("리투아니아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.lithuania);
		} else if (str_national.equals("마다가스카르")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.madagascar);
		} else if (str_national.equals("마케도니아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.macedonia);
		} else if (str_national.equals("마카오")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.macau);
		} else if (str_national.equals("말레이시아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.malaysia);
		} else if (str_national.equals("말리")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.mali);
		} else if (str_national.equals("멕시코")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.mexico);
		} else if (str_national.equals("모로코")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.morocco);
		} else if (str_national.equals("몬테네그로")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.montenegro);
		} else if (str_national.equals("몰디브")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.maldives);
		} else if (str_national.equals("몽골")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.mongol);
		} else if (str_national.equals("미국")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.usa);
		} else if (str_national.equals("미얀마")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.myanmar);
		} else if (str_national.equals("미크로네시아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.micronesia);
		} else if (str_national.equals("바레인")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.bahrain);
		} else if (str_national.equals("방글라데시")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.bangladesh);
		} else if (str_national.equals("베네수엘라")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.venezuela);
		} else if (str_national.equals("베트남")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.vietnam);
		} else if (str_national.equals("벨기에")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.belgium);
		} else if (str_national.equals("벨라루스")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.belarus);
		} else if (str_national.equals("보스니아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.bosna);
		} else if (str_national.equals("부르키나파소")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.burkinafaso);
		} else if (str_national.equals("북아일랜드")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.northernireland);
		} else if (str_national.equals("북한")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.northkorea);
		} else if (str_national.equals("불가리아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.bulgaria);
		} else if (str_national.equals("브라질")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.brazil);
		} else if (str_national.equals("브루나이")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.brunei);
		} else if (str_national.equals("사우디아라비아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.saudiarabia);
		} else if (str_national.equals("세네갈")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.senegal);
		} else if (str_national.equals("세르비아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.serbia);
		} else if (str_national.equals("솔로몬 제도")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.solomonislands);
		} else if (str_national.equals("수단")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.sudan);
		} else if (str_national.equals("스리랑카")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.srilanka);
		} else if (str_national.equals("스웨덴")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.sweden);
		} else if (str_national.equals("스위스")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.suisse);
		} else if (str_national.equals("스코틀랜드")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.scotland);
		} else if (str_national.equals("스페인")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.spain);
		} else if (str_national.equals("슬로바키아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.slovakia);
		} else if (str_national.equals("슬로베니아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.slovenia);
		} else if (str_national.equals("시리아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.syria);
		} else if (str_national.equals("싱가폴")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.singapore);
		} else if (str_national.equals("아랍에미리트")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.uae);
		} else if (str_national.equals("아르메니아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.armenia);
		} else if (str_national.equals("아르헨티나")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.argentina);
		} else if (str_national.equals("아이슬란드")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.iceland);
		} else if (str_national.equals("아일랜드")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.ireland);
		} else if (str_national.equals("아프가니스탄")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.afghanistan);
		} else if (str_national.equals("알바니아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.albania);
		} else if (str_national.equals("알제리")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.algerie);
		} else if (str_national.equals("앤티가바부다")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.antiguaandbarbuda);
		} else if (str_national.equals("에콰도르")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.ecuador);
		} else if (str_national.equals("에티오피아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.ethiopia);
		} else if (str_national.equals("예멘")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.yemen);
		} else if (str_national.equals("오만")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.oman);
		} else if (str_national.equals("오스트리아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.austria);
		} else if (str_national.equals("요르단")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.jordan);
		} else if (str_national.equals("우간다")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.uganda);
		} else if (str_national.equals("우루과이")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.uruguay);
		} else if (str_national.equals("우즈베키스탄")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.uzbekistan);
		} else if (str_national.equals("우크라이나")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.ukraina);
		} else if (str_national.equals("유고슬라비아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.ugo);
		} else if (str_national.equals("웨일스")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.wales);
		} else if (str_national.equals("이라크")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.iraq);
		} else if (str_national.equals("이란")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.iran);
		} else if (str_national.equals("이스라엘")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.israel);
		} else if (str_national.equals("이집트")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.egypt);
		} else if (str_national.equals("이탈리아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.italy);
		} else if (str_national.equals("인도")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.india);
		} else if (str_national.equals("인도네시아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.indonesia);
		} else if (str_national.equals("일본")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.japan);
		} else if (str_national.equals("잉글랜드")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.england);
		} else if (str_national.equals("자메이카")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.jameica);
		} else if (str_national.equals("조지아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.georgia);
		} else if (str_national.equals("중국")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.china);
		} else if (str_national.equals("지부티")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.djibouti);
		} else if (str_national.equals("지브롤터")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.gibraltar);
		} else if (str_national.equals("짐바브웨")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.zimbabwe);
		} else if (str_national.equals("차드")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.chad);
		} else if (str_national.equals("체코")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.czech);
		} else if (str_national.equals("칠레")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.chile);
		} else if (str_national.equals("카메룬")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.cameroon);
		} else if (str_national.equals("카자흐스탄")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.kazakhstan);
		} else if (str_national.equals("카타르")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.qatar);
		} else if (str_national.equals("캄보디아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.cambodia);
		} else if (str_national.equals("캐나다")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.canada);
		} else if (str_national.equals("케냐")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.kenya);
		} else if (str_national.equals("케이프베르디 제도")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.capeverde);
		} else if (str_national.equals("코소보")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.kosovo);
		} else if (str_national.equals("코스타리카")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.costarica);
		} else if (str_national.equals("코트디부아르")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.cotedvoire);
		} else if (str_national.equals("콜롬비아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.colombia);
		} else if (str_national.equals("콩고")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.congo);
		} else if (str_national.equals("콩고민주공화국")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.republiccongo);
		} else if (str_national.equals("쿠바")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.cuba);
		} else if (str_national.equals("쿠웨이트")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.kuwait);
		} else if (str_national.equals("크로아티아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.croatia);
		} else if (str_national.equals("키르키스스탄")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.kirgizstan);
		} else if (str_national.equals("타지키스탄")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.tadzhikistan);
		} else if (str_national.equals("탄자니아")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.tanzania);
		} else if (str_national.equals("태국")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.thailand);
		} else if (str_national.equals("터키")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.turkey);
		}else if (str_national.equals("토고")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.togo);
		} else if (str_national.equals("투르크메니스탄")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.turkmenistan);
		} else if (str_national.equals("튀니지")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.tuninisi);
		} else if (str_national.equals("트리니다드 토바고")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.trinidadtobago);
		} else if (str_national.equals("파나마")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.panama);
		} else if (str_national.equals("파라과이")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.paraguay);
		} else if (str_national.equals("파키스탄")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.pakistan);
		} else if (str_national.equals("팔레스타인")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.palestine);
		} else if (str_national.equals("페로 제도")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.faroeisland);
		} else if (str_national.equals("페루")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.peru);
		} else if (str_national.equals("포르투갈")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.portugal);
		} else if (str_national.equals("폴란드")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.poland);
		}else if (str_national.equals("프랑스")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.france);
		} else if (str_national.equals("핀란드")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.finland);
		} else if (str_national.equals("필리핀")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.philippines);
		} else if (str_national.equals("헝가리")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.hungary);
		} else if (str_national.equals("호주")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.australia);
		} else if (str_national.equals("홍콩")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.hongkong);
		} else if (str_national.equals("안드로메다")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.andromeda);
		}


		return img_country;
	}

	public ArrayList<String> listAdd(){
		list = new ArrayList<String>();
		list.add("가나");
		list.add("가봉");
		list.add("가이아나");
		list.add("감비아");
		list.add("과테말라");
		list.add("괌");
		list.add("그레나다");
		list.add("그리스");
		list.add("기니");
		list.add("기니 비사우");
		list.add("나미비아");
		list.add("나이지리아");
		list.add("남아프리카공화국");
		list.add("네덜란드");
		list.add("네팔");
		list.add("노르웨이");
		list.add("뉴질랜드");
		list.add("대만");
		list.add("대한민국");
		list.add("덴마크");
		list.add("독일");
		list.add("라이베리아");
		list.add("러시아");
		list.add("레바논");
		list.add("루마니아");
		list.add("룩셈부르크");
		list.add("리비아");
		list.add("리투아니아");
		list.add("마다가스카르");
		list.add("마케도니아");
		list.add("마카오");
		list.add("말레이시아");
		list.add("말리");
		list.add("멕시코");
		list.add("모로코");
		list.add("몬테네그로");
		list.add("몰디브");
		list.add("몽골");
		list.add("미국");
		list.add("미얀마");
		list.add("미크로네시아");
		list.add("바레인");
		list.add("방글라데시");
		list.add("베네수엘라");
		list.add("베트남");
		list.add("벨기에");
		list.add("벨라루스");
		list.add("보스니아");
		list.add("부르키나파소");
		list.add("북아일랜드");
		list.add("북한");
		list.add("불가리아");
		list.add("브라질");
		list.add("브루나이");
		list.add("사우디아라비아");
		list.add("세네갈");
		list.add("세르비아");
		list.add("솔로몬 제도");
		list.add("수단");
		list.add("스리랑카");
		list.add("스웨덴");
		list.add("스위스");
		list.add("스코틀랜드");
		list.add("스페인");
		list.add("슬로바키아");
		list.add("슬로베니아");
		list.add("시리아");
		list.add("싱가폴");
		list.add("아랍에미리트");
		list.add("아르메니아");
		list.add("아르헨티나");
		list.add("아이슬란드");
		list.add("아일랜드");
		list.add("아프가니스탄");
		list.add("알바니아");
		list.add("알제리");
		list.add("앤티가바부다");
		list.add("에콰도르");
		list.add("에티오피아");
		list.add("예멘");
		list.add("오만");
		list.add("오스트리아");
		list.add("요르단");
		list.add("우간다");
		list.add("우루과이");
		list.add("우즈베키스탄");
		list.add("우크라이나");
		list.add("유고슬라비아");
		list.add("웨일스");
		list.add("이라크");
		list.add("이란");
		list.add("이스라엘");
		list.add("이집트");
		list.add("이탈리아");
		list.add("인도");
		list.add("인도네시아");
		list.add("일본");
		list.add("잉글랜드");
		list.add("자메이카");
		list.add("조지아");
		list.add("중국");
		list.add("지부티");
		list.add("지브롤터");
		list.add("짐바브웨");
		list.add("차드");
		list.add("체코");
		list.add("칠레");
		list.add("카메룬");
		list.add("카자흐스탄");
		list.add("카타르");
		list.add("캄보디아");
		list.add("캐나다");
		list.add("케냐");
		list.add("케이프베르디 제도");
		list.add("코소보");
		list.add("코스타리카");
		list.add("코트디부아르");
		list.add("콜롬비아");
		list.add("콩고");
		list.add("콩고민주공화국");
		list.add("쿠바");
		list.add("쿠웨이트");
		list.add("크로아티아");
		list.add("키르키스스탄");
		list.add("타지키스탄");
		list.add("탄자니아");
		list.add("태국");
		list.add("터키");
		list.add("토고");
		list.add("투르크메니스탄");
		list.add("튀니지");
		list.add("트리니다드 토바고");
		list.add("파나마");
		list.add("파라과이");
		list.add("파키스탄");
		list.add("팔레스타인");
		list.add("페로 제도");
		list.add("페루");
		list.add("포르투갈");
		list.add("폴란드");
		list.add("프랑스");
		list.add("핀란드");
		list.add("필리핀");
		list.add("헝가리");
		list.add("호주");
		list.add("홍콩");
		return list;
	}
	public static BitmapDrawable getCountryBitmapDrawbleEn(Context context, String str_national){

		BitmapDrawable img_country = null;
		if (str_national.equals("Ghana")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.ghana);
		} else if (str_national.equals("Gabon")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.gabon);
		} else if (str_national.equals("Guyana")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.guyana);
		} else if (str_national.equals("Gambia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.gambia);
		} else if (str_national.equals("Guatemala")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.guatemala);
		} else if (str_national.equals("Guam")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.guam);
		} else if (str_national.equals("Grenada")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.grenada);
		} else if (str_national.equals("Greece")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.greece);
		} else if (str_national.equals("Guinea")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.guinea);
		} else if (str_national.equals("Guinebissau")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.guinebissau);
		} else if (str_national.equals("Namibia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.namibia);
		} else if (str_national.equals("Nigeria")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.nigeria);
		} else if (str_national.equals("Southafrica")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.southafrica);
		} else if (str_national.equals("Netherlands")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.netherlands);
		} else if (str_national.equals("Nepal")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.nepal);
		}else if (str_national.equals("Norway")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.norway);
		} else if (str_national.equals("Newzealand")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.newzealand);
		} else if (str_national.equals("Korea")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.korea);
		} else if (str_national.equals("Denmark")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.denmark);
		} else if (str_national.equals("Germany")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.germany);
		} else if (str_national.equals("Liberia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.liberia);
		} else if (str_national.equals("Russia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.russia);
		} else if (str_national.equals("Lebanon")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.lebanon);
		} else if (str_national.equals("Rumania")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.rumania);
		} else if (str_national.equals("Luxemburg")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.luxemburg);
		} else if (str_national.equals("Libya")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.libya);
		}else if (str_national.equals("Lithuania")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.lithuania);
		} else if (str_national.equals("Madagascar")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.madagascar);
		} else if (str_national.equals("Macedonia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.macedonia);
		} else if (str_national.equals("Macau")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.macau);
		} else if (str_national.equals("Malaysia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.malaysia);
		} else if (str_national.equals("Mali")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.mali);
		} else if (str_national.equals("Mexico")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.mexico);
		} else if (str_national.equals("Morocco")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.morocco);
		} else if (str_national.equals("Montenegro")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.montenegro);
		} else if (str_national.equals("Maldives")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.maldives);
		} else if (str_national.equals("Mongol")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.mongol);
		} else if (str_national.equals("USA")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.usa);
		} else if (str_national.equals("Myanmar")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.myanmar);
		} else if (str_national.equals("Bahrain")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.bahrain);
		} else if (str_national.equals("Bangladesh")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.bangladesh);
		} else if (str_national.equals("Venezuela")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.venezuela);
		} else if (str_national.equals("Vietnam")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.vietnam);
		} else if (str_national.equals("Belgium")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.belgium);
		} else if (str_national.equals("Belarus")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.belarus);
		} else if (str_national.equals("Bosna")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.bosna);
		} else if (str_national.equals("Burkinafaso")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.burkinafaso);
		} else if (str_national.equals("Northernireland")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.northernireland);
		} else if (str_national.equals("Northkorea")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.northkorea);
		} else if (str_national.equals("Bulgaria")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.bulgaria);
		} else if (str_national.equals("Brazil")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.brazil);
		} else if (str_national.equals("Brunei")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.brunei);
		} else if (str_national.equals("Saudiarabia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.saudiarabia);
		} else if (str_national.equals("Senegal")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.senegal);
		} else if (str_national.equals("Serbia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.serbia);
		} else if (str_national.equals("Solomonislands")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.solomonislands);
		} else if (str_national.equals("Sudan")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.sudan);
		} else if (str_national.equals("Srilanka")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.srilanka);
		} else if (str_national.equals("Sweden")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.sweden);
		} else if (str_national.equals("Suisse")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.suisse);
		} else if (str_national.equals("Scotland")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.scotland);
		} else if (str_national.equals("Spain")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.spain);
		} else if (str_national.equals("Slovakia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.slovakia);
		} else if (str_national.equals("Slovenia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.slovenia);
		} else if (str_national.equals("Syria")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.syria);
		} else if (str_national.equals("Singapore")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.singapore);
		} else if (str_national.equals("UAE")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.uae);
		} else if (str_national.equals("Armenia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.armenia);
		} else if (str_national.equals("Argentina")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.argentina);
		} else if (str_national.equals("Iceland")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.iceland);
		} else if (str_national.equals("Ireland")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.ireland);
		} else if (str_national.equals("Afghanistan")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.afghanistan);
		} else if (str_national.equals("Albania")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.albania);
		} else if (str_national.equals("Algerie")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.algerie);
		} else if (str_national.equals("AntiguaBarbuda")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.antiguaandbarbuda);
		} else if (str_national.equals("Ecuador")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.ecuador);
		} else if (str_national.equals("Ethiopia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.ethiopia);
		} else if (str_national.equals("Yemen")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.yemen);
		} else if (str_national.equals("Oman")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.oman);
		} else if (str_national.equals("Austria")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.austria);
		} else if (str_national.equals("Jordan")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.jordan);
		} else if (str_national.equals("Uganda")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.uganda);
		} else if (str_national.equals("Uruguay")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.uruguay);
		} else if (str_national.equals("Uzbekistan")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.uzbekistan);
		} else if (str_national.equals("Ukraina")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.ukraina);
		} else if (str_national.equals("Wales")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.wales);
		} else if (str_national.equals("Iraq")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.iraq);
		} else if (str_national.equals("Iran")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.iran);
		} else if (str_national.equals("Israel")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.israel);
		} else if (str_national.equals("Egypt")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.egypt);
		} else if (str_national.equals("Italy")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.italy);
		} else if (str_national.equals("India")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.india);
		} else if (str_national.equals("Indonesia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.indonesia);
		} else if (str_national.equals("Japan")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.japan);
		} else if (str_national.equals("England")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.england);
		} else if (str_national.equals("Jameica")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.jameica);
		} else if (str_national.equals("Georgia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.georgia);
		} else if (str_national.equals("China")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.china);
		} else if (str_national.equals("Djibouti")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.djibouti);
		} else if (str_national.equals("Zimbabwe")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.zimbabwe);
		} else if (str_national.equals("Chad")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.chad);
		} else if (str_national.equals("Czech")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.czech);
		} else if (str_national.equals("Chile")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.chile);
		} else if (str_national.equals("Cameroon")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.cameroon);
		} else if (str_national.equals("Kazakhstan")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.kazakhstan);
		} else if (str_national.equals("Qatar")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.qatar);
		} else if (str_national.equals("Cambodia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.cambodia);
		} else if (str_national.equals("Canada")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.canada);
		} else if (str_national.equals("Kenya")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.kenya);
		} else if (str_national.equals("Capeverde")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.capeverde);
		} else if (str_national.equals("Kosovo")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.kosovo);
		} else if (str_national.equals("Costarica")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.costarica);
		} else if (str_national.equals("Cotedvoire")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.cotedvoire);
		} else if (str_national.equals("Colombia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.colombia);
		} else if (str_national.equals("Congo")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.congo);
		} else if (str_national.equals("RepublicCongo")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.republiccongo);
		} else if (str_national.equals("Cuba")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.cuba);
		} else if (str_national.equals("Kuwait")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.kuwait);
		} else if (str_national.equals("Croatia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.croatia);
		} else if (str_national.equals("Kirgizstan")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.kirgizstan);
		} else if (str_national.equals("Tadzhikistan")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.tadzhikistan);
		}else if (str_national.equals("Taiwan")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.taiwan);
		} else if (str_national.equals("Tanzania")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.tanzania);
		} else if (str_national.equals("Thailand")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.thailand);
		} else if (str_national.equals("Turkey")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.turkey);
		}else if (str_national.equals("Togo")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.togo);
		} else if (str_national.equals("Turkmenistan")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.turkmenistan);
		} else if (str_national.equals("Tuninisi")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.tuninisi);
		} else if (str_national.equals("Trinidadtobago")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.trinidadtobago);
		} else if (str_national.equals("Panama")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.panama);
		} else if (str_national.equals("Paraguay")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.paraguay);
		} else if (str_national.equals("Pakistan")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.pakistan);
		} else if (str_national.equals("Palestine")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.palestine);
		} else if (str_national.equals("Faroeisland")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.faroeisland);
		} else if (str_national.equals("Peru")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.peru);
		} else if (str_national.equals("Portugal")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.portugal);
		} else if (str_national.equals("Poland")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.poland);
		}else if (str_national.equals("France")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.france);
		} else if (str_national.equals("Finland")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.finland);
		} else if (str_national.equals("Philippines")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.philippines);
		} else if (str_national.equals("Hungary")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.hungary);
		} else if (str_national.equals("Australia")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.australia);
		} else if (str_national.equals("Hongkong")) {
			img_country = (BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.hongkong);
		}


		return img_country;
	}

	public ArrayList<String> listAddEn() {
		list = new ArrayList<String>();
		list.add("Afghanistan");
		list.add("Albania");
		list.add("Algerie");
		list.add("AntiguaBarbuda");
		list.add("Armenia");
		list.add("Argentina");
		list.add("Austria");
		list.add("Australia");
		list.add("Bahrain");
		list.add("Bangladesh");
		list.add("Belgium");
		list.add("Belarus");
		list.add("Bosna");
		list.add("Burkinafaso");
		list.add("Bulgaria");
		list.add("Brazil");
		list.add("Brunei");
		list.add("China");
		list.add("Chad");
		list.add("Czech");
		list.add("Chile");
		list.add("Cameroon");
		list.add("Cambodia");
		list.add("Canada");
		list.add("Capeverde");
		list.add("Costarica");
		list.add("Cotedvoire");
		list.add("Colombia");
		list.add("Congo");
		list.add("Cuba");
		list.add("Croatia");
		list.add("Denmark");
		list.add("Djibouti");
		list.add("Ecuador");
		list.add("Ethiopia");
		list.add("Egypt");
		list.add("England");
		list.add("Faroeisland");
		list.add("France");
		list.add("Finland");
		list.add("Gabon");
		list.add("Gambia");
		list.add("Georgia");
		list.add("Germany");
		list.add("Ghana");
		list.add("Grenada");
		list.add("Greece");
		list.add("Guyana");
		list.add("Guatemala");
		list.add("Guam");
		list.add("Guinea");
		list.add("Guinebissau");
		list.add("Hungary");
		list.add("Hongkong");
		list.add("Iceland");
		list.add("Ireland");
		list.add("Iraq");
		list.add("Iran");
		list.add("Israel");
		list.add("Italy");
		list.add("India");
		list.add("Indonesia");
		list.add("Japan");
		list.add("Jameica");
		list.add("Jordan");
		list.add("Kazakhstan");
		list.add("Korea");
		list.add("Kenya");
		list.add("Kosovo");
		list.add("Kuwait");
		list.add("Kirgizstan");
		list.add("Lebanon");
		list.add("Liberia");
		list.add("Luxemburg");
		list.add("Libya");
		list.add("Lithuania");
		list.add("Madagascar");
		list.add("Macedonia");
		list.add("Macau");
		list.add("Malaysia");
		list.add("Mali");
		list.add("Mexico");
		list.add("Morocco");
		list.add("Montenegro");
		list.add("Maldives");
		list.add("Mongol");
		list.add("Myanmar");
		list.add("Netherlands");
		list.add("Nepal");
		list.add("Norway");
		list.add("Newzealand");
		list.add("Namibia");
		list.add("Nigeria");
		list.add("Northernireland");
		list.add("Northkorea");
		list.add("Oman");
		list.add("Peru");
		list.add("Portugal");
		list.add("Poland");
		list.add("Philippines");
		list.add("Panama");
		list.add("Paraguay");
		list.add("Pakistan");
		list.add("Palestine");
		list.add("Qatar");
		list.add("RepublicCongo");
		list.add("Russia");
		list.add("Rumania");
		list.add("Southafrica");
		list.add("Saudiarabia");
		list.add("Senegal");
		list.add("Serbia");
		list.add("Solomonislands");
		list.add("Sudan");
		list.add("Srilanka");
		list.add("Sweden");
		list.add("Suisse");
		list.add("Scotland");
		list.add("Spain");
		list.add("Slovakia");
		list.add("Slovenia");
		list.add("Syria");
		list.add("Singapore");
		list.add("Tadzhikistan");
		list.add("Tanzania");
		list.add("Taiwan");
		list.add("Thailand");
		list.add("Turkey");
		list.add("Togo");
		list.add("Turkmenistan");
		list.add("Tuninisi");
		list.add("Trinidadtobago");
		list.add("USA");
		list.add("UAE");
		list.add("Uganda");
		list.add("Uruguay");
		list.add("Uzbekistan");
		list.add("Ukraina");
		list.add("Venezuela");
		list.add("Vietnam");
		list.add("Wales");
		list.add("Yemen");
		list.add("Zimbabwe");

		return list;
	}


}
