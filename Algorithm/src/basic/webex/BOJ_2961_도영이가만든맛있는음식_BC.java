package basic.webex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식_BC {
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

		// 모든 부분집합 수 (1 << 5 -> 100000 = 2^5)
		int size = 1 << input.length;
		
		
		// 공집합 제외 -> i = 1부터
		for(int i = 1; i<size; i++) {
			// 한 개의 부분집합을 의미
			
			int a = 1;
			int b = 0;
			for(int j = 0; j<input.length; j++) {
				if((i & (1<<j)) != 0) {
					a*=input[j][0];
					b+=input[j][1];
				}
			}
			min = Math.min(min, Math.abs(a-b));
		}
		
		
		
		
		
		System.out.println(min);
	}

}
