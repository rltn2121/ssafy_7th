package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_정사각형방_1861_BFS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Queue<Node> q = new ArrayDeque<>();
	static int[][] arr;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int T,N,room,cnt;
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			room = 0;
			cnt = 1;
			
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// bfs
			// 모든 방에서 1번씩 출발해 본다.
			// 모든 방을 여러 번 방문한다.
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					q.add(new Node(i,j,arr[i][j],1));
					bfs();
				}
			}
			System.out.println("#"+tc+" "+room+" "+cnt);
		}
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			// 방 번호 갱신
			if(node.cnt > cnt) {
				room = node.room;
				cnt = node.cnt;
			} else if(node.cnt == cnt) {
				room = (node.room < room ? node.room : room);
			}
			
			// 탐색
			for(int i = 0; i<4; i++) {
				int nx = node.x+dx[i];
				int ny = node.y+dy[i];
				
				if(nx<0||nx>=N||ny<0||ny>=N||arr[nx][ny] != arr[node.x][node.y]+1) continue;
				
				q.offer(new Node(nx, ny, node.room, node.cnt+1));
			}
		}
	}

	static class Node{
		int x;
		int y;
		int room;
		int cnt;
		public Node(int x, int y, int room, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.room = room;
			this.cnt = cnt;
		}
	}
}
