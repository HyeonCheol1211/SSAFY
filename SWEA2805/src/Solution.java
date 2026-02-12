import java.util.*;
import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
        	sb.append("#").append(test_case).append(" ");
            int N = Integer.parseInt(br.readLine());
            int rst=0;
            for(int j=0;j<N;j++){
                String s = br.readLine();
                for(int i=Math.abs(-(N/2)+j);i<N-Math.abs(-(N/2)+j);i++){
                    rst += s.charAt(i) - '0';
                }
            }
            sb.append(rst).append("\n");
        }
        System.out.println(sb);
    }
}