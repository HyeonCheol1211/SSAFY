import java.io.*;
import java.util.*;

public class Main {
	static List<Node> nodes = new ArrayList<Node>();
	static boolean[] visited;
	static int max_dist = 0;
	static int max_idx=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		visited[0] = true;
		for (int i = 0; i < N + 1; i++) {
			nodes.add(new Node());
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			nodes.get(a).iniNode(a, b, c);
			nodes.get(b).iniNode(b, a, c);
		}

		dfs(1, 0);
		max_dist=0;
		for(int i=0;i<=N;i++) {
			visited[i] = false;
		}

		dfs(max_idx, 0);
		System.out.print(max_dist);

	}

	private static void dfs(int a, int sum) {
		visited[a] = true;
		if(max_dist < sum) {
			max_dist=sum;
			max_idx = a;
		}

		for (int i = 0; i < nodes.get(a).edges.size(); i++) {
			if (!visited[nodes.get(a).edges.get(i)[0]]) {
				dfs(nodes.get(a).edges.get(i)[0], sum + nodes.get(a).edges.get(i)[1]);
			}
		}

	}

	static class Node {
		int a;
		List<int[]> edges = new ArrayList<>();

		public Node() {
		}

		public void iniNode(int a, int b, int c) {
			this.a = a;
			edges.add(new int[] { b, c });
		}
	}
}
