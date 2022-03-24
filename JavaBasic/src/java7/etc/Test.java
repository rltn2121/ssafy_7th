package java7.etc;

public class Test {
	public static void main(String[] args) {
		String str = "ABC";
		switch(str) {
		case "ABC":
			System.out.println("영문");
			break;
			
		case "가나다":
			System.out.println("한글");
			break;
		}
		
		int koreaMoney = 1_0000_0000;
		long cardNo = 1234_1234_1234_1234L;
	}
}
