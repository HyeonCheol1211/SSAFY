import java.util.*;
import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
 
            char[][] map = new char[H][W];
            for(int i=0;i<H;i++){
                String s = br.readLine();
                for(int j=0;j<W;j++){
                    map[i][j] = s.charAt(j);
                }
            }
            String cmd = br.readLine();
            cmd = br.readLine();
            for(int i=0;i<cmd.length();i++){
                control(map, cmd.charAt(i), H, W);
            }
            sb.append("#").append(test_case).append(" ");
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
 
    static void control(char[][] map, char cmd, int H, int W){
        int tankY=0, tankX=0;
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(map[i][j] == '<' || map[i][j]=='>' || map[i][j] == '^' || map[i][j] == 'v'){
                    tankY = i;
                    tankX = j;
                }
            }
        }
        if(cmd == 'U'){
            if(tankY-1 <0){
                map[tankY][tankX] = '^';
            }else if(map[tankY-1][tankX] == '.'){
                map[tankY-1][tankX] = '^';
                map[tankY][tankX] = '.';
            }else{
                map[tankY][tankX] = '^';
            }
        }else if(cmd == 'D'){
            if(tankY+1 >H-1){
                map[tankY][tankX] = 'v';
            }else if(map[tankY+1][tankX] == '.'){
                map[tankY+1][tankX] = 'v';
                map[tankY][tankX] = '.';
            }else{
                map[tankY][tankX] = 'v';
            }
 
        }else if(cmd == 'L'){
            if(tankX-1 <0){
                map[tankY][tankX] = '<';
            }else if(map[tankY][tankX-1] == '.'){
                map[tankY][tankX-1] = '<';
                map[tankY][tankX] = '.';
            }else{
                map[tankY][tankX] = '<';
            }
 
        }else if(cmd == 'R'){
            if(tankX+1 > W-1){
                map[tankY][tankX] = '>';
            }else if(map[tankY][tankX+1] == '.'){
                map[tankY][tankX+1] = '>';
                map[tankY][tankX] = '.';
            }else{
                map[tankY][tankX] = '>';
            }
 
        }else if(cmd == 'S'){
            if(map[tankY][tankX] == '^'){
                int temIndex = tankY-1;
                while(true){
                    if(temIndex < 0){
                        return;
                    }else{
                        if(map[temIndex][tankX] == '*'){
                            map[temIndex][tankX] = '.';
                            return;
                        }else if(map[temIndex][tankX] == '#'){
                            return;
                        }
                    }
                    temIndex--;
                }
            }else if(map[tankY][tankX] == '>'){
                int temIndex = tankX+1;
                while(true){
                    if(temIndex > W-1){
                        return;
                    }else{
                        if(map[tankY][temIndex] == '*'){
                            map[tankY][temIndex] = '.';
                            return;
                        }else if(map[tankY][temIndex] == '#'){
                            return;
                        }
                    }
                    temIndex++;
                }
            }else if(map[tankY][tankX] == 'v'){
                int temIndex = tankY+1;
                while(true){
                    if(temIndex > H-1){
                        return;
                    }else{
                        if(map[temIndex][tankX] == '*'){
                            map[temIndex][tankX] = '.';
                            return;
                        }else if(map[temIndex][tankX] == '#'){
                            return;
                        }
                    }
                    temIndex++;
                }
            }else if(map[tankY][tankX] == '<'){
                int temIndex = tankX-1;
                while(true){
                    if(temIndex < 0){
                        return;
                    }else{
                        if(map[tankY][temIndex] == '*'){
                            map[tankY][temIndex] = '.';
                            return;
                        }else if(map[tankY][temIndex] == '#'){
                            return;
                        }
                    }
                    temIndex--;
                }
 
            }else{
                System.out.println("대포가 이상함");
            }
 
        }else{
            System.out.println(cmd + " 명령어 잘못 입력");
        }
    }
 
 
}