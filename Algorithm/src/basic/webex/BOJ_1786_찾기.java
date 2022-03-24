package basic.webex;

import java.io.*;
import java.util.*;

public class BOJ_1786_찾기 {
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	static String T, P;
	public static void main(String[] args) throws Exception {
		input();
		
		kmp();
		
		System.out.println(cnt);
		System.out.println(sb.toString());
	}
	
	static void kmp() {
		int[] pi = getPI(P);
		
		int t_len = T.length();
		int p_len = P.length();
		
		char[] arr_t = T.toCharArray();
		char[] arr_p = P.toCharArray();
		
		
		
		int j = 0;
		for (int i = 0; i < t_len; i++) {
			while(j>0 && arr_t[i] != arr_p[j])
				j = pi[j-1];
			
			if(arr_t[i] == arr_p[j]) {
				// 모두 일치했나? 그렇지 않은가?
				if(j == p_len - 1) {	// 일치
					cnt++;
					
					// 0123456789...
					//  CAABAABAB.... 	i: 8
					//    ABAABAB		j: 7 -1 = 6
					// i - pLength + 2	8 - 7 + 2
					sb.append(i-p_len+2).append(" ");
					j = pi[j];
				} else {				// 불일치
					j++;
				}
			}
		}
	}
	
	static int[] getPI(String p) {
		int[] pi = new int[p.length()];
		char[] pArray = p.toCharArray();
		
		int j = 0;	// 접두사 index
		// i: 접미사 index
		for (int i = 1; i < pArray.length; i++) {
			
			
			// 불일치 (패턴이 다른 경우)
			while(j>0 && pArray[i] != pArray[j])
				j = pi[j-1];
			
			
			if(pArray[i] == pArray[j]) {
				j++;
				pi[i] = j;
			}
		}
		return pi;
	}
	
	
	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine();
		P = br.readLine();
		br.close();
	}
}
