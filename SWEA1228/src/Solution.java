import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb2 = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			List<String> rst = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				rst.add(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				st.nextToken();
				int idx = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				for (int i = 0; i < cnt; i++) {
					rst.add(idx++, st.nextToken());
				}
			}
			sb.append("#").append(test_case).append(" ");
			for(int i=0;i<10;i++) {
				sb.append(rst.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
