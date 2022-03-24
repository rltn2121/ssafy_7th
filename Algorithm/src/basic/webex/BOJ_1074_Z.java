package basic.webex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
	static int N,r,c,ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		N = (int)Math.pow(2, N);
		
		int x = 0;
		int y = 0;
		
		while(N>1) {
			N/=2;
			
			if(r<x+N && c<y+N) {			// 2사분면
					
			} else if(r<x+N && c>=y+N) {	// 1사분면
				ans += N*N*1;
				y+=N;
			} else if(r>=x+N && c<y+N) {	// 3사분면
				ans += N*N*2;
				x+=N;
			} else if(r>=x+N && c>=y+N) {	// 4사분면
				ans += N*N*3;
				x+=N;
				y+=N;
			}
		}
		System.out.println(ans);
	}
}
