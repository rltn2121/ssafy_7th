package basic.youtube;

import java.util.LinkedList;
import java.util.Queue;

public class QueueAPITest {
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<String>();
		System.out.println(q.size() + "//" + q.isEmpty());
		q.offer("김대중");
		q.offer("노무현");
		q.offer("이명박");
		q.offer("박근혜");
		System.out.println(q.size() + "//" + q.isEmpty());
		
		System.out.println(q.poll());
		System.out.println(q.size() + "//" + q.isEmpty());
		System.out.println(q.peek());
		System.out.println(q.size() + "//" + q.isEmpty());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.size() + "//" + q.isEmpty());
		System.out.println(q.poll());
	}
}
