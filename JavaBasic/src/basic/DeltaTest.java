package basic;

public class DeltaTest {

	static int[][] number;
	public static void main(String[] args) {
		number = new int [10][10];
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				number[i][j] = i*10 + j;
			}
		}
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("%3d", number[i][j]);
			}
			System.out.println();
		}
		
		print2W_delta(1, 1);
	}
	
	static void print2W(int i, int j) {
		System.out.print(number[i][j] + " 옆에는 ");
		
		// 좌
		int ny = i;
		int nx = j - 1;
		
		if(nx >= 0)
			System.out.print(number[ny][nx] + " ");
		
		// 우
//		int ny = i;
		nx = j - 1;
		
		if(nx < 10)
			System.out.print(number[ny][nx] + " ");
		
		System.out.println();
	}
	
	static int dy[] = {0, 0, -1, 1};
	static int dx[] = {-1, 1, 0, 0};
	
	static void print2W_delta(int i, int j) {
		System.out.print(number[i][j] + " 옆에는 ");
		for(int d = 0; d<2; d++) {
			int ny = i + dy[d];
			int nx = j + dx[d];
			if(ny < 0 || ny >= 10 || nx < 0 || nx >= 10) continue;
			System.out.print(number[ny][nx] + " ");
		}
		System.out.println();
	}
	
	static void print4W_delta(int i, int j) {
		System.out.print(number[i][j] + " 4방에는 ");
		for(int d = 0; d<4; d++) {
			int ny = i + dy[d];
			int nx = j + dx[d];
			if(ny < 0 || ny >= 10 || nx < 0 || nx >= 10) continue;
			System.out.print(number[ny][nx] + " ");
		}
		System.out.println();
	}
}
