package basic.youtube;

import java.util.Scanner;

public class CombinationNPTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		int[] input = new int[N];
		for(int i = 0; i<N; i++)
			input[i] = sc.nextInt();
		
		int[] p = new int[N];
		
		// p 배열에 0보다 큰 값으로 R개를 맨 뒤부터 채운다.
		// 4C2 -> 0011
		int cnt = 0;
		while(++cnt <= R)
			p[N-cnt] = 1;
		
		do {
			for(int i = 0; i<N; i++) {
				if(p[i]==1)
					System.out.print(input[i] + " ");
			}
			System.out.println();
		} while(np(p));
	}
	private static boolean np(int[] p) {
		// 1. 교환 위치 찾기
		int N = p.length;
		int i = N-1;	// 맨 뒤에서부터 탐색 시작
		
		// 더 작은 수를 찾을 때까지 계속 앞으로 이동 (꺾이는 지점 찾기)
		while(i > 0 && p[i-1] >= p[i])
			i--;
		
		// 끝까지 탐색했을 경우 (만들 수 있는 가장 큰 순열 생성)
		if(i==0)
			return false;
		
		
		// 2. 교환 위치에 교환할 값 찾기
		int j = N-1;
		// 더 큰 수를 찾을 때까지 반복 탐색
		while(p[i-1] >= p[j])
			j--;
		
		
		// 3. 교환 위치와 교환할 값 교환하기
		swap(p, i-1, j);
		
		
		// 4. 교환위치 뒤(꼭대기)부터 맨 뒤까지 만들 수 있는 가장 작은 순열 생성 (오름차순 정렬)
		int k = N-1;
		while(i<k)
			swap(p, i++,k--);
		
		return true;
	}
	
	private static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}
}
