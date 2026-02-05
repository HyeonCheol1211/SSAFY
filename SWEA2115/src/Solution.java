import java.util.*;
import java.io.*;

public class Solution {
    static int[][] honey, memo;
    static int N, M, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            honey = new int[N][N];
            memo = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    honey[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) {
                    memo[i][j] = dfs(i, j, 0, 0, 0);
                }
            }

            int rst = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) {
                    for (int c = j + M; c <= N - M; c++) {
                        rst = Math.max(rst, memo[i][j] + memo[i][c]);
                    }
                    for (int r = i + 1; r < N; r++) {
                        for (int c = 0; c <= N - M; c++) {
                            rst = Math.max(rst, memo[i][j] + memo[r][c]);
                        }
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(rst).append("\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int i, int j, int cnt, int sum, int profit) {
        if (sum > C) return 0;
        if (cnt == M) return profit;

        int val = honey[i][j + cnt];
        return Math.max(
                dfs(i, j, cnt + 1, sum + val, profit + val * val),
                dfs(i, j, cnt + 1, sum, profit)
        );
    }
}