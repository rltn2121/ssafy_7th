package oop.basic.overload;
public class Test {
	public static void main(String[] args) {
		MyClass mc = new MyClass();
		mc.method();
		mc.method(5);
		mc.method(10, "Hello");
	}
}
