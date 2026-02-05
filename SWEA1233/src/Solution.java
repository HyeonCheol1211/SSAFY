import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");

			int N = Integer.parseInt(br.readLine());
			boolean nono = false;
			char[] arr = new char[N + 1];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				arr[i] = st.nextToken().charAt(0);
			}
			if (N % 2 == 0) {
				sb.append(0).append("\n");
				continue;
			}
			for (int i = 1; i <= N / 2; i++) {
				if (arr[i] >= '0' && arr[i] <= '9') {
					sb.append(0).append("\n");
					nono=true;
					break;
				}
			}
			if(nono) continue;
			for (int i = N / 2 + 1; i <= N; i++) {
				if (arr[i] < '0' || arr[i] > '9') {
					sb.append(0).append("\n");
					nono=true;
					break;
				}
			}
			if(nono) continue;

			sb.append(1).append("\n");
		}
		System.out.println(sb);
	}

}
