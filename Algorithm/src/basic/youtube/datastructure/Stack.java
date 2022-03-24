package basic.youtube.datastructure;

public class Stack {
	private Node top;
	
	
	// addFirst
	public void push(String data) {
//		top = new Node(data, top);
		
		Node newNode = new Node(data, null);
		newNode.next = top;
		top = newNode;
	}
	
	// removeFirst
	public String pop() {
		if(isEmpty()) return null;
		Node popNode = top;
		
		top = popNode.next;
		popNode.next= null;
		return popNode.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public String toString() {
		// top부터 마지막 노드까지 쭉 돌며 data를 문자열로 합치기
		StringBuilder sb = new StringBuilder();
		sb.append("Stack[");
		for(Node current = top; current != null; current = current.next)
			sb.append(current.data).append(",");
		if(!isEmpty())
			sb.setLength(sb.length()-1);
		sb.append("]");
		return sb.toString();
		
	}
	
	
}
