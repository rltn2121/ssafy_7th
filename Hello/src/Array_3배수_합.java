import java.util.Scanner;

public class Array_3배수_합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = 5;
		int[][] grid = new int[N][N];
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		
				
		// count, sum
		int count = 0;
		int sum = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				// 3의 배수 찾기
				if(grid[i][j] % 3 == 0) {		
					count++;
					sum += grid[i][j];
				}
			}
		}
		
		System.out.println(count);
		System.out.println(sum);
	}
}

/*
2 3 1 4 7
8 13 3 33 1
7 4 5 80 12
17 9 11 5 4
4 5 91 27 7
*/