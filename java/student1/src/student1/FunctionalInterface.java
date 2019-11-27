package student1;

import java.util.function.Function;

public class FunctionalInterface {
	public static void main(String[] args) {
		
		Function<String, Integer> fn=x-> x.length();
		int ans=fn.apply("pppp");
		System.out.println("the length is  "+ans);
		
	}

}
