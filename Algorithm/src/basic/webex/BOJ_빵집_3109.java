package basic.webex;

import java.io.*;
import java.util.*;

public class BOJ_빵집_3109 {
	static int R,C,ans;
	static char[][] arr;
	static int dx[] = {-1,0,1};
	
	public static void main(String[] args) throws Exception{
		input();
		for(int i = 0; i<R; i++) {
			if(dfs(i,0))
				ans++;
		}
		System.out.println(ans);
	}
	static boolean dfs2(int row, int col) {
		// 제일 오른쪽 끝에 도착 했으면
		if(col==C-1)
			return true;
		
		// 맵 벗어나거나 건물이면
		if(row<0||row>=R || arr[row][col]=='x')
			return false;
		
		
		// 따로 visited 만들지 않고 벽으로 만들면 갈 수 없음
		arr[nx][ny] = 'x';

		
		int ny = col+1;	// 옆으로 이동
		for(int a = 0; a<3; a++) {
			int nx = row+dx[a];
			
			
			if(dfs(nx,ny)) 
				return true;
		}
		
		return false;
	}
	static boolean dfs(int i, int j) {
		int ny = j+1;	// 옆으로 이동
		for(int a = 0; a<3; a++) {
			int nx = i+dx[a];
			
			// 제일 오른쪽 끝에 도착 했으면
			if(ny==C-1)
				return true;
			
			// 맵 벗어나거나 건물이면
			if(nx<0||nx>=R || arr[nx][ny]=='x')
				continue;
			
			// 따로 visited 만들지 않고 벽으로 만들면 갈 수 없음
			arr[nx][ny] = 'x';
			if(dfs(nx,ny)) 
				return true;
		}
		
		return false;
	}
	static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][];
		
		for(int i = 0; i<R; i++)
			arr[i] = br.readLine().toCharArray();
	}
}
