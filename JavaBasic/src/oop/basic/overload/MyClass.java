package oop.basic.overload;

public class MyClass {
	void method() {
		System.out.println("method()");
	}
	
	void method(int n) {
		System.out.println("method(int n)");
	}
	
	void method(int... args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
	}
	
	// method signature: 메서드 이름 + 파라미터
	void method(int n, String str) {
		System.out.println("method(int n, String str)");
	}
	

	// 리턴 타입은 method signature에 포함 안됨
//	int method(int n, String str) {
//		System.out.println("method(int n, String str)");
//	}
	
	MyClass() {}
	MyClass(int n) {}
	MyClass(int n, String str){}
	
	
}
