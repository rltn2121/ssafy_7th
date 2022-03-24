package basic.webex;

import java.io.*;
import java.util.*;

public class s_5215_부분집합 {
	static int T,N,L,ans;
	static Item[] arr;
	static boolean[] visited;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			input();
			subset(0);
			System.out.println("#" + tc + " " + ans);
		}
		br.close();
	}
	
	static void subset(int idx) {
		if(idx == N) {
			int cal = 0, point = 0;
			for(int i = 0; i<idx; i++) {
				if(!visited[i]) continue;
				cal += arr[i].k;
				point += arr[i].t;
			}
			
			if(cal > L) return;
			ans = Math.max(ans, point);
			return;
		}
		

		if(idx == N) return;
		
		visited[idx] = true;
		subset(idx+1);			// 현재 선택을 받아들인다.
		visited[idx] = false;
		subset(idx+1);			// 현재 선택을 받아들이지 않는다.
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
		visited = new boolean[N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
	}
}
