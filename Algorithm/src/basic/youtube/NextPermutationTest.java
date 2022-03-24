package basic.youtube;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutationTest {
	static int N, input[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		
		for(int i = 0; i<N; i++)
			input[i] = sc.nextInt();
		
		// 1. 오름차순 정렬
		Arrays.sort(input);
		
		do {
			// 순열 출력
			System.out.println(Arrays.toString(input));
		} while(np());
	}
	
	
	private static boolean np() {
		// 1. 교환 위치 찾기
		int i = N-1;	// 맨 뒤에서부터 탐색 시작
		
		// 더 작은 수를 찾을 때까지 계속 앞으로 이동 (꺾이는 지점 찾기)
		while(i > 0 && input[i-1] >= input[i])
			i--;
		
		// 끝까지 탐색했을 경우 (만들 수 있는 가장 큰 순열 생성)
		if(i==0)
			return false;
		
		
		// 2. 교환 위치에 교환할 값 찾기
		int j = N-1;
		// 더 큰 수를 찾을 때까지 반복 탐색
		while(input[i-1] >= input[j])
			j--;
		
		
		// 3. 교환 위치와 교환할 값 교환하기
		swap(i-1, j);
		
		
		// 4. 교환위치 뒤(꼭대기)부터 맨 뒤까지 만들 수 있는 가장 작은 순열 생성 (오름차순 정렬)
		int k = N-1;
		while(i<k)
			swap(i++,k--);
		
		return true;
	}


	private static void swap(int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
