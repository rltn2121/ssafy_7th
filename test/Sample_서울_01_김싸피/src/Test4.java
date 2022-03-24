import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new File("Test4.txt"));
		int testCase=sc.nextInt();
		for( int i=0; i<testCase ; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			System.out.printf("%3d , %3d   평균: %.2f   \n", x, y, (x+y)/2.);		
		}
	}
}