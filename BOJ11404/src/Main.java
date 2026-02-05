import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] price = new int[N][N];
		// price[a][b] => a도시에서 b도시로 가는 비용
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int p = Integer.parseInt(st.nextToken());
			if (price[a][b] == 0) {
				price[a][b] = p;
			} else {
				price[a][b] = Math.min(p, price[a][b]);
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j)
						continue;
					if (price[i][k] == 0)
						continue;
					if (price[k][j] == 0)
						continue;
					if (price[i][j] == 0) {
						price[i][j] = price[i][k] + price[k][j];

					} else {
						price[i][j] = Math.min(price[i][j], price[i][k] + price[k][j]);
					}

				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(price[i][j] + " ");
			}
			System.out.println();
		}

	}

}
