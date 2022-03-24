package basic.webex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식_조합 {
	static int N, min = Integer.MAX_VALUE;
	static int[][] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		input = new int[N][2];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		
		comb(0,1,0);
		System.out.println(min);
	}
	static void comb(int idx, int a, int b) {
		if(idx == N) {
			return;
		}			
		int now_a = a*input[idx][0];
		int now_b = b+input[idx][1];
		min = Math.min(min, Math.abs(now_a-now_b));
		
		comb(idx+1, now_a, now_b);
		comb(idx+1, a, b);
	}
}
