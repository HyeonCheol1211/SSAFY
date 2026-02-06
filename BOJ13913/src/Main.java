import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] rstArr = new int[100001];
		int[] route = new int[100001];
		
		for (int i = 0; i < 100001; i++) {
			rstArr[i] = 100001;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		rstArr[N] = 0;
		
		while (!queue.isEmpty()) {
			int a = queue.poll();
			
			if (a == M) break;
			
			int[] nextMoves = {a * 2, a + 1, a - 1};
			
			for (int next : nextMoves) {
				if (next >= 0 && next <= 100000) {
					if (rstArr[next] == 100001) {
						rstArr[next] = rstArr[a] + 1;
						route[next] = a;
						queue.add(next);
					}
				}
			}
		}

		System.out.println(rstArr[M]);
		
		Stack<Integer> stack = new Stack<>();
		int temp = M;
		while (temp != N) {
			stack.push(temp);
			temp = route[temp];
		}
		stack.push(N);
		
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb);
	}
}