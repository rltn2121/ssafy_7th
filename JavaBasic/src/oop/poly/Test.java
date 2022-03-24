package oop.poly;

public class Test {
	public static void main(String[] args) {
		C a = new C();
		m(a);
		
		B b = new B();
		m(b);			// A - m() (B is a A 이기 때문)
		
		D d = new D();
		m(d);			// C - m() (C is a D 이기 때문)
		
		B bd = new D();
		m(d);			// A - m() (선언과 구현체가 다르면 선언의 타입을 따름)
	}
	
	static void m(A a) {
		System.out.println("A - m()");
	}
	
	static void m(C c) {
		System.out.println("C - m()");
	}

	static void m2(A a) {	
		// 항상 A 객체만 찍힘
		// 역순으로 해야 함
		if(a instanceof A)	System.out.println("A 객체!");
		else if(a instanceof B)	System.out.println("B 객체!");
		else if(a instanceof C)	System.out.println("C 객체!");
	}
	
	static void m3(A a) {	
		if(a instanceof C)	System.out.println("C 객체!");
		else if(a instanceof B)	System.out.println("B 객체!");
		else if(a instanceof A)	System.out.println("A 객체!");
	}
}
