import java.io.*;
import java.util.*;

public class Solution {
	static int r, c;
	static int[][] map = new int[100][100];
	public static void main(String[] args) throws IOException {
		int T = 10;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= T; test_case++) {
			br.readLine();
			for(int i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i==99 && map[i][j] == 2) {
						r = i;
						c = j;
					}
				}
			}
			
			while(r>0) {
				int left = c-1;
				int right = c+1;
				
				while(r>0) {
					if(left>=0) {
						if(map[r][left] == 1) {
							for(int i=c-1;i>=0;i--) {
								if(map[0][i]==1) {
									c = i;
									r--;
									break;
								}
							}
							break;
						}
					}
					if(right<100) {
						if(map[r][right] == 1) {
							for(int i=c+1;i<100;i++) {
								if(map[0][i] == 1) {
									c = i;
									r--;
									break;
								}
							}
							break;
						}
					}
					r--;
				}
				
			}
			
			sb.append("#").append(test_case).append(" ").append(c).append("\n");
		}
		System.out.println(sb);
	}
}
