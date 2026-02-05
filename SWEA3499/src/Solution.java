import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			String[] strList = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				strList[i] = st.nextToken();
			}
			sb.append("#").append(t).append(" ");
			for(int i=0;i<(N+1)/2;i++) {
				sb.append(strList[i]);
				sb.append(" ");
				if(i+(N+1)/2 > N-1) break;
				sb.append(strList[i+(N+1)/2]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
