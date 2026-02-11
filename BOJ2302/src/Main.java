import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M+2];
		for(int i=1;i<=M;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<=40;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		arr[0] = 0;
		arr[M+1] = N+1;
		int rst=1;
		for(int i=1;i<=M+1;i++){
			rst *= dp[arr[i]-arr[i-1]-1];
		}
		System.out.println(rst);
	}

}
