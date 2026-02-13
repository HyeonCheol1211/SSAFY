import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			String str = br.readLine();
			int rst = bfs(str);
			sb.append(rst);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs(String str) {
		Queue<String> queue = new LinkedList<>();
		queue.offer(str);
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int cnt = 0;
		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			for (int k = 0; k < queueSize; k++) {
				String temp = queue.poll();
				int size = temp.length();
				if (size == 1)
					continue;
				for (int i = 1; i < size-1; i++) {
					for(int s1=0;s1<i;s1++) {
						sb1.append(temp.charAt(s1));
					}
					for(int s2=i;s2<size;s2++) {
						sb2.append(temp.charAt(s2));
					}
					int a = Integer.parseInt(sb1.toString());
					int b = Integer.parseInt(sb2.toString());
					sb1.setLength(0);
					sb2.setLength(0);
					int c = a * b;
					if (c >= 10) {
						queue.offer(String.valueOf(c));
					}
				}
			}
			cnt++;
		}

		return cnt;
	}

}