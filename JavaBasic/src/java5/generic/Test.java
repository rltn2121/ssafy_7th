package java5.generic;

public class Test {
	public static void main(String[] args) {
		
		// String
		StringContainer sc = new StringContainer();
		sc.setElement("String");
		
		// A
		// AContainer -> 담고자 하는 type별로 Container를 만들어야 한다
		// Object 타입   -> Casting 이슈 계속 발생
		
		
		// Generic
		// 자료구조를 타입별로 모두 생성하지 않아도 됨
		GenericContainer<String> gc = new GenericContainer<>();
		gc.setElement("String");
		
		GenericContainer<MyClass> gc2 = new GenericContainer<>();
		gc2.setElement(new MyClass());
		
	}
	
	static class MyClass{
		String name;
		int age;
	}
}
