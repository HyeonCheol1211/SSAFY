import java.util.*;
import java.io.*;

public class Solution {
    static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            memo.clear();
            String str = br.readLine();
            int rst = solve(Integer.parseInt(str));

            sb.append("#").append(test_case).append(" ").append(rst).append("\n");
        }
        System.out.print(sb);
    }

    private static int solve(int num) {
        if (num < 10) return 0;
        if (memo.containsKey(num)) return memo.get(num);

        int cnt = 0;
        String str = String.valueOf(num);
        int len = str.length();

        for (int j = 1; j < (1 << (len - 1)); j++) {
            int total = 1;
            int lastIdx = 0;

            for (int k = 0; k < len - 1; k++) {
                if ((j & (1 << k)) > 0) {
                    total *= Integer.parseInt(str.substring(lastIdx, k + 1));
                    lastIdx = k + 1;
                }
            }
            total *= Integer.parseInt(str.substring(lastIdx));

            cnt = Math.max(cnt, 1 + solve(total));
        }

        memo.put(num, cnt);
        return cnt;
    }
}