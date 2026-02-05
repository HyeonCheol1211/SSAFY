import java.util.*;
import java.io.*;
 
public class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        for(int test_case=1;test_case<=T;test_case++){
            int t = Integer.parseInt(br.readLine());
            int[] arr = new int[8];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<8;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int index = 0;
            int minusValue = 1;
            while(true){
                arr[index] -= minusValue;
                if(arr[index] <= 0){
                    arr[index] = 0;
                    sb.append("#");
                    sb.append(t);
                    sb.append(" ");
                    for(int i=index+1;i<8;i++){
                    	sb.append(arr[i]);
                    	sb.append(" ");
                    }
                    for(int i=0;i<index+1;i++){
                    	sb.append(arr[i]);
                    	sb.append(" ");
                    }
                    sb.append("\n");
                    break;
                }
                index++;
                minusValue++;
                if(index > 7){
                    index -= 8;
                }
                if(minusValue > 5){
                    minusValue -= 5;
                }
            }
        }
        System.out.println(sb); 
    }
}