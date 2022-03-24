package basic.youtube;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 인접행렬 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int C = sc.nextInt();
		
		int[][] adjMatrix = new int[N][N];
		
		for(int i = 0; i<C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		
		for(int[] arr : adjMatrix)
			System.out.println(Arrays.toString(arr));
		
		bfs(adjMatrix,0);
		dfs(adjMatrix, new boolean[N], 0);
	}
	
	public static void bfs(int[][] adjMatrix, int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			System.out.println((char)(current+65));
			
			for(int j = 0; j<N; j++) {
				if(!visited[j] && adjMatrix[current][j] != 0) {
					q.offer(j);
					visited[j] = true;
				}
			}
		}
	}
	
	public static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
		visited[current] = true;
		System.out.println(current);
		
		for(int j = 0; j<N; j++) {
			if(!visited[j] && adjMatrix[current][j] != 0)
				dfs(adjMatrix, visited, j);
		}
	}
}
