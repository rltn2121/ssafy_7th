import java.util.Scanner;

public class Array_3배수_합_RF {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = 5;
		int input = 0;
		int count = 0;
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				input = sc.nextInt();
				if(input % 3 == 0) {		
					count++;
					sum += input;
				}
			}
		}
		
		System.out.println(count);
		System.out.println(sum);
	}
}

/*
2 3 1 4 7
8 13 3 33 1
7 4 5 80 12
17 9 11 5 4
4 5 91 27 7
*/