import java.io.*;
import java.util.*;

public class Main {

	private static final int INF = 200_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[][] edges = new int[N][N];
		int[][] rst = new int[3][N];
		boolean[][] visited = new boolean[3][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(edges[i], INF);
			edges[i][i] = 0;
		}

		for (int i = 0; i < 3; i++) {
			Arrays.fill(rst[i], INF);
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edges[u - 1][v - 1] = Math.min(edges[u - 1][v - 1], w);
			edges[v - 1][u - 1] = Math.min(edges[v - 1][u - 1], w);
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		rst[0][0] = 0;
		rst[1][v1 - 1] = 0;
		rst[2][v2 - 1] = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < N; j++) {
				int u = findMin(rst[i], visited[i], N);

				if (u == -1)
					
					
					
					
					
					
					
					break;

				visited[i][u] = true;
				for (int v = 0; v < N; v++) {
					if (!visited[i][v] && edges[u][v] != INF) {
						if (rst[i][v] > rst[i][u] + edges[u][v]) {
							rst[i][v] = rst[i][u] + edges[u][v];
						}
					}
				}
			}
		}

		long path1 = (long) rst[0][v1 - 1] + rst[1][v2 - 1] + rst[2][N - 1];
		long path2 = (long) rst[0][v2 - 1] + rst[2][v1 - 1] + rst[1][N - 1];

		long ans = Math.min(path1, path2);

		if (ans >= INF) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	private static int findMin(int[] arr, boolean[] visited, int N) {
		int minVal = INF;
		int minIdx = -1;
		for (int i = 0; i < N; i++) {
			if (!visited[i] && arr[i] < minVal) {
				minVal = arr[i];
				minIdx = i;
			}
		}
		return minIdx;
	}
}