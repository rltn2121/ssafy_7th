package java5.etc;

public class Test {
	public static void main(String[] args) {
		int[] intArray = {1,2,3,4,5};
		
		for (int i : intArray) {
			
			
		}
		
		// auto boxing
		Integer i = 10;
		
		// unboxing
		int j = i;
		
		mAuto('A');
		uAuto(new Character('B'));
	}
	
	static void mAuto(Character c) {
		System.out.println(c);
	}
	
	static void uAuto(char c) {
		System.out.println(c);
	}
}
