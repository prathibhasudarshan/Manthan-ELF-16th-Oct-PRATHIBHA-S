package student1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Comparater {
	public static void main(String[] args) {
		List<Integer> al=new ArrayList<Integer>();
		al.add(30);
		al.add(53);
		al.add(70);
		al.add(63);
		System.out.println(al);
		
		Comparator<Integer> c=(i,j)->i.compareTo(j);
		
	int a=al.stream().min(c).get();
	System.out.println(a);
	}

}
