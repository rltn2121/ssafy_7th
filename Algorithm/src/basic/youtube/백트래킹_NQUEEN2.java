package basic.youtube;

import java.util.Scanner;

public class 백트래킹_NQUEEN2 {
	static int N, ans;
	static int col[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N];
		setQueen(0);
		System.out.println(ans);
	}
	
	static void setQueen(int rowNo) {	// 현재 퀸을 두어야 하는 행
		// 퀸을 모두 놓았다면
		if(rowNo == N) {
			ans++;
			return;
		}
		
		// 1열 ~ n열까지 퀸을 놓는 시도
		for(int i = 0; i<N; i++) {
			col[rowNo] = i;
			
			// 현재 경우가 불가능하면 패스
			if(!isAvailable(rowNo)) continue;
			setQueen(rowNo+1);
		}
	}
	
	static boolean isAvailable(int rowNo) {	// 놓아진 마지막 퀸
		for(int i = 0; i<rowNo; i++) {
			// 같은 열에 있으면
			if(col[rowNo] == col[i])
				return false;
			
			// 대각선에 있으면
			if(rowNo-i == Math.abs(col[rowNo]-col[i]))
				return false;
		}
		
		return true;
	}
}
