package oop.basic.classobject;

public class MyClass {
	// member variable
	int n;
	String str;
	
	// method
	void m1() {
		System.out.println("m1()");
	}
	
	// method - setter & getter
	int getN() {
		return this.n;
	}
	
	void setN(int n) {
		this.n = n;
	}
}

class AnotherClass{
	int n;
}

// has a 관계: 클래스를 멤버 변수로 가짐
class MoreClass{
	AnotherClass ac;
	MyClass mc;
}
	
// is a 관계: 클래스를 상속함
class MoreClass2 extends AnotherClass{
	MyClass mc;
}