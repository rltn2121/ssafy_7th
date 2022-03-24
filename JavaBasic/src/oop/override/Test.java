package oop.override;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws Exception {
//		1. 왼쪽 객체 본인과 부모가 해당 메서드를 가지는지 확인  (있으면 실행 가능, 없으면 에러)
//		2. 오른쪽 객체가 오버라이딩을 했는지 확인
		
		{
			A a = new B();
			a.a();			// A - a()
//			a.a(3);			// 오류  -> A에는 a(int)가 없음
		}
		
		{
			B b = new C();	
			b.a();			// C - a()
			b.a(5);			// B - a(int)
			b.b();			// B - b()
//			b.c();			// 오류 -> B에는 c()가 없음
		}
		
		{
			A a = new C();
			a.a();			// C - a()
//			a.a(5)			// 오류 -> A a는 자기가 가지고 있는 것만 호출할 수 있음
//			a.c()			// 오류 -> A a는 자기가 가지고 있는 것만 호출할 수 있음
		}
		{
			B b = new D();
			b.a();			// C - a()
			b.a(5);			// D - a(int i)
			b.b();			// D - b()
//			b.d()			// 오류 -> B에는 d()가 없음
		}
	}
}
