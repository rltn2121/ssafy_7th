package basic.webex;

import java.util.ArrayList;
import java.util.List;

// 0~9 사이의 숫자를 2개의 그룹으로 나눈 뒤, 두 그룹의 원소 수가 3보다 크거나 같은 경우만 출력 (두 그룹 모두 출력)
public class BASIC_PermCombSub2 {
	static int[] src = {0,1,2,3,4,5,6,7,8,9};
	static int[] arr = new int[src.length];
	static int cnt, ans = 0;
	static boolean[] visited = new boolean[src.length];
	public static void main(String[] args) {
		subset(0);
	}
	
	static void subset(int idx) {
		if(idx == src.length) {
			complete();
			return;
		}
		if(idx>=10) return;
		
		// 현재 now를 선택하고 간다.
		visited[idx] = true;
		subset(idx+1);
		// 현재 now를 선택하지 않고 간다.
		visited[idx] = false;
		subset(idx+1);
	}

	static void complete() {
		List<Integer> groupA = new ArrayList<>();
		List<Integer> groupB = new ArrayList<>();
		
		for(int i = 0; i<visited.length; i++) {
			if(visited[i])
				groupA.add(src[i]);
			else
				groupB.add(src[i]);
			
		}
		if(groupA.size()>=3&&groupB.size()>=3) {
			ans++;
			System.out.println("-----------------------");
			for(int n : groupA)
				System.out.print(n + " ");
			System.out.println();
			for(int n : groupB)
				System.out.print(n + " ");
			System.out.println();
		}
	}
}

