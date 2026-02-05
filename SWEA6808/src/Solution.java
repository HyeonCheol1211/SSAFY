import java.io.*;
import java.util.*;
public class Solution {
    static boolean[] check = new boolean[18];
    static int[] card = new int[9];
    static int[] myCard = new int[9];
    static boolean[] visited = new boolean[9];
    static int win=0;
    static final int TOTAL = 362880;
    static final int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            sb.append("#").append(test_case).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<9;i++){
                card[i] = Integer.parseInt(st.nextToken());
                check[card[i]-1] = true;
            }
            for(int i=0,idx=0;i<18;i++){
                if(!check[i]){
                    myCard[idx++] = i+1;
                }
            }

            dfs(0, 0);
            sb.append(TOTAL-win).append(" ").append(win).append("\n");
            win=0;
            for(int i=0;i<18;i++){
                check[i] = false;
            }

            for(int i=0;i<9;i++){
                visited[i] = false;
            }
        }
        System.out.println(sb);
    }

    static void dfs(int score, int cnt){
        if(score>=86) {
            win += factorial[9-cnt];
            return;
        }
        for(int i=0;i<9;i++) {
            if (!visited[i]) {
                visited[i] = true;
                int add = 0;
                if (myCard[i] > card[cnt]) {
                    add = myCard[i] + card[cnt];
                }
                dfs(score + add, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
