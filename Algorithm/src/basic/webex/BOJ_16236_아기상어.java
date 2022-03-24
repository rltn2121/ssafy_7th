package basic.webex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
	static int N, sx, sy, level, sEatCnt, ans;
	static int[][] map;
	static boolean[][] visited;
	
	static Queue<Node> q = new ArrayDeque<>();
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	
	public static void main(String[] args) throws Exception {
		input();
		
		while(true) {
			int cnt = bfs();
			if(cnt == 0)
				break;
			ans+=cnt;
		}
		System.out.println(ans);
	}
	
	static int bfs() {
		// 먹이 후보
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		int minDist = Integer.MAX_VALUE;
		
		// visit 초기화
		visited = new boolean[N][N];
		
		visited[sx][sy] = true;
		q.add(new Node(sx, sy, 0));
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			// 물고기 후보 찾으면
			if(map[now.x][now.y] > 0 && map[now.x][now.y] < level) {
				if(now.d < minDist) {
					minX = now.x;
					minY = now.y;
					minDist = now.d;
				} else if(now.d == minDist) {
					if(now.x < minX) {
						minX = now.x;
						minY = now.y;
						minDist = now.d;
					} else if(now.x == minX) {
						if(now.y < minY) {
							minX = now.x;
							minY = now.y;
							minDist = now.d;
						}
					}
				}
			}
			
			// 다음 칸 탐색	
			for(int i = 0; i<4; i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				if(nx<0||nx>=N||ny<0||ny>=N||visited[nx][ny] || map[nx][ny] > level) continue;
				visited[nx][ny] = true;
				q.add(new Node(nx, ny, now.d + 1));
			}
		}
		
		if(minDist == Integer.MAX_VALUE) return 0;
		if(++sEatCnt == level) {
			level++;
			sEatCnt = 0;
		}
		
		map[minX][minY] = 0;
		map[sx][sy] = 0;
		
		sx = minX;
		sy = minY;
		return minDist;
	}
	
	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n==9) {
					sx = i;
					sy = j;
				}
				map[i][j] = n;
			}
		}
	}
	
	static class Node{
		int x,y,d;

		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
