package java8.functionalInterface;

public class Test {
	public static void main(String[] args) {
		MyFuncIF aaa = new MyFuncIFImpl();
		System.out.println(aaa.proc1(3, 5));
		
//		1. MyFuncIF를 구현한 클래스 사용
//		   impl 객체를 한 번만 쓸 거면 impl 객체를 생성하면 낭비
		{
			UseMyFuncIF func = new UseMyFuncIF();
			MyFuncIFImpl impl = new MyFuncIFImpl();
			func.m1(10, 20, new MyFuncIFImpl());
			func.m1(10, 20, impl);
		}
		
		
//		 2. Anonymous Class 객체
//			MyFuncIFImpl 클래스를 안 만들어도 됨
//		 	세번재 파라미터가 호출되는 시험에 객체가 만들어짐
//		
//			컴파일 하게되면 3번째 파라미터에 의해 JVM은 인터페이스를 구현한 클래스를 만든 것과 같은 효과 
//			실행되는 시점에 객체가 생성됨
//		
//			인터페이스를 만들어놓으면 고정적임
//			다른 역할 하고싶으면 인터페이스 구현 하나 더 해야 함
		{
			UseMyFuncIF func = new UseMyFuncIF();
			func.m1(10, 20, new MyFuncIF() {
				@Override
				public int proc1(int n1, int n2) {
					return n1 + n2;
				}
			});
			
			func.m1(10, 20, new MyFuncIF() {
				@Override
				public int proc1(int n1, int n2) {
					return n1 - n2;
				}
			});
		}
		
		
		
//		3. Lambda
//		       람다를 사용하려면 무조건 인터페이스는 만들어야 함
//		   functional interface 자리에만 사용 가능
		{
			UseMyFuncIF func = new UseMyFuncIF();
			func.m1(10, 20, (n1, n2) -> n1 + n2);
			func.m1(10, 20, (n1, n2) -> n1 - n2);
			func.m1(10, 20, (n1, n2) -> n1 * n2);
			func.m1(10, 20, (n1, n2) -> n1 / n2);
		}
	}
}
