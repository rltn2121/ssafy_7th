package ps_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b_2588 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int first = Integer.parseInt(br.readLine());
		int result = 0;
		String str = br.readLine();
		
		for(int i = 2; i>=0; i--) {
			int now = str.charAt(i) - '0';
			System.out.println(first * now);
			result += (first * now) * Math.pow(10, 2-i);
		}
		System.out.println(result);
	}
}
