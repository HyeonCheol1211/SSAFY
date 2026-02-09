import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[K + 1];
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 0원을 만드는 방법은 '아무 동전도 사용하지 않는' 1가지 경우임
        dp[0] = 1;

        // 핵심: 동전을 하나씩 고정하고, 그 동전으로 만들 수 있는 금액들을 누적함
        for (int i = 0; i < N; i++) {
            for (int j = arr[i]; j <= K; j++) {
                // j원 만들기 = 기존 방법 + (j - 현재 동전 가치)원을 만드는 방법
                dp[j] += dp[j - arr[i]];
            }
        }

        System.out.println(dp[K]);
    }
}