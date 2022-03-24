package java8.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayTest {
	public static void main(String[] args) {
		Item[] itemArray = {
				new Item(1, "item1"),
				new Item(2, "item2"),
				new Item(3, "item3")
		};
		
		Arrays.sort(itemArray);
		
		Arrays.sort(itemArray, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		
		Arrays.sort(itemArray, (i1, i2) -> i1.itemId - i2.itemId);
	}
	
	static class Item implements Comparable<Item>{
		int itemId;
		String itemNm;
		
		Item(int itemId, String itemNm){
			this.itemId= itemId;
			this.itemNm = itemNm;
		}

		@Override
		public String toString() {
			return "Item [itemId=" + itemId + ", itemNm=" + itemNm + "]";
		}

		@Override
		public int compareTo(Item o) {
			// TODO Auto-generated method stub
			return this.itemNm.compareTo(o.itemNm);
		}
		
	}
}
