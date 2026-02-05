import java.util.*;
import java.io.*;

public class Main {
	static int[] papers = {5,5,5,5,5};
	static int[][] map;
	static int rst = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<10;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
	}
}