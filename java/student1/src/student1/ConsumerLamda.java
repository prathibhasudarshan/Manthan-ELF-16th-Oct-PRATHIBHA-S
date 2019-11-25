package student1;

import java.util.function.Consumer;

public class ConsumerLamda {
	public static void main(String[] args) {
		Student st=new Student("pppp", 4, 666);
		
		Consumer<Student> c=s->{
			System.out.println(s.name);
			System.out.println(s.age);
			System.out.println(s.per);
		};
		c.accept(st);
	}

}
