package com.ssafy.io;

import java.util.Scanner;

public class IO1_ScannerTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		double b = sc.nextDouble();
		String s = sc.next();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(s);
	}
}
