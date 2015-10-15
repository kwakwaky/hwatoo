package test.main;

import java.util.HashSet;

import com.webapp.util.SeotdaJokbo;

public class HwatooTest {
	
	

	public static void main(String[] args) {
//		HashSet<String> set = new HashSet<>();
//		set.add("3광");
//		set.add("8광");
//		
//		boolean check = set.contains("3광");
//		
//		System.out.println(set.toString());
//		
//		if (set.contains("3광") && set.contains("8광"))
//			System.out.println("38광땡");
		
//		System.out.println("1g".matches("[" + 1 + "]."));
//		System.out.println("1fdag".charAt(1));
//		
//		if ("1g".charAt(0) == "1t".charAt(0))
//		System.out.println("ok");
		
		SeotdaJokbo sj = new SeotdaJokbo("7d", "1g");
		System.out.println(sj.getJokbo());
		
//		System.out.println(Integer.parseInt("" + '7'));
	}

}
