package basic.youtube;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 다익스트라1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		int V = Integer.parseInt(br.readLine());
		
		int[][] adjMatrix = new int[V][V];
		int start = 0;
		
		StringTokenizer st = null;
		
		for(int i = 0; i<V; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<adjMatrix.length; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		
		Arrays.fill(distance, Integer.MAX_VALUE);	// 처음엔 모두 갈 수 없음
		distance[start] = 0;						// 시작점 0
		
		for(int i = 0; i<V; i++) {
			// 1단계: 최소 비용이 확정되지 않은 정점 중 최소 비용의 정점 선택
			int min = Integer.MAX_VALUE;
			int current = 0;
			for(int j = 0; j<V; j++) {
				if(visited[j]) continue;
				if(min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
//			if(current == end) break;	// 원하는 도착지를 만나면 종료
			
			// 2단계: 선택된 정점을 경유지로 하여 아직 최소 비용이 확정되지 않은 다른 정점의 최소 비용 고려
			for(int j = 0; j<V; j++) {
				if(visited[j] || adjMatrix[current][j] == 0) continue;
				if(distance[current] + adjMatrix[current][j] < distance[j])
					distance[j] = distance[current] + adjMatrix[current][j];
		 	}
		}
		System.out.println(Arrays.toString(distance));
		
		
	}
}
