import java.util.*;
import java.io.*;

public class Main {
	static final int INF = 200000001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] routes = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				routes[i][j] = INF;
			}
		}
		for (int i = 0; i < N; i++) {
			routes[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			routes[a - 1][b - 1] = Math.min(routes[a - 1][b - 1], c);
			routes[b - 1][a - 1] = Math.min(routes[b - 1][a - 1], c);
		}
		st = new StringTokenizer(br.readLine());
		int fi = Integer.parseInt(st.nextToken());
		int se = Integer.parseInt(st.nextToken());

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (routes[i][k] == INF || routes[k][j] == INF)
						continue;
					routes[i][j] = Math.min(routes[i][j], routes[i][k] + routes[k][j]);
				}
			}
		}

		int rst = Math.min(routes[0][fi - 1] + routes[fi - 1][se - 1] + routes[se - 1][N - 1],
				routes[0][se - 1] + routes[se - 1][fi - 1] + routes[fi - 1][N - 1]);
		if (rst >= INF) {
			System.out.println(-1);
		} else {
			System.out.println(rst);
		}
	}
}
