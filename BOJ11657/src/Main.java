import java.io.*;
import java.util.*;

public class Main {
	// V = 500 E 6000
	static class Node {
		int node;
		int weight;

		public Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}

	static int INF = 60000001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<List<Node>> edges = new ArrayList<List<Node>>();
		for (int i = 0; i < N; i++) {
			edges.add(new ArrayList<Node>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges.get(a - 1).add(new Node(b - 1, c));
		}

		int[] rst = new int[N];
		for (int i = 1; i < N; i++) {
			rst[i] = INF;
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N - 1; i++) {
				for (int j = 0; j < edges.get(i).size(); j++) {
					Node cn = edges.get(i).get(j);
					if (rst[i] + cn.weight < rst[cn.node]) {
						rst[cn.node] = rst[i] + cn.weight;
					}
				}
			}
		}
		
		boolean unsignedCycle = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < edges.get(i).size(); j++) {
				Node cn = edges.get(i).get(j);
				if (rst[i] + cn.weight < rst[cn.node]) {
					System.out.println(-1);
					return;
				}
			}
		}

		for (int i = 1; i < N; i++) {
			if (rst[i] == INF) {
				System.out.println(-1);
			} else {
				System.out.println(rst[i]);
			}
		}

	}

}
