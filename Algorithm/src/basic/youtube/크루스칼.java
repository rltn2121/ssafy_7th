package basic.youtube;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 크루스칼 {
	static int N;
	static int[] parent;
	static Edge[] edgeList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];
		
		for(int i = 0 ;i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		Arrays.sort(edgeList, (a,b) -> a.weight - b.weight);
		
		makeSet();
		
		int sum = 0, cnt = 0;
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				cnt++;				// 사용한 간선 수
				sum+=edge.weight;
				if(cnt == N-1)		// 간선을 N-1개 사용했으면
					break;
			}
		}
		System.out.println(sum);
	}
	
	static void makeSet() {
		parent = new int[N];
		for(int i = 0; i<N; i++)
			parent[i] = i;
	}
	
	static int find(int x) {
		if(x==parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa == pb) return false;
		
		if(pa>pb)
			parent[pa] = pb;
		else
			parent[pb] = pa;
		return true;
	}
	
	static class Edge{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
	}
}
