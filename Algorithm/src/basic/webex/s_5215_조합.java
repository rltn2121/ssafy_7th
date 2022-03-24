package basic.webex;

import java.io.*;
import java.util.*;

public class s_5215_조합 {
	static int T,N,L,ans;
	static Item[] arr, target;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			input();
			for(int i = 1; i<=N; i++) {					
				target = new Item[i];		// target[]: 길이가 1 ~ N 개의 배열을 각각 생성 (1개만 뽑을 경우 / 2개 뽑을 경우 / ... / N-1개 뽑을 경우 / N개 뽑을 경우)
				comb(0,0);
			}
			System.out.println("#" + tc + " " + ans);
		}
		br.close();
	}
	
	static void comb(int idx, int cnt) {
		if(idx == target.length	) {
			int cal = 0, point = 0;
			
			for(int i = 0; i<idx; i++)
				cal += target[i].k;
			
			if(cal <= L) {
				for(int i = 0; i<idx; i++) 
					point += target[i].t;
				ans = Math.max(ans, point);
			}
			return;
		}
		
		if(idx == N) return;
		
		target[cnt] = arr[idx];
		comb(idx+1, cnt+1);			// 현재 선택을 받아들인다.
		comb(idx+1, cnt);			// 현재 선택을 받아들이지 않는다.
	}
	
	
	static class Item{
		int t;
		int k;
		public Item(int t, int k) {
			this.t = t;
			this.k = k;
		}
	}
	
	static void input() throws Exception {
		ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new Item[N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
	}
}
