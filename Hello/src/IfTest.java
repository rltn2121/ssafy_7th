
public class IfTest {
	public static void main(String[] args) {
		int a = 10;
		boolean b = false;
		
		if (b && ++a == 11)
			System.out.println(a);
	}
	
	static boolean m() {
		return false;
	}
}
