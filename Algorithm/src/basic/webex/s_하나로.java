package basic.webex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s_하나로 {
	static int T, N;
    static long ans;
    static double E;
     
    static boolean[] visited;
    static long[] cost;
    static long[][] matrix;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			matrix = new long[N][N];
			cost = new long[N];
			visited = new boolean[N];
			
			int x[]=new int[N];
			int y[]=new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<N; i++)
				x[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++)
				y[i] = Integer.parseInt(st.nextToken());
			
			E = Double.parseDouble(br.readLine());
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++)
					matrix[i][j] = distance(x[i],x[j],y[i],y[j]);
			}
			
			ans = 0;
			prim();
			System.out.println("#" + tc + " " + Math.round(ans * E));
			
		}
		
	}
	
	static void prim() {
		Arrays.fill(cost, Long.MAX_VALUE);
		cost[0] = 0;
		
		// 1번 ~ N번 정점 모두 탐색
		for(int now = 0; now<N; now++) {
			long minDist = Long.MAX_VALUE;
			int minVertex = 0;
			
			// 현재 정점에서 가장 가까운 다음 정점 찾기
			for(int next = 0; next<N; next++) {
				if(visited[next]) continue;
				if(minDist > cost[next]) {
					minDist = cost[next];
					minVertex = next;
				}
			}
			
			
			// 가장 가까운 다음 정점
			visited[minVertex] = true;
			ans+=minDist;
			
			// 새로 선택된 정점 minVertex로부터 갈 수 있는 정점 고려해서 그 비용으로 minEdge 갱신
			for(int next = 0; next<N; next++) {
				if(visited[next] || matrix[minVertex][next] == 0) continue;
				if(matrix[minVertex][next] < cost[next]) {
					cost[next] = matrix[minVertex][next];
				}
			}
			
		}
	}
	
	
	static long distance(int x1, int x2, int y1, int y2) {
        return (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
