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
			int B = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			int dpSize = 10001;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				dpSize += arr[i];
			}
			int[] dp = new int[dpSize];
			dp[0] = 1;
			for (int i = 0; i < N; i++) {
				for (int j = dpSize-1; j >= 0; j--) {
					if (dp[j] != 0) {
						if (j + arr[i] < dpSize) {
							dp[j + arr[i]]++;
						}
					}
				}
			}
			int rst = -1;
			for (int i = B; i < dpSize; i++) {
				if (dp[i] != 0) {
					rst = i - B;
					break;
				}
			}

			sb.append(rst);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
