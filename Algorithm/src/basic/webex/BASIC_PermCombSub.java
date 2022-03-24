package basic.webex;

import java.util.Arrays;

public class BASIC_PermCombSub {
	static int ans = 0;
	static int[] input = {1,2,3,4,5};
	static int[] arr = new int[3];
	public static void main(String[] args) {
//		perm(0);
//		comb(0, 0);
//		comb2(0,0);
		subset(0);
		System.out.println(ans);
	}
	
	// 1. 순열
	// flag: 뽑힌 수들에 대한 플래그 비트 열
	static void perm(int cnt, int flag) {
		if(cnt == arr.length) {
			System.out.println(Arrays.toString(arr));
			ans++;
			return;
		}
		
		for(int i = 0; i<input.length;i++) {
			if((flag & 1<<i) != 0) continue;
			arr[cnt] = input[i];
			
			perm(cnt+1, flag | 1<<i);
		}
	}
	
	// 2.1. 조합 - for 사용
	static void comb(int cnt, int idx) {
		if(cnt == arr.length) {
			System.out.println(Arrays.toString(arr));
			ans++;
			return;
		}
		
		// 조합이므로 이전에 input에서 사용한 것은 고려하지 않는다.
		for(int i = idx; i<input.length;i++) {
			arr[cnt] = input[i];
			comb(cnt+1, idx+1);
		}
	}
	
	// 2.2. 조합 - for 사용 (X)
	static void comb2(int cnt, int idx) {
		if(cnt == arr.length) {
			System.out.println(Arrays.toString(arr));
			ans++;
			return;
		}
		
		if(idx == input.length) return;
		
		// 조합이므로 이전에 input에서 사용한 것은 고려하지 않는다.
		arr[cnt] = input[idx];
		comb2(cnt+1, idx+1);	// input 증가, arr 증가		-> 현재 idx를 arr가 받아들이고 다음으로 간다
		comb2(cnt+1, idx);		// input 증가, arr 증가 (x)	-> 현재 idx를 arr가 안 받겠다 . 난 그대로 있을 거니 너는 다음 것을 달라
	}
	
	static void subset(int cnt) {
		if(cnt == input.length) {
			printSubset();
			ans++;
			return;
		}
		
//		O O O O O
//		O O O O X
//		O O O X O
//		O O O X X
//		...
//		X X X O O
//		X X X O X
//		X X X X O
//		X X X X X
		
		// 현재 now를 선택하고 간다.
		visited[cnt] = true;
		subset(cnt+1);
		// 현재 now를 선택하지 않고 간다.
		visited[cnt] = false;
		subset(cnt+1);
	}

	static void printSubset() {
		System.out.print('[');
		for(int i = 0; i<visited.length; i++) {
			if(visited[i])
				System.out.print(input[i] + "");
		}
		System.out.println(']');
	}
}
