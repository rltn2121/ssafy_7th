package basic.webex;

import java.io.*;
import java.util.*;

public class s_6808_비트마스킹 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T, cnt_gyu, cnt_in, arr_gyu[], arr_in[], res[];
	static boolean visited_gyu[];
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			cnt_gyu = 0;
			cnt_in = 0;
			arr_gyu = new int[9];
			arr_in = new int[9];
			res = new int[9];
			visited_gyu = new boolean[19];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<9; i++) 
				visited_gyu[Integer.parseInt(st.nextToken())] = true;
			
			int idx1 = 0;
			int idx2 = 0;
			for(int i = 1; i<=18; i++) {
				if(visited_gyu[i])	arr_gyu[idx1++] = i;
				else				arr_in[idx2++] = i;
			}
			
			Arrays.sort(arr_in);
			perm(0,0,0,0);
			
			sb.append("#").append(tc).append(" ").append(cnt_gyu).append(" ").append(cnt_in).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void perm(int idx, int sum_gyu, int sum_in, int flag) {
		if(idx==9) {
			if(sum_gyu > sum_in)	cnt_gyu++;
			else					cnt_in++;
			return;
		}
		
		for(int i = 0; i<9; i++) {
			if((flag & (1<<i)) != 0) continue;
			
			if(arr_gyu[idx] > arr_in[i]) 
				perm(idx+1, sum_gyu+arr_gyu[idx]+arr_in[i], sum_in, flag | (1<<i));
			 else 
				perm(idx+1, sum_gyu, sum_in+arr_gyu[idx]+arr_in[i], flag | (1<<i));
			
		}
	}
}
