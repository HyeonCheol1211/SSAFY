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
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[M];
			int rst=0;
			int idx=0;
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[idx++] = (1<<(a-1)) + (1<<(b-1));
			}
			
			for(int i=0;i<(1<<N);i++) {
				boolean check = true;
				for(int j=0;j<idx;j++) {					
					if(Integer.bitCount(i&arr[j]) == 2) {
						check = false;
						break;
					}
				}
				if(check)rst++;
			}
			sb.append(rst);
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

}
