package pairhouse;

public class Apartment extends PairHouse{
//	***** 멤버 변수 *****
	private String[] facilities;	// 편의시설(헬스장, 수영장 등)
	

//	***** 생성자 *****
	public Apartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartment(String address, int size, Room[] rooms, int dogCnt, String detailAddress,
			String houseType) {
		super(address, size, rooms, dogCnt, detailAddress, houseType);
		// TODO Auto-generated constructor stub
	}

//	***** 멤버 메서드 *****
	public void callOffice() {
		System.out.println("관리실 호출");
	}	
	
	@Override
	public void clean() {
		System.out.println("아파트 청소");
	}
	
	
//	***** Getter, Setter *****	
	public String[] getOption() {
		return facilities;
	}

	public void setOption(String[] option) {
		this.facilities = option;
	}
	
	

	
}
