package basic.youtube;

public class 유니온파인드 {
	static int N;
	static int[] parent;
	public static void main(String[] args) {
		
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
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa == pb) return;
		
		if(pa>pb)
			parent[pa] = pb;
		else
			parent[pb] = pa;
	}
}
