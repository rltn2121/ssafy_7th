package basic.youtube;

import java.util.*;
import java.io.*;
public class IM대비_기지국 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N,T,arr[][], ans;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	static List<Node> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			input();
			ans = 0;
			
			for (Node now : list) {
				for(int d = 0; d<4; d++) {
					int range = now.range;
					int x = now.x;
					int y = now.y;
					
					for(int i = 1; i<=range; i++) {
						x+=dx[d];
						y+=dy[d];
						if(x<0||x>=N||y<0||y>=N) break;
						arr[x][y] = 0;
					}
				}
			}
			
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++)
					ans+=arr[i][j];
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void input() throws Exception {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i = 0; i<N; i++) {
			String input = br.readLine();
			for(int j = 0; j<N; j++) {
				char c = input.charAt(j);
				if(c == 'H')
					arr[i][j] = 1;
				else {
					arr[i][j] = 0;
					if(c == 'A')
						list.add(new Node(1,i,j));
					else if(c=='B')
						list.add(new Node(2,i,j));
					else if(c=='C')
						list.add(new Node(3,i,j));
				}
			}
		}
	}
	static class Node{
		int range;
		int x;
		int y;
		public Node(int range, int x, int y) {
			super();
			this.range = range;
			this.x = x;
			this.y = y;
		}
	}
}
