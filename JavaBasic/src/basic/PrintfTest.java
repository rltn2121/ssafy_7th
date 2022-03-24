package basic;

public class PrintfTest {
	public static void main(String[] args) {
		int i = 10;
		System.out.printf("%5d\n", i);
		System.out.printf("%5s\n", "abc");
		
		float f = 3.21f;
		System.out.printf("%10f\n", f);
		System.out.printf("%5f\n", f);
		System.out.printf("%8.5f\n", f);
		
		int sum = 100;
		int cnt = 7;
		double avg = 33.4;
		
		System.out.printf("%10d, %5d, %5.5f", sum, cnt, avg);
	}
}
