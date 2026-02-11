import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int rst = 0;
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				if (i <= 2) {
					for (int j = 2 - i; j < 5 + i - 2; j++) {
						rst += line.charAt(j)-'0';
					}
				}else {
					for(int j=i-2;j<i)
				}
			}
			sb.append(rst);
			sb.append("\n");
		}
		System.out.println(rst);
	}

}
