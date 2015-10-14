package test.main;

import java.util.HashSet;

public class HwatooTest {
	
	

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		set.add("3광");
		set.add("8광");
		
		boolean check = set.contains("3광");
		
		
		
		if (set.contains("3광") && set.contains("8광"))
			System.out.println("38광땡");
		
	}

}
