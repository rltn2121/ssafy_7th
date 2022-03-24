package basic.webex;

public class BASIC_RecursiveCall {
	public static void main(String[] args) {
		m2();
	}
	
	static int cnt = 5;
	static void m2() {
		if(cnt == 0) return;
		
		System.out.println("1 - cnt: " + cnt);
		cnt--;
		m2();
		cnt++;
		System.out.println("2 - cnt: " + cnt);
	}
	
	static void m3(int cnt) {
		if(cnt == 0) return;
		
		System.out.println("1 - cnt: " + cnt);
		m3(cnt-1);
		System.out.println("2 - cnt: " + cnt);
	}
}
