import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] price = new int[N][N];
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer>[][] route = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				route[i][j] = new ArrayList<Integer>();
			}
		}
		// price[a][b] => a도시에서 b도시로 가는 비용
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int p = Integer.parseInt(st.nextToken());
			if(price[a][b] == 0) {
			price[a][b] = p;
			route[a][b].add(a);
			}else if(price[a][b]>p){
				price[a][b] = p;
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
						for (int l = 0; l < route[i][k].size(); l++) {
							route[i][j].add(route[i][k].get(l));
						}
						for(int l=0;l<route[k][j].size();l++) {
							route[i][j].add(route[k][j].get(l));
						}

					} else {
						if (price[i][j] > price[i][k] + price[k][j]) {
							route[i][j].clear();
							for (int l = 0; l < route[i][k].size(); l++) {
								route[i][j].add(route[i][k].get(l));
							}
							for(int l=0;l<route[k][j].size();l++) {
								route[i][j].add(route[k][j].get(l));
							}
						}
						price[i][j] = Math.min(price[i][j], price[i][k] + price[k][j]);
					}

				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(price[i][j] + " ");
			}
			sb.append("\n");
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(route[i][j].isEmpty()) {
					sb.append("0\n");
				}else {
					sb.append(route[i][j].size()+1 + " ");
					for(int k=0;k<route[i][j].size();k++) {
						sb.append(route[i][j].get(k)+1 + " ");
					}
					sb.append(j+1 + "\n");
				}
			}
		}
		
		System.out.println(sb);
	}

}
