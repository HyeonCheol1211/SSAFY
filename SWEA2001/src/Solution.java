import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int rst = -1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					int left = j==0? 0 : map[i][j-1];
					int leftTop = (j!=0 && i!=0)?map[i-1][j-1]:0 ;
					int top = i==0?0:map[i-1][j];
					map[i][j] = Integer.parseInt(st.nextToken()) + left + top - leftTop;
				}
			}
			
			for(int i=M-1;i<N;i++) {
				for(int j=M-1;j<N;j++) {
					int left = j-M<0? 0 : map[i][j-M];
					int leftTop = (j-M>=0 && i-M>=0)?map[i-M][j-M]:0 ;
					int top = i-M<0?0:map[i-M][j];
					rst = Math.max(rst, map[i][j] - left - top + leftTop);
				}
			}
			sb.append("#").append(test_case).append(" ").append(rst).append("\n");			
		}
		System.out.println(sb);
	}
}
