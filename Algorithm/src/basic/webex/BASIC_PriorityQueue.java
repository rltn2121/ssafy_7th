package basic.webex;

import java.util.PriorityQueue;

public class BASIC_PriorityQueue {
	public static void main(String[] args) {
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		pq.add(3);
//		pq.add(7);
//		pq.add(4);
//		pq.add(2);
//		pq.add(6);
//		pq.add(9);
//		
//		// for each로 출력하면 heap 순서대로 출력
//		while(!pq.isEmpty())
//			System.out.println(pq.poll());
		
		
		PriorityQueue<Integer> pq_order = new PriorityQueue<>((x, y) -> x-y);
		PriorityQueue<Integer> pq_reverse_order = new PriorityQueue<>((x, y) -> y-x);
		PriorityQueue<Node> pq_node = new PriorityQueue<>((n1, n2) -> (n1.x == n2.x) ? (n1.y-n2.y) : (n1.x-n2.x));
		pq_node.add(new Node(3,7));
		pq_node.add(new Node(2,5));
		pq_node.add(new Node(5,2));
		pq_node.add(new Node(7,1));
		pq_node.add(new Node(4,6));
		while(!pq_node.isEmpty())
			System.out.println(pq_node.poll());
	}
	
	static class Node{
		int x,y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}
	}
//	
//	static class Node implements Comparable<Node>{
//		int x,y;
//
//		public Node(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//		
//		@Override
//		public String toString() {
//			return "Node [y=" + y + ", x=" + x + "]";
//		}
//
//		@Override
//		public int compareTo(Node o) {
//			return o.x - this.x;
//		}
//	}
}
