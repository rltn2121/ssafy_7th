package ps_java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class b_1000 {
	public static void main(String[] args) throws IOException {
		// 입력 버퍼 생성
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		// 테케 입력 받음
		String input = br.readLine();
		
		// 문자열을 지정한 구분자로 쪼개주는 클래스
		StringTokenizer st = new StringTokenizer(input, " ");
		
		// 토큰 쪼개서 읽기
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.println(a + b);
	}
}
