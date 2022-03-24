package ps_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b_10430 {
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		bw.write( (A+B)%C+ "\n");
		bw.write( ((A%C) + (B%C))%C+ "\n");
		bw.write( (A*B)%C+ "\n");
		bw.write( ((A%C) * (B%C))%C+ "\n");
		
		bw.close();
	}
}
