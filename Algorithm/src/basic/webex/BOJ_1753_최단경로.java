package basic.webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	static int V,E,K;
	static ArrayList<ArrayList<Edge>> vertex = new ArrayList<ArrayList<Edge>>();
	static boolean[] visited;
	static int[] cost;
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>((a,b) -> a.c - b.c);
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		visited = new boolean[V+1];
		cost = new int[V+1];	// 프림에는 없음
		
		for(int i = 0; i<=V; i++) {
			 vertex.add(new ArrayList<Edge>());
			 cost[i] = INF;
		}
		
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			// 유향
			vertex.get(v1).add(new Edge(v2, w));
		}
		
		dijkstra();
		
		for(int i = 1; i<=V; i++) {
			System.out.println( cost[i] == INF ? "INF" : cost[i]);
		}
	}
	
	static void dijkstra() {
		// 시작 K
		cost[K] = 0;
		pq.add(new Edge(K, 0));
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();	// 꺼낸 것 e
			
			if(visited[e.v]) continue;
			visited[e.v] = true;
			
			// ne의 비용 체크
			for(Edge ne : vertex.get(e.v)) {
				if(!visited[ne.v] && ne.c + cost[e.v] < cost[ne.v]) {
					cost[ne.v] = ne.c + cost[e.v];
					pq.add(new Edge(ne.v, cost[ne.v]));
				}
			}
		}
	}
	static class Edge{
		int v;
		int c;
		public Edge(int v, int c) {
			super();
			this.v = v;
			this.c = c;
		}
		
	}
}

