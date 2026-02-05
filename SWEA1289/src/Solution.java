import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			char check = '0';
			int rst=0;
			String bits = br.readLine();
			for(int i=0;i<bits.length();i++) {
				if(bits.charAt(i) != check) {
					rst++;
					check = check == '0' ? '1' : '0';
				}
			}
			sb.append("#").append(test_case).append(" ").append(rst).append("\n");
		}
		System.out.println(sb);
	}
}