
public class ArrayTest {

	public static void main(String[] args) {
		// 1차원 배열
/*
		int[] intArray = new int[5];
		int[] intArray2 = {1,2,3,4,5};
		
		intArray[4] = 100;
		System.out.println(intArray[4]);
		System.out.println(intArray2[4]);
		
		for(int i = 0; i<intArray.length; i++) {
			System.out.println(intArray2[i]); 
		}
		
		
		Robot3[] robotArray = new Robot3[3];
		for(int i = 0; i<robotArray.length; i++) {
			robotArray[i] = new Robot3();
			robotArray[i].setName(i + "로봇");
			robotArray[i].setLevel(i*2);
			
			System.out.println(robotArray[i]);
			System.out.println(robotArray[i].getName());
		}
*/
		
		// 2차원 배열
		int[][] intArray2 = new int[3][4];
		intArray2[2][2] = 5;
		
		int[][] intArray3 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
		for(int i = 0;i<4; i++) {
			for(int j = 0;j<2;j++) {
				System.out.println(intArray3[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
