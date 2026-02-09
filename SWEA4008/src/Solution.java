import java.util.*;
import java.io.*;

public class Solution {

	static int maxNum = Integer.MIN_VALUE;
	static int minNum = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int[] oper = new int[4];
			int[] nums = new int[N];
			int[] operArr = new int[N-1];
			for(int i=0;i<N-1;i++) {
				operArr[i] = -1;
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				oper[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(oper, nums, operArr, 0, N);
			sb.append(maxNum - minNum);
			maxNum = Integer.MIN_VALUE;
			minNum = Integer.MAX_VALUE;
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int[] oper, int[] nums, int[] operArr, int depth, int N) {
		if(depth==N-1) {
			int rst = nums[0];
			for(int i=0;i<N-1;i++) {
				if(operArr[i] == 0) {
					rst += nums[i+1];
				}else if(operArr[i] == 1) {
					rst -= nums[i+1];
				}else if(operArr[i] == 2) {
					rst *= nums[i+1];
				}else if(operArr[i] == 3) {
					rst /= nums[i+1];
				}
			}
			maxNum = Math.max(maxNum, rst);
			minNum = Math.min(minNum, rst);
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(oper[i]>0) {
				oper[i]--;
				operArr[depth] = i;
				dfs(oper, nums, operArr, depth+1, N);
				operArr[depth] = -1;
				oper[i]++;
			}
		}
		
	}

}
