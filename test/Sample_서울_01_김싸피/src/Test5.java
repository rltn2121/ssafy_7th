import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Test5.txt"));
		Scanner sc = new Scanner(System.in);
		// 구현하세요.
		
		System.out.println(sc.nextInt());
		
		System.out.println(sc.nextInt());
		
		
		
	}

}
