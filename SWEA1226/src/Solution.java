import java.util.*;
import java.io.*;
public class Solution {
    static int rst = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for(int test_case=1;test_case<=T;test_case++){
            int t = Integer.parseInt(br.readLine());
            int[][] map = new int[16][16];
            boolean[][] visited = new boolean[16][16];
            int sY=0, sX=0;
            Deque<Pos> deque = new ArrayDeque<Pos>();
            for(int i=0;i<16;i++){
                String s = br.readLine();
                for(int j=0;j<16;j++){
                    map[i][j] = s.charAt(j) - '0';
                    if(map[i][j] == 2){
                       sY = i;
                       sX = j;
                    }
                }
            }
            deque.offerLast(new Pos(sX, sY));
            bfs(map, visited, deque);
 
            System.out.printf("#%d %d\n", t, rst);
            rst = 0;
        }
    }
    static class Pos{
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
 
    static void bfs(int[][] map, boolean[][] visited, Deque<Pos> deque){
        int[] nY = {-1, 0, 1, 0};
        int[] nX = {0, 1, 0, -1};
        while(!deque.isEmpty()){
            Pos pos = deque.pollFirst();
            int sY = pos.y;
            int sX = pos.x;
            visited[sY][sX] = true;
            if(map[sY][sX] == 3){
                rst = 1;
                return;
            }
            for(int i=0;i<4;i++){
                int nextY = sY + nY[i];
                int nextX = sX + nX[i];
                if(nextY < 0 || nextX<0||nextY>15||nextX>15) continue;
                if(!visited[nextY][nextX]){
                    if(map[nextY][nextX] == 0 || map[nextY][nextX] == 3)
                    deque.offerLast(new Pos(nextX, nextY));
                }
            }
        }
    }
 
}