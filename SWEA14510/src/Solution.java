import java.io.*;
import java.util.*;

public class Solution {
	static int[][] dices = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dices = new int[N][6];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int maxRst=-1;
		
		//첫 주사위의 아래면 선택(6번 반복)
		//첫주사위 옆면 최대값 선택
		//첫 주사위의 아랫면에 따른 윗면 나옴
		//첫 주사위의 윗면 값을 두번째 주사위의 아랫면으로 선택
		for(int i=0;i<6;i++) {
			int rst=0;
			int next[] = calDice(dices[0][i], 0);
			rst += next[1];
			for(int j=1;j<N;j++) {
				next = calDice(next[0], j);
				rst+= next[1];
			}
			maxRst = Math.max(maxRst, rst);
		}
		
		System.out.println(maxRst);
	}

	static int[] calDice(int i, int N) {
		int[] result = new int[2];
		for(int j=0;j<6;j++) {
			if(dices[N][j] == i) {
				if(j==0) {
					result[0] = dices[N][5];
					result[1] = Math.max(dices[N][1], Math.max(dices[N][2], Math.max(dices[N][3], dices[N][4])));
				}else if(j==1) {
					result[0] = dices[N][3];
					result[1] = Math.max(dices[N][0], Math.max(dices[N][2], Math.max(dices[N][4], dices[N][5])));
				}else if(j==2) {
					result[0] = dices[N][4];	
					result[1] = Math.max(dices[N][0], Math.max(dices[N][1], Math.max(dices[N][3], dices[N][5])));				
				}else if(j==3) {
					result[0] = dices[N][1];	
					result[1] = Math.max(dices[N][0], Math.max(dices[N][2], Math.max(dices[N][4], dices[N][5])));			
				}else if(j==4) {
					result[0] = dices[N][2];	
					result[1] = Math.max(dices[N][0], Math.max(dices[N][1], Math.max(dices[N][3], dices[N][5])));				
				}else{
					result[0] = dices[N][0];	
					result[1] = Math.max(dices[N][1], Math.max(dices[N][2], Math.max(dices[N][3], dices[N][4])));			
				}
			}
		}
		return result;
	}

}
