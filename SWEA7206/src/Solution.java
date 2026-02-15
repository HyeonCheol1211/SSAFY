import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            String str = br.readLine();
            Queue<String> queue = new LinkedList<>();
            queue.offer(str);
            boolean plus = false;
            int cnt=0;
            while(!queue.isEmpty()){
                int size = queue.size();
                plus = false;
                for(int i=0;i<size;i++){
                    str = queue.poll();
                    int total = 1;
                    int sum = 0;
                    for(int j=0;j<(1<<str.length()-1);j++){
                        for(int k=0;k<str.length();k++){
                            if((j & (1<<k)) > 0){
                                sum += str.charAt(k) - '0';
                                total *= sum;
                                sum = 0;
                            }else{
                                sum += str.charAt(k) - '0';
                                if(k == str.length()-1){
                                    total *= sum;
                                    sum = 0;
                                }
                            }
                        }
                        if(total>=10){
                            queue.offer(String.valueOf(total));
                            plus = true;
                        }
                    }
                }
                if(plus){
                    cnt++;
                }
            }
            sb.append(cnt);
            sb.append("\n");
        }
        System.out.println(sb);
    }

}