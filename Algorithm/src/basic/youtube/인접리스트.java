package basic.youtube;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
*/
public class 인접리스트 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int C = sc.nextInt();
		
//		int[][] adjMatrix = new int[N][N];
		Node[] adjList = new Node[N];
		
		for(int i = 0; i<C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
//			adjMatrix[from][to] = adjMatrix[to][from] = 1;
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		
//		for(int[] arr : adjMatrix)
//			System.out.println(Arrays.toString(arr));
//		for(Node head : adjList) {
//			System.out.println(head);
//		}
		
		bfs(adjList,0);
	}
	
	static class Node{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", next=" + next + "]";
		}
	}
	public static void bfs(Node[] adjList, int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			System.out.println((char)(current+65));
			
			for(Node temp = adjList[current]; temp!=null; temp=temp.next) {
				if(!visited[temp.vertex]) {
					q.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
	}
	
	public static void dfs(Node[] adjList, boolean[] visited, int current) {
		visited[current] = true;
		System.out.println(current);
		
		for(Node temp = adjList[current]; temp!=null; temp=temp.next) {
			if(!visited[temp.vertex])
				dfs(adjList, visited, temp.vertex);
		}
	}

}
