package oop.usesuper;

public class Child extends Parent{
	int i = 10;
	
	Child(){
		super(5);
		System.out.println("Child()");
	}
	
	Child(int i){
		this.i = i;
		System.out.println("Child(int i)");
	}
	
	void m() {
		System.out.println(this.i);
		System.out.println(super.i);
		super.m();
	}
	
	void m2() {
		System.out.println("Child - m2()");
	}

}
