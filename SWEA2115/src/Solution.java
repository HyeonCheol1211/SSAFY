import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			int rst=0;
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());//3 10
			int M = Integer.parseInt(st.nextToken());//1 5
			int C = Integer.parseInt(st.nextToken());//10 30
			int[][] honey = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					honey[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			
			
			

			
			
			sb.append(rst).append("\n");
		}
		
	}

}
