package com.ssafy.ws01.step3;

public class DigitTest1 {

	public static void main(String[] args) {
		int cnt = 0;
		
		for(int i=5;i>0; i--) {
			int spaceCnt = 5-i;
			
			// 공백 출력
			printSpace(spaceCnt);
			
			// 숫자 출력
			for(int j = 0; j<i; j++)
				System.out.printf("%3d", ++cnt);
			
			System.out.println();
		}
	}
	
	private static void printSpace(int n) {
		for(int i = 0; i<n; i++)
			System.out.printf("%3s", " ");
	}
	
}
