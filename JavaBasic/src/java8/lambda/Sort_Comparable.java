package java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort_Comparable {
	public static void main(String[] args) {
		List<Node> list = new ArrayList<>();
		list.add(new Node(6, 4));
		list.add(new Node(1, 7));
		list.add(new Node(8, 4));
		list.add(new Node(3, 0));
		list.add(new Node(9, 6));
		
		for (Node node : list) {
			System.out.println(node);
		}
		
/**
 *  @param: Comparable<>을 구현한 객체 
 */
		Collections.sort(list);
	}
	
	// Collections.sort를 하기 위해서는 Comparable 인터페이스를 구현해야 함
	// 하지만, 인터페이스를 이렇게 구현하면 정렬 기준을 변경할 수 없음
	static class Node implements Comparable<Node>{
		public int y;
		public int x;
		
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.y - o.y;
		}
	}
}
