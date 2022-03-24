package basic.youtube;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분집합_합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, input[], S, ans, callCnt;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st= new StringTokenizer(br.readLine()," ");
		input = new int[N];
		visited = new boolean[N];
		for(int i = 0; i<N; i++) 
			input[i] = Integer.parseInt(st.nextToken());
		generateSubset(0, 0);
		System.out.println(ans);
		System.out.println(callCnt);
	}
	
	public static void generateSubset(int cnt, int sum) {
		callCnt++;
		// 이미 초과했으면
		if(sum > S) return;
		
		// 답 찾았으면
		if(sum==S) {
			ans++;
			for(int i = 0; i<N; i++)
				System.out.print(visited[i] ? input[i] + " ":"");
			System.out.println();
			return;
		}
		
		// 끝까지 다 했으면
		if(cnt == N)
			return;
		
		visited[cnt] = true;	// 현재 원소를 선택
		generateSubset(cnt+1, sum+input[cnt]);
		visited[cnt] = false;	// 현재 원소를 미선택
		generateSubset(cnt+1, sum);
	}
}
