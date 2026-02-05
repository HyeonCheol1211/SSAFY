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
				char cmd = st.nextToken().charAt(0);
				int idx = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				if (cmd == 'I') {
					for (int i = 0; i < cnt; i++) {
						rst.add(idx++, st.nextToken());
					}
				} else {
					for (int i = 0; i < cnt; i++) {
						rst.remove(idx);
					}
				}
			}
			sb.append("#").append(test_case).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(rst.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
