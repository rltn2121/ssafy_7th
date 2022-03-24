package basic;


public class PassByValueTest {
	public static void main(String[] args) {
		int i = 10;
		setVal(i);
		System.out.println(i);
		
		Pass p = new Pass();
		setVal(p);
		System.out.println(p.val);
	}
	
//	새로운 변수  int x가 생성됨
	static void setVal(int x) {
		x = 5;
	}
	
//	 전달받은 클래스 Pass p의 주소가 복사됨
	static void setVal(Pass p) {
		p.val = 5;
	}
	
	static class Pass{
		public int val = 10;
	}
}
