public class Robot2 {
	// 멤버 변수
	private String name;
	private int level;		// 실행블록 외부에서 선언됐으므로, heap 영역에 저장됨
	
	// 메서드
	public void move() {
		System.out.println(this.name + " 이 "+ this.level + " 성능으로 움직이고 있어요!!");
	}
	
	// Getter, Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
