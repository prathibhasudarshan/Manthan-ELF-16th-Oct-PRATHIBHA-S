package student1;

import java.util.function.Predicate;

public class StudentTest {

	public static void main(String[] args) {
		Student st=new Student("ppp", 23, 45);
		Predicate<Student> ps=s->{
			if(s.per>=35)
			{
				return true;
			}
			else {
				return false;
			}
		};
		
		boolean ans=ps.test(st);
		System.out.println("result is "+ans);
		
	}

}
