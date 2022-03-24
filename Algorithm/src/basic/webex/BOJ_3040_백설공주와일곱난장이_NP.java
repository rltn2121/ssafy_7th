package basic.webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040_백설공주와일곱난장이_NP {
	static int S = 9, T = 7;
	static int[] arr = new int[S];
	
	static int[] index = new int[S];	// 000000000 => 001111111 => ... => 111111100
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i<S; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<T; i++)
			index[(S-1)-i] = 1;
		
		do {
			int sum = 0;
			for(int i = 0; i<S; i++) {
				if(index[i] == 1)
					sum+=arr[i];
			}
			
			if(sum == 100) {
				for(int i = 0; i<S; i++) {
					if(index[i] == 1)
						System.out.println(arr[i]);
				}
				break;
			}
			
			
		}while(np(index));
	}
	
	static boolean np(int[] arr) {
		int length = arr.length - 1;
		int i = length;
		int j = length;
		int k = length;
		// 1. 값이 작아지는 지점 찾기
		while(i>0&&arr[i-1]>=arr[i])
			i--;
		
		// 끝에 도착 -> 다음 순열 없음
		if(i==0)
			return false;
		
		// 2. 바꿀 숫자 찾기
		while(arr[i-1] >= arr[j])
			j--;
	
		swap(arr, i-1, j);
		
		
		while(i<k)
			swap(arr, i, k);
		return true;
	}
	
	static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
