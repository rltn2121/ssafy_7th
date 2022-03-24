import java.io.File;

public class Robot1 {
	String name;
	int level;		// 실행블록 외부에서 선언됐으므로, heap 영역에 저장됨
	
	File f;
	public void move() {
		System.out.println("움직이고 있어요!!");
	}
	
}
