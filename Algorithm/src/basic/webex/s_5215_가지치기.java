package basic.webex;

import java.io.*;
import java.util.*;

public class s_5215_가지치기 {
	static int T,N,L,ans;
	static Item[] arr;
	static boolean selected[] = new boolean[5];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			input();
			dfs(0,0,0);
			System.out.println("#" + tc + " " + ans);
		}
		br.close();
	}
	
	static void dfs(int idx, int point, int cal) {
		// 가지치기 -> 불가능한 경우
		if(cal > L) return;

		// 끝까지 도착 -> 최댓값 갱신
		if(idx == N) {
			ans = Math.max(ans, point);
			return;
		}
			
		dfs(idx+1, point+arr[idx].t, cal+arr[idx].k);	// 현재 선택을 받아들인다.
		dfs(idx+1, point, cal);							// 현재 선택을 받아들이지 않는다.
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
