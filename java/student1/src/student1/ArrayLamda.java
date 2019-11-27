package student1;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ArrayLamda {
	public static void main(String[] args) {
		ArrayList<Integer> al=new ArrayList<Integer>();
		al.add(30);
		al.add(53);
		al.add(70);
		al.add(63);
		System.out.println(al);
		
		Predicate<Integer> a=x-> x%2 !=0;
		
		boolean ans=a.test(8);
		System.out.println(ans);
			
		
		
	}

}
