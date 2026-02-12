import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] memo = new int[N][N];
			Queue<Integer> queue = new LinkedList<>();
			int num=0;
			int rst=0;
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					queue.offer(i*1000 + j);
					int len=0;
					while(!queue.isEmpty()) {
						len++;
						int temp = queue.poll();
						int ci = temp/1000;
						int cj = temp%1000;
						for(int d=0;d<4;d++) {
							int ni = ci + dr[d];
							int nj = cj + dc[d];
							if(ni>N-1||ni<0||nj>N-1||nj<0)continue;
							if(map[ni][nj] == map[ci][cj] + 1) {
								if(memo[ni][nj] != 0 ) {
									len += memo[ni][nj];
									break;
								}
								queue.offer(ni*1000+nj);
							}
						}
					}
					memo[i][j] = len;
					if(rst<len) {
						rst = len;
						num = map[i][j];
					}
					if(rst == len) {
						if(num>map[i][j]) {
							num = map[i][j];
						}
					}
				}
			}
			
			
			
			sb.append(num).append(" ").append(rst);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
