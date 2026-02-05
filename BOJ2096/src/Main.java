import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[][] dpMax = new int[N][3];
		int[][] dpMin = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dpMax[N - 1][0] = arr[N - 1][0];
		dpMax[N - 1][1] = arr[N - 1][1];
		dpMax[N - 1][2] = arr[N - 1][2];

		if (N > 1) {
			for (int i = N - 2; i >= 0; i--) {
				dpMax[i][0] = Math.max(dpMax[i + 1][0], dpMax[i + 1][1]) + arr[i][0];
				dpMax[i][1] = Math.max(dpMax[i + 1][0], Math.max(dpMax[i + 1][1], dpMax[i + 1][2])) + arr[i][1];
				dpMax[i][2] = Math.max(dpMax[i + 1][1], dpMax[i + 1][2]) + arr[i][2];
			}
		}
		
		dpMin[N - 1][0] = arr[N - 1][0];
		dpMin[N - 1][1] = arr[N - 1][1];
		dpMin[N - 1][2] = arr[N - 1][2];
		
		if (N > 1) {
			for (int i = N - 2; i >= 0; i--) {
				dpMin[i][0] = Math.min(dpMin[i + 1][0], dpMin[i + 1][1]) + arr[i][0];
				dpMin[i][1] = Math.min(dpMin[i + 1][0], Math.min(dpMin[i + 1][1], dpMin[i + 1][2])) + arr[i][1];
				dpMin[i][2] = Math.min(dpMin[i + 1][1], dpMin[i + 1][2]) + arr[i][2];
			}
		}
		
		int max = Math.max(dpMax[0][0],Math.max(dpMax[0][1], dpMax[0][2]));
		int min = Math.min(dpMin[0][0],Math.min(dpMin[0][1], dpMin[0][2]));
		System.out.println(max + " " + min);
	}
}
