import java.io.FileInputStream;
import java.util.Scanner;

public class Array_X좌우_합 {
	public static void main(String[] args) throws Exception{
		int N = 4;
		int sum = 0;
		char[][] grid = new char[N][N];
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		// 입력
		for (int i = 0; i < grid.length; i++) 
			for (int j = 0; j < grid.length; j++) 
				grid[i][j] = sc.next().charAt(0);

		// 계산
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if(isX(grid, i, j)) {
					// 왼쪽 범위 체크
					if(isValidRange(j-1, grid.length) && !isX(grid, i, j-1)) 
						sum+= (grid[i][j-1] - '0');
					
					// 오른쪽 범위 체크
					if(isValidRange(j+1, grid.length) && !isX(grid, i, j+1)) 
						sum+= (grid[i][j+1] - '0');
				}
			}
		}
		
		// 출력
		System.out.println(sum);
	}
	
	private static boolean isX(char[][] arr, int i, int j) {
		return arr[i][j] == 'X';
	}
	
	private static boolean isValidRange(int j, int n) {
		return (j >= 0 && j < n);
	}
	
}

/*
2 3 1 4 
1 X 3 X
3 4 X X
X 4 1 5
*/