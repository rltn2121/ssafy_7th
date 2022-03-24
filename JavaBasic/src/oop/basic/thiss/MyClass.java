package oop.basic.thiss;

public class MyClass {
	int n;
	String str;
	
	
	MyClass(int n){
		this.n = n;
	}
	
	MyClass(int n, String str){
		this(n);	// this.n = n; 이 문장과 동일함
		this.str = str;
	}
	
	void m() {
		System.out.println(this.n);
	}
}
