import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0, -1, -1, 1, 1};
	static int[] dc = {0, 1, 0, -1, -1, 1, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int rst  = 0;
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					rst = Math.max(rst, Math.max(catchFly(i, j, M, N, 0), catchFly(i, j, M, N, 1)));
				}
			}
			sb.append("#").append(test_case).append(" ").append(rst).append("\n");			
		}
		System.out.println(sb);
	}

	private static int catchFly(int i, int j, int M, int N, int option) {
		int sum = map[i][j];
		int ni=0, nj=0;
		for(int k=1;k<M;k++) {
			for(int d=option*4;d<option*4+4;d++) {
				ni = i + k*dr[d];
				nj = j + k*dc[d];
				if(ni>N-1||ni<0||nj>N-1||nj<0) continue;
				sum+= map[ni][nj];
			}
		}
		return sum;
	}
}
