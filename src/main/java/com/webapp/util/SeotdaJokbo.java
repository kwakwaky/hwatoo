package com.webapp.util;

import java.util.HashSet;

public class SeotdaJokbo {
	
	private String card1, card2;	// 해당 카드 2장으로 조합 판별
	
	public SeotdaJokbo(String card1, String card2) {
		this.card1 = card1;
		this.card2 = card2;
	}
	
	// 족보 판별기 main
	public String getJokbo() {
		
		HashSet<String> set = new HashSet<>();
		set.add(card1);
		set.add(card2);
		
		if (card1 == null || card2 == null)
			return "2장의 카드가 모두 입력되어야 합니다.";
		// 38광땡
		else if (set.contains("3g") && set.contains("8g"))
			return "38광땡";
		// 13광땡
		else if (set.contains("1g") && set.contains("3g"))
			return "13광땡";
		// 18광땡
		else if (set.contains("1g") && set.contains("8g"))
			return "18광땡";	
		// 1~10땡
		else if (card1.charAt(0) == card2.charAt(0))
			return getDdang();	
		
		// 알리 (1월 , 2월)
		else if (getUnderDdang('1', '2'))
			return "알리";
		// 독사 (1월 , 4월)
		else if (getUnderDdang('1', '4'))
			return "독사";
		// 구삥 (1월 , 9월)
		else if (getUnderDdang('1', '9'))
			return "독사";
		// 장삥 (1월 , 10월)
		else if (getUnderDdang('1', '0'))
			return "독사";
		// 장사 (4월 , 10월)
		else if (getUnderDdang('4', '0'))
			return "독사";
		// 세륙 (4월 , 6월)
		else if (getUnderDdang('4', '6'))
			return "독사";
		// 끗
		else
			return getGgut();
	}
	
	// 땡 판별기
	private String getDdang() {
		if (card1.charAt(0) == '1')
			return "삥땡";
		else if (card1.charAt(0) == '0')
			return "장땡";
		else
			return card1.charAt(0) + "땡";
	}
	
	// 알리, 독사, 구삥, 장삥, 장사, 세륙, 갑오 판별기
	private boolean getUnderDdang(char a, char b) {
		return ((card1.charAt(0) == a) && (card2.charAt(0) == b)) |
			   ((card1.charAt(0) == b) && (card2.charAt(0) == a)) ;
	}
	
	// 끗 판별기
	private String getGgut() {
		int a = Integer.parseInt("" + card1.charAt(0));
		int b = Integer.parseInt("" + card2.charAt(0));
		
		if ((a+b)%10 == 10)
			return "갑오";
		else if ((a+b)%10 == 0)
			return "망통";
		else
			return (a+b)%10 + "끗";
	}
	
}
