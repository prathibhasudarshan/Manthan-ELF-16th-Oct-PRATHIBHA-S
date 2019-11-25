package student1;

import java.util.function.Supplier;

public class SupplierLamda {

	public static void main(String[] args) {
		Supplier<Student> sup=() ->new Student("yyyy", 6, 67);
		Student s=sup.get();
		
		System.out.println(s.name);
		System.out.println(s.age);
		System.out.println(s.per);
	}

}
