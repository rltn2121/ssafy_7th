package oop.basic.staticc;

public class MyClass {
	// 객체 생성하지 않아도 접근 가능
	static int COUNT = 10;
	int num = 20;
	
	static void staticMethod() {
		System.out.println("staticMethod()");
	}
	
	// 메모리에 로드할 때 자동으로 실행됨
	// 
	static {
		System.out.println("static block!!");
	}
}
