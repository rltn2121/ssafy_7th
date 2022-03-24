package java7.singlecatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String s = br.readLine();

			// MyClass.class를 메모리에 로드
			Class.forName("MyClass.class");
			
			// 상속 관계는 순서에 상관 없이 사용 불가
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
