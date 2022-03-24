package oop.basic.staticc;
public class Test {
	public static void main(String[] args) {
		// 객체 생성하지 않아도 접근 가능
		System.out.println(MyClass.COUNT);
		MyClass.staticMethod();
		
		MyClass mc = new MyClass();
		System.out.println(mc.num);
		
		// System.out.println(mc.COUNT);	-> 오류는 발생하지 않지만 warning. 좋은 방법 아님
		
	}
	
	// 메모리에 로드할 때 자동으로 실행됨
	static {
		System.out.println("main static block!!");
	}
}
