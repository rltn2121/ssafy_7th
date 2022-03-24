package oop.inheritance;

import oop.inheritance.another.Parent;

public class Test {
	public static void main(String[] args) {
		GrandParent gp = new GrandParent();
		System.out.println(gp.name);
		
		
//		Test class는 Parent와 패키지도 다르고, 상속도 받지 않으므로 protected일 경우에는 생성자 호출 불가
		Parent p = new Parent("ssafy");
		System.out.println(p.name);
		System.out.println(p.age);
		
		Child c = new Child("ssafy2", 20);
		System.out.println(c.name);
		System.out.println(c.age);
		
	}
	
}
