package oop.basic.classobject;

public class Test {
	public static void main(String[] args) {
		// 1. MyClass
		MyClass mc = new MyClass();
		mc.n = 3;
		mc.str = "Hello";
		
		System.out.println(mc.n);
		System.out.println(mc.str);
		
		mc.setN(5);
		System.out.println(mc.n);
		System.out.println(mc.getN());
		
		
		// 2. AnotherClass
		AnotherClass ac = new AnotherClass();
		System.out.println(ac.n);
		
		
		// 3. MoreClass
		MoreClass more = new MoreClass();
		more.ac = new AnotherClass();
		System.out.println(more.ac);
		
		more.mc = new MyClass();
		more.mc.setN(100);
		System.out.println(more.mc.getN());
		
		
	}
}


