package pairhouse;

public class Jutaek extends PairHouse{
	
//	***** 멤버 변수 *****
	private boolean yard;	// 마당 존재 유무
	private int height;		// 층수
	
//	***** 생성자 *****
	public Jutaek() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jutaek(String address, int size, Room[] rooms, int dogCnt, String detailAddress,
			String houseType) {
		super(address, size, rooms, dogCnt, detailAddress, houseType);
		// TODO Auto-generated constructor stub
	}

	
//	***** 멤버 메서드 *****
	public void cleanYard() {
		System.out.println("마당 청소 하기");
	}
	
	@Override
	public void clean() {
		System.out.println("주택 청소");
	}
//	***** Getter, Setter *****	
	public boolean isYard() {
		return yard;
	}
	

	public void setYard(boolean yard) {
		this.yard = yard;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
