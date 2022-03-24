package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_정사각형방_1861_DFS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] arr;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int T,N,ROOM, CNT;
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			ROOM = 0;
			CNT = 1;
			
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
					dfs(i,j,arr[i][j],1);
				}
			}
			System.out.println("#"+tc+" "+ROOM+" "+CNT);
		}
	}
	
	private static void dfs(int x, int y, int room, int cnt) {
		// 방 번호 갱신
		if(cnt > CNT) {
			ROOM = room;
			CNT = cnt;
		} else if(cnt == CNT) {
			ROOM = (room < ROOM ? room : ROOM);
		}
		
		// 탐색
		for(int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0||nx>=N||ny<0||ny>=N||arr[nx][ny] != arr[x][y]+1) continue;
			dfs(nx,ny,room,cnt+1);
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
