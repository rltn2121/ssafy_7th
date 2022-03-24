package basic.youtube;

import basic.youtube.datastructure.Stack;

public class StackAPITest2 {
	public static void main(String[] args) {
		Stack s = new Stack();
		System.out.println(s.isEmpty());
		s.push("김대중");
		System.out.println(s);
		s.push("노무현");
		System.out.println(s);
		s.push("이명박");
		System.out.println(s);
		System.out.println(s.pop());
		System.out.println(s);
		System.out.println(s.pop());
		System.out.println(s);
		System.out.println(s.pop());
		System.out.println(s);
		System.out.println(s.pop());
		System.out.println(s);
		
	}
}
