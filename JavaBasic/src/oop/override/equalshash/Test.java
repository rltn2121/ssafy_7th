package oop.override.equalshash;

public class Test {
	public static void main(String[] args) {
		Item item1 = new Item(7, "ssafy");
		Item item2 = new Item(7, "ssafy");
		
		System.out.println(item1 == item2);
		System.out.println(item1.equals(item2));
	}
}
