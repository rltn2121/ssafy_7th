package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputHandleTest {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
//		(1) 1 2 3 4 5
		{
			int N = 5;
			int[] intArray = new int[N];
			
			for (int i = 0; i < N; i++) 
				intArray[i] = sc.nextInt();
			
			
			for (int n : intArray)
				System.out.print(n + " ");
			
		}

//		(1-2) a b c d e
		{
			int C = 5;
			char[] charArray = new char[C];
			
			for(int i = 0; i<C; i++){
				char ch = sc.next().charAt(0);	// .split() 으로도 분리 가능
				charArray[i] = ch;
			}
		}
		
//		(2) "abcde"
//		입력 문자의 수가 fixed
		{
			
			int C = 5;
			char[] charArray = new char[C];
			String input = sc.nextLine();	// "abcde"
			
			
			for(int i = 0; i<C; i++) {
				char ch = input.charAt(i);
				charArray[i] = ch;
			}
			
			for(char c : charArray)
				System.out.print(c + " ");
		}
		
//		(3) 입력 길이 정해져 있지 않음
		{
			String input = sc.nextLine();	// "abcde"
			char[] charArray = input.toCharArray();
			
			for(char c : charArray)
				System.out.print(c + " ");
		}

		
//		(4) 2
//			abcde
		{
//			nextInt() -> white space 기준으로 입력 구분함
			int n = sc.nextInt();
			String str = sc.nextLine();
			System.out.println(n);
			System.out.println(str);
		}
			
//		 한 줄 단위로 읽음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		5개 정수 배열에 저장
//		1 2 3 4 5
		{
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			int N = 5;
			int[] intArray = new int[N];
			for(int i = 0; i<N; i++) {
				intArray[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i: intArray) {
				System.out.print(i + " ");
			}
			
		}
		
//		abcde
		{
			String input = br.readLine();
			char[] charArray = input.toCharArray();
			for(char c : charArray) {
				System.out.print(c + " ");
			}
		}
			
		
	}
}
