package basic.webex;

public class BASIC_DP_피보나치 {
	public static void main(String[] args) {
//		long result = fibo_rc(50);
		long result = fibo_dp(50);
		System.out.println(result);
	}
	
	static long fibo_rc(long n) {
		if(n<=1) return n;
		return fibo_rc(n-1) + fibo_rc(n-2);
	}
	
	static long fibo_dp(int n) {
		long[] dp = new long[n+1];
		
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i<=n; i++)
			dp[i] = dp[i-1]+dp[i-1];
		return dp[n];
	}
}
