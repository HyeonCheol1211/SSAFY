import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			sb.append("#").append(test_case).append(" ");
			
			
			
			int K = Integer.parseInt(br.readLine());
			for(int i=0;i<K;i++) {
				turn(0,0);
			}
			
			
			
			
			
		
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void turn(int num, int dir) {
		
		
	}

}
