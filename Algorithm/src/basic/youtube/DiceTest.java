package basic.youtube;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiceTest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,M,totalCnt, numbers[];
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		visited = new boolean[7];
		M = Integer.parseInt(br.readLine());
		switch(M) {
		case 1:
			dice1(0);
			break;
		case 2:
			dice2(0);
			break;
		case 3:
			dice3(1,0);
			break;
		case 4:
			dice4(1,0);
			break;
		default:
			break;
		}
		System.out.println("총 개수: " + totalCnt);
	}
	
//	1. 중복 순열
//	1 1 1
//	1 1 2
//	...
//	1 2 1
//	...
//	6 6 5
//	6 6 6
	public static void dice1(int cnt) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = 1; i<=6; i++) {
			numbers[cnt] = i;
			dice1(cnt+1);
		}
	}
//	2. 순열 (123, 132, 321 -> 서로 다른 경우)
//	1 2 3
//	1 2 4
//	...
//	1 3 2
//	...
//	3 2 1
//	...
//	6 5 3
//	6 5 4
	public static void dice2(int cnt) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = 1; i<=6; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			numbers[cnt] = i;
			dice2(cnt+1);
			visited[i] = false;
		}
	}
	
//	3. 중복 조합 (112, 121, 211 -> 중복되는 경우)
//	1 1 1
//	1 1 2
//	...
//	1 1 6
//	1 2 2
//	...
//	5 6 6
//	6 6 6
	public static void dice3(int idx, int cnt) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = idx; i<=6; i++) {
			numbers[cnt] = i;
			dice3(i, cnt+1);	// 다음 주사위는 선택한 현재 수부터 시도하도록 한다.
		}
	}
//	4. 조합 (123, 132, 321 -> 중복되는 경우)
//	1 2 3
//	1 2 4
//	1 2 5
//	1 2 6
//	1 3 4
//	1 3 5
//	...
//	4 5 6
	public static void dice4(int idx, int cnt) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = idx; i<=6; i++) {
			numbers[cnt] = i;
			dice4(i+1, cnt+1);
		}
	}
}

