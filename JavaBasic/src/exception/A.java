package exception;

import java.io.FileNotFoundException;

public class A {
	public void m() throws FileNotFoundException {
		B b = new B();
		b.m2();
	}
}
