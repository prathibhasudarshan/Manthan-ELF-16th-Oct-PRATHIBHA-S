package student1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SecondArray {

	public static void main(String[] args) {
		ArrayList<Integer> al=new ArrayList<Integer>();
		al.add(30);
		al.add(53);
		al.add(70);
		al.add(63);
		System.out.println(al);
		
		
		ArrayList<Integer> b1=new ArrayList<Integer>();
		
		
		Predicate<Integer> p=i->i%2!=0;
		
		List<Integer> b=al.stream().filter(p).collect(Collectors.toList());
		System.out.println(b);
		
		
		
		for(Integer r:al)
		{
			if(r%2!=0)
			{
				b1.add(r);
			}
		}
	}

}
