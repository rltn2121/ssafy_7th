package basic.youtube;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 다익스트라2_PQ {
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
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.add(new Vertex(start, distance[start]));
		
		Arrays.fill(distance, Integer.MAX_VALUE);	// 처음엔 모두 갈 수 없음
		distance[start] = 0;						// 시작점 0

		while(!pq.isEmpty()) {
			// 1단계: 최소 비용이 확정되지 않은 정점 중 최소 비용의 정점 선택
			Vertex current = pq.poll();
			
			if(visited[current.no]) continue;
			visited[current.no] = true;
			
			// 2단계: 선택된 정점을 경유지로 하여 아직 최소 비용이 확정되지 않은 다른 정점의 최소 비용 고려
			for(int j = 0; j<V; j++) {
				if(visited[j] || adjMatrix[current.no][j] == 0) continue;
				if(distance[current.no] + adjMatrix[current.no][j] < distance[j]) {
					distance[j] = distance[current.no] + adjMatrix[current.no][j];
					pq.offer(new Vertex(j, distance[j]));
				}
		 	}
		}
		System.out.println(Arrays.toString(distance));
		
		
	}
	
	static class Vertex implements Comparable<Vertex>{
		int no, minDistance;

		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return minDistance - o.minDistance;
		}
		
	}
}
