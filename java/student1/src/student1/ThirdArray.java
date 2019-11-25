package student1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ThirdArray {
	public static void main(String[] args) {
		List<Integer> al=new ArrayList<Integer>();
		al.add(30);
		al.add(53);
		al.add(70);
		al.add(63);
		System.out.println(al);
		
		
		Function<Integer, Integer> fs=x-> x*50;
		
		List<Integer> bl=al.stream().map(fs).collect(Collectors.toList());
		System.out.println(bl);
			
			
		}
	}


