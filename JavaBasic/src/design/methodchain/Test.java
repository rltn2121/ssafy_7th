package design.methodchain;

public class Test {
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.setFirst(3);
		calc.setSecond(5);
		calc.showAdd();
		
		StringBuilder sb = new StringBuilder();
		String s1 = "...";
		String s2 = "....";
		String s3 = ".....";
		String s4 = "......";
		String s5 = ".......";
		
//		String은 immutable이기 때문에 +로 계속 연결할 경우, 객체가 계속 생성됨
		sb.append(s1).append(s2).append(s3).append(s4).append(s5);
		
		Calculator calc2 = new Calculator();
		
		calc2.setFirst(3).setSecond(5).showAdd().showSub();
	}
}
