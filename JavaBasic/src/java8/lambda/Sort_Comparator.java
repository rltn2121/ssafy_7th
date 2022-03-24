package java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort_Comparator {
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
		
		// 두 번째 파라미터에서 Comparator를 정의함
		Collections.sort(list, new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				return o1.y - o2.y;
			}
		});
		
		// 두 번째 파라미터에서 Lambda 사용
		Collections.sort(list, (n1, n2) -> n1.y - n2.y);
	}
	
	static class Node {
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
	}
}
