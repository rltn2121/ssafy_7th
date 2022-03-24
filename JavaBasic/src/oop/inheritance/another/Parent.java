package oop.inheritance.another;

import oop.inheritance.GrandParent;

public class Parent extends GrandParent{
	public int age = 40;
//	String name = "Parent"; 부모 클래스의 값이 마음에 안든다고 해서 변수를 재정의하는 것은 좋지 않음.
	
	
	
//	The constructor Parent(String) is not visible
	
//	Implicit super constructor GrandParent() is not visible. 
//	Must explicitly invoke another constructor
	protected Parent(){
		
	}
	
	public Parent(String name)	{
//		super.name = name;
		super(name);
	}
	
	protected Parent(String name, int age){
		super(name);
		this.age = age;
	}
}
