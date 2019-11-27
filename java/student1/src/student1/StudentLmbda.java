package student1;

import java.util.function.Function;

public class StudentLmbda {
	public static void main(String[] args) {
		Student st=new Student("pppp", 22, 78);
		Function<Student, Student> fs=x->{
			x.per=x.per+4;
			return x;
		};
		
		
		Student t=fs.apply(st);
		System.out.println(t.per);
	}

}
