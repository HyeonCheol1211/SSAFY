import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] arr = new int[2][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				arr[0][i] = Integer.parseInt(st.nextToken());
				arr[1][i] = Integer.parseInt(st.nextToken());
			}
			int rst=0;
			for(int i=0;i<(1<<N);i++) {
				int sum=0;
				int limit=0;
				for(int j=0;j<N;j++) {
					if((i & (1<<j)) > 0) {
						sum+= arr[0][j];
						limit += arr[1][j];
					}
				}
				if(limit<=L) {
					rst = Math.max(rst, sum);
				}
			}
			sb.append(rst);
			
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

}
