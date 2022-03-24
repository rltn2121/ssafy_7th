package basic.youtube.datastructure;

public class Node {
	String data;
	Node next;
	public Node(String data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}
	// next 없이 데이터만 저장
	public Node(String data) {
		super();
		this.data = data;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
}
