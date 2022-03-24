package basic.youtube;

import java.util.LinkedList;
import java.util.Queue;

public class MyChu {
	public static void main(String[] args) {
		Queue<Person> q = new LinkedList<>();
		int cnt = 20;
		int step = 1;
		// 총 개수는 20개
		// 1. dequeue해서 마지막인지 검사하고 ++하고 다시 넣기
		// 2. 새로운 사람 넣기
		
		while(true) {
			if(!q.isEmpty()) {
				Person now = q.poll();
				cnt-=now.n;
				
				if(cnt <=0) {
					// 이 사람이 마지막
					System.out.println(now.idx+ "번이 마지막");
					break;
				}
				
				System.out.println(now.idx + "번이 " + now.n + "개의 마이쮸를 받는다.");
				// 다음에 받을 개수 늘리고 큐에 집어넣기
				now.n++;
				q.offer(now);
				System.out.println(now.idx + "번이 다시 줄을 선다.");
			}
			// 새로운 사람 생성
			Person p = new Person(step++, 1);
			q.offer(p);
			System.out.println("새로 " + p.idx + "번이 들어와 줄을 선다.");
			
		}
		
	}
	
	static class Person{
		int idx;
		int n;
		public Person(int idx, int n) {
			this.idx = idx;
			this.n = n;
		}
	}
}
