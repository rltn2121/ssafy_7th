package basic.webex;

import java.io.*;
import java.util.*;

public class SWEA_6544_무선충전 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int T,MOVING_TIME,CHARGER_CNT,ans;
	static int[] dx = {0,-1,0,1,0};
	static int[] dy = {0,0,1,0,-1};
	static int[] pathA, pathB;
	static int ax, ay, bx, by;
	
	static Charger[] chargers;
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			input();
			
			ans = 0;
			ax = 0;
			ay = 0;
			bx = 9;
			by = 9;
			
			for(int time = 0; time<=MOVING_TIME; time++) {
				charge();
				ax+=dx[pathA[time]];
				ay+=dy[pathA[time]];
				bx+=dx[pathB[time]];
				by+=dy[pathB[time]];
			}
		}
	}
	
	static void charge() {
		int max = 0;
		for(int i = 0; i<CHARGER_CNT; i++) {
			for(int j = 0; j<CHARGER_CNT; j++) {
				int sum = 0;
				int a_get = getPower(chargers[i], ax, ay);
				int b_get = getPower(chargers[j], bx, by);
				
				// 충전소가 다름
				if(i != j) 
					sum = a_get + b_get;
				// 충전소가 같으면 어차피 반 씩 나눠갖기 때문에, 더한 결과는 안 나눠도 됨
				else
					sum = Math.max(a_get, b_get);
			
				max = Math.max(max, sum);
			}
		}
		ans += max;
	}
	
	static int getPower(Charger charger, int x, int y) {
		if(Math.abs(charger.x-x) + Math.abs(charger.y-y) <= charger.range) 
			return charger.power;
		return 0;
	}
	
	static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		MOVING_TIME = Integer.parseInt(st.nextToken());
		CHARGER_CNT = Integer.parseInt(st.nextToken());
		
		// -> 0번째 정보는 안넣나?
		pathA = new int[MOVING_TIME+1];
		pathB = new int[MOVING_TIME+1];
		
		// A 이동 경로
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=MOVING_TIME; i++) 
			pathA[i] = Integer.parseInt(st.nextToken());
		
		// B 이동 경로
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=MOVING_TIME; i++) 
			pathB[i] = Integer.parseInt(st.nextToken());
		
		// 충전기
		chargers = new Charger[CHARGER_CNT];
		for(int i = 0; i<CHARGER_CNT; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int range = Integer.parseInt(st.nextToken());
			int power = Integer.parseInt(st.nextToken());
			chargers[i] = new Charger(x,y,range,power);
		}
		
	}
	
	
	static class Charger{
		int x;
		int y;
		int range;
		int power;
		public Charger(int x, int y, int range, int power) {
			super();
			this.x = x;
			this.y = y;
			this.range = range;
			this.power = power;
		}
	}
}

