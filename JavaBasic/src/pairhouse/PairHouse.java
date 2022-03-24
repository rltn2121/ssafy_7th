package pairhouse;

public class PairHouse {

//	***** 멤버 변수 *****
	private String address;			// 주소
	private String detailAddress;	// 세부 주소 (몇동 몇호)
	private int size;						// 평수
	private Room[] rooms = new Room[10];	// 방 (거실, 안방 등)
	private int dogCnt;						// 반려견 마리 수
	private String houseType;				// 주거 형태 (월세, 전세, 매매 등)
	
//	 ***** 생성자 *****
	public PairHouse() {
		
	}
	public PairHouse(String address, int size, Room[] rooms, int dogCnt, String detailAddress,
			String houseType) {
		super();
		this.address = address;
		this.size = size;
		this.rooms = rooms;
		this.dogCnt = dogCnt;
		this.detailAddress = detailAddress;
		this.houseType = houseType;
	}
	
	
//	 ***** 멤버 메서드 *****
	public void clean() {
		System.out.println("집 청소");
	}
	
//	 ***** Getter, Setter *****
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Room[] getRooms() {
		return rooms;
	}
	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}
	public int getDogCnt() {
		return dogCnt;
	}
	public void setDogCnt(int dogCnt) {
		this.dogCnt = dogCnt;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	
}
