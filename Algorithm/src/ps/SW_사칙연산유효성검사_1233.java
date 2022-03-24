package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_사칙연산유효성검사_1233 {
	static int N, ans;
	static char[] node;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			node = new char[N+1];
			
			for(int i = 1; i<=N; i++)
				node[i] = br.readLine().split(" ")[1].charAt(0);
			
			System.out.println("#"+ t + " " + (dfs(1) ? 1 : 0)); 

		}
	}
	static boolean dfs(int x) {
		if(x>N)
			return false;
		
		if(Character.isDigit(node[x])) {
			if(x*2 > N)
				return true;
			return false;
		} else
			return dfs(x*2) && dfs(x*2+1);
	}
}
