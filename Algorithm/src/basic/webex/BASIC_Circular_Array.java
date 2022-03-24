package basic.webex;

public class BASIC_Circular_Array {
	public static void main(String[] args) {
		char[] input = {'A', 'B', 'C', 'D','E','F', 'G'};
		int n = input.length;
		{
			for(int i = 0; i<n*2+3;i++)
				System.out.println(input[i%n]);
		}
		
		{
			int cnt = 0;
			int i = 0;
			
			while(true) {
				if(cnt==20)break;
				System.out.println(input[i%n] + " ");
				cnt++;
				i++;
			}
		}
	}
}
