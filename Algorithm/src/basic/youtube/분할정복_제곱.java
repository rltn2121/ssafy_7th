package basic.youtube;

import java.util.Scanner;

public class 분할정복_제곱 {
	static int callCnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
	}
	
	public static long exp(long x, long n) {
		callCnt++;
		if(n==1) return x;
		
		
		long y = exp(x, n/2);
		return (n%2==0)?y*y:y*y*x;
	}
}
