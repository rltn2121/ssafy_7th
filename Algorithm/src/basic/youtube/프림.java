package basic.youtube;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 프림 {
	/*
5
0 5 10 8 7
5 0 5 3 6
10 5 0 1 3
8 3 1 0 1
7 6 3 1 0

	*/
	static int N;
	static int[][] adjMatrix;
	static int[] minEdge;	// 다른 정점에서 자신으로의 간선 비용 중 최소 비용
	static boolean[] visited;	// 방문 여부
	public static void main(String[] args) throws Exception{
		input();
		int sum = 0;
		minEdge[0] = 0;
		
		for(int now = 0; now<N; now++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			
			for(int next = 0; next<N; next++) {
				if(!visited[next] && min > minEdge[now]) {
					min = minEdge[now];
					minVertex = now;
				}
			}
			
			// 선택된 정점을 신장트리에 포함시킴
			visited[minVertex] = true;
			sum+=min;
			
			// 선택된 정점 기준으로 신장트리에 포함되지 않은 다른 정점으로의 간선 비용을 따져보고 최소값 갱신
			for(int i = 0; i<N; i++) {
				if(visited[i] || adjMatrix[minVertex][i] == 0) continue;
				if(minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		System.out.println(sum);
	}
	
	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N= Integer.parseInt(br.readLine());
		adjMatrix = new int[N][N];
		minEdge = new int[N];			// 다른 정점에서 자신으로의 간선 비용 중 최소 비용
		visited = new boolean[N];	// 방문 여부
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<adjMatrix.length; j++) 
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			
			minEdge[i] = Integer.MAX_VALUE;
		}
	}
}
