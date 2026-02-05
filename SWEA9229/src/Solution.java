import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			int head = 0;
			int tail = N-1;
			int rst=0;
			while(head<tail) {
				int temp = arr[head] + arr[tail];
				if(temp>M) {
					tail--;
				}else if(temp<M) {
					head++;
					rst = Math.max(rst, temp);
				}else {
					rst = temp;
					break;
				}
			}
			if(rst == 0) {
				sb.append(-1);
			}else {
				sb.append(rst);
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
