import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder rst = new StringBuilder();
		for(int test_case=1;test_case<=T;test_case++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			int size = Math.max(a.length(), b.length());
			int carry = 0;
			for(int i=0;i<size;i++	) {
				int aidx= a.length()-i-1;
				int bidx = b.length()-i-1;
				if(aidx<0) {
					if(carry==0) {
						sb.append(b.charAt(bidx));
						continue;
					}else {
						int temp =b.charAt(bidx) - '0' + carry;
						carry = 0;
						if(temp>9) carry = 1;
						sb.append(temp%10);
						continue;
					}
				}
				if(bidx<0) {
					if(carry==0) {
						sb.append(a.charAt(aidx));
						continue;
					}else {
						int temp =a.charAt(aidx) - '0' + carry;
						carry = 0;
						if(temp>9) carry = 1;
						sb.append(temp%10);
						continue;
					}
				}
				int temp = a.charAt(aidx) + b.charAt(bidx) - 2*'0' + carry;
				carry = 0;
				if(temp>9) carry = 1;
				sb.append(temp%10);
			}
			if(carry==1) {
				sb.append("1");
			}
			
			rst.append("#");
			rst.append(test_case);
			rst.append(" ");
			rst.append(sb.reverse());
			rst.append("\n");
		}
		System.out.println(rst);		
	}
}
