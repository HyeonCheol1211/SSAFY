import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] houses = new int[N];
		for (int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(houses);
		int start, end, cur;
		start = 0;
		end = houses[N-1] - houses[0];
		int rst=0;
		while (true) {
			cur = (start + end) / 2;
			if (canSet(houses, cur, N, M)) {
				start = cur + 1;
				rst = cur;
			} else {
				end = cur - 1;
			}

			if (end < start)
				break;
		}

		System.out.println(rst);

	}

	private static boolean canSet(int[] houses, int cur, int N, int M) {
		int cnt = 1;
		int lastLoc = houses[0];
		for (int i = 0; i < N - 1; i++) {
			if (houses[i + 1] - lastLoc >= cur) {
				cnt++;
				lastLoc = houses[i+1];
			}
			if (cnt >= M)
				return true;
		}
		return false;
	}
}
