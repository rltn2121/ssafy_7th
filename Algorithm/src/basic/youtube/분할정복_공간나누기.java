package basic.youtube;

import java.util.Scanner;

public class 분할정복_공간나누기 {
	static int white, green;
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt()	;
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				
			}
		}
		cut(N,0,0);
		System.out.println(white);
		System.out.println(green);
	}
	
	static void cut(int size, int r, int c) {
		int sum = 0;
		for(int i = r; i<r+size; i++) {
			for(int j = c; j<c+size; j++) {
				sum+=arr[i][j];
			}
		}
		if(sum == size*size) green++;
		else if(sum==0)	white++;
		else {
			cut(size/2,r,c);
			cut(size/2,r+size/2,c);
			cut(size/2,r,c+size/2);
			cut(size/2,r+size/2,c+size/2);
		}
	}
}
