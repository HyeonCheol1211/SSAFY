import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<List<Node>> edges = new ArrayList<>();
		for(int i=0;i<N;i++) {
			edges.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges.get(a-1).add(new Node(b-1, c));
			edges.get(b-1).add(new Node(a-1, c));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N];
		int rst=0;
		visited[0] = true;
		for(int i=0;i<edges.get(0).size();i++) {
			pq.offer(edges.get(0).get(i));
		}
		
		int end=1;
		while(end<N) {
			Node node = pq.poll();
			if(visited[node.node])continue;
			rst+= node.weight;
			visited[node.node] = true;
			for(int i=0;i<edges.get(node.node).size();i++) {
				pq.offer(edges.get(node.node).get(i));
			}
			end++;
		}
		System.out.println(rst);
	}
	
	static class Node implements Comparable<Node>{
		int node;
		int weight;
		public Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

}
