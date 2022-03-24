package basic.youtube;

import java.util.Scanner;

public class 백트래킹_NQUEEN {
	static int N, ans;
	static int col[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
	}
	
	static void setQueen(int rowNo) {	// 현재 퀸을 두어야 하는 행
		// 직전까지의 상황이 유망하지 않다면 리턴
		if(!isAvailable(rowNo-1))
			return;
		
		// 퀸을 모두 놓았다면
		if(rowNo > N) {
			ans++;
			return;
		}
		
		// 1열 ~ n열까지 퀸을 놓는 시도
		for(int i = 1; i<N; i++) {
			col[rowNo] = i;
			setQueen(rowNo+1);
		}
	}
	
	static boolean isAvailable(int rowNo) {	// 놓아진 마지막 퀸
		for(int i = 1; i<rowNo; i++) {
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
