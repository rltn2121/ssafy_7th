package basic.webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040_백설공주와일곱난장이 {
	static int S = 9, T = 7;
	static int[] input = new int[S];
	static int[] arr = new int[T];
	static boolean done = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i<S; i++)
			input[i] = Integer.parseInt(br.readLine());
		
		comb(0,0);
	}
	
	static void comb(int cnt, int idx) {
		if(done) return;
		if(cnt == T) {
			int sum = 0;
			for(int i = 0; i<T; i++)
				sum+=arr[i];
			
			if(sum==100) {
				for(int i = 0; i<T; i++)
					System.out.println(arr[i]);
				done = true;
			}
			return;
		}
		
		for(int i = idx; i<S; i++) {
			arr[cnt] = input[i];
			comb(cnt+1, idx+1);
		}
	}
}
