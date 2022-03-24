package basic;

public class StringTest {
	public static void main(String[] args) {
		
//		new 를 사용하지 않고 생성 -> 리터럴
//		최초로 생성하고 나면 이후에는 계속 재사용
//		리터럴은 상수 개념
//		int i = 3;
		String s1 = "Hello";	// 리터럴 처음 생성
		String s2 = "Hello";	// 리터럴 재사용
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		
//		동일한 객체인가? (내용은 비교 안함)
		if(s1 == s2)	System.out.println("s1 == s2");
		if(s3 == s4)	System.out.println("s3 == s4");
		
//		문자열 내용이 일치하는가? (같은 객체일 필요 없음)
		if(s1.equals(s2))	System.out.println("s1 equals s2");
		if(s3.equals(s4))	System.out.println("s3 equals s4");
		if(s1.equals(s3))	System.out.println("s1 equals s3");
		if(s4.equals(s2))	System.out.println("s4 equals s2");
		System.out.println();
		
		MyClass mc1 = new MyClass();
		MyClass mc2 = new MyClass();
		
		if(mc1 == mc2)		System.out.println("mc1 == mc2");
		if(mc1.equals(mc2))	System.out.println("mc1 equals mc2");	// 기본적으로 == 와 똑같이 작동함. 
																	// String 클래스는 이미 Overriding 되어있음
																	// 원하는 방식대로 하기 위해선 Overriding 필요
		
		String str = "Ssafy";
		System.out.println(str.length());
		System.out.println(str.charAt(3));
		char[] chArray = str.toCharArray();
		boolean has = str.contains("a");
		int firstIdx = str.indexOf('f');	// 'f'가 나오는 첫 번재 위치
		
		String newStr = str.replace('s', 'x');				// 새 객체를 반환하므로 str이 실제로 변경되지 않음. 
		System.out.println(newStr);
																	
	}
	
	static class MyClass{
		String s = "Hello";
	}
}
