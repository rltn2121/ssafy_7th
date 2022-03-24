package oop.override.equalshash;

public class Item {
	int itemId;
	String itemNm;
	
	Item(){
		
	}
	
	Item(int itemId, String itemNm){
		this.itemId = itemId;
		this.itemNm = itemNm;
	}
	
	@Override
	public boolean equals(Object obj) {
//		1. 파라미터 객체 null 체크
//		2. 파라미터 객체를 비교 대상 객체로 casting 할 수 있는지 체크
		if(obj == null || !(obj instanceof Item)) return false;
				
		Item item = (Item) obj;
		
		if(this.itemId == item.itemId && this.itemNm.equals(item.itemNm))
			return true;
		return false;
		
	}
	
//	해시 알고리즘을 사용하여 중복 판단
//	헤시코드는 해시테이블에 넣을때 해시값 구하는데 쓰임
	@Override	
	public int hashCode() {
		return java.util.Objects.hash(this.itemId, this,itemNm);
	}
}
