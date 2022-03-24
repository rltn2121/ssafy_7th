package basic.youtube;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSetBinaryCountingTest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine()," ");
		int[] input = new int[N];
		for(int i = 0; i<N; i++) 
			input[i] = Integer.parseInt(st.nextToken());
		generateSubset(input);
		br.close();
}
	private static void generateSubset(int[] input) {
		int N = input.length;
		int caseCount = 1<<N;
		
		for(int mask = 0; mask<caseCount; mask++) {
			// mask: 원소들의 선택 상태의 비트열
			for(int i = 0; i<N; i++){	// 각 비트열의 상태를 확인
				if((mask & (1<<i)) != 0) {
					System.out.print(input[i] + " ");
				}
			}
			System.out.println();
		}
	}
}