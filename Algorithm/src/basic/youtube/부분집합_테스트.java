package basic.youtube;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분집합_테스트 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, input[];
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine()," ");
		input = new int[N];
		visited = new boolean[N];
		for(int i = 0; i<N; i++) 
			input[i] = Integer.parseInt(st.nextToken());
		generateSubset(0);
	}
	
	public static void generateSubset(int cnt) {
		if(cnt==N) {
			for(int i = 0; i<N; i++)
				System.out.print((visited[i] ? input[i]:"X") + " ");
			System.out.println();

			return;
		}
		visited[cnt] = true;	// 현재 원소를 선택
		generateSubset(cnt+1);
		visited[cnt] = false;	// 현재 원소를 미선택
		generateSubset(cnt+1);
	}
}
