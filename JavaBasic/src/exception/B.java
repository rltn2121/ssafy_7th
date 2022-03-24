package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class B {
	public void m2() throws FileNotFoundException{
		FileInputStream fis = new FileInputStream("hello.txt");
	}
}
