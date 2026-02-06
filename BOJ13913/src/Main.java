import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] rstArr = new int[100001];
		List<Integer>[] route = new ArrayList[100001];
		for(int i=0;i<100001;i++) {
			route[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < 100001; i++) {
			rstArr[i] = 100001;
		}
		List<Integer> list = new ArrayList<>();
		list.add(N);
		rstArr[N] = 0;
		route[N].add(N);
		int step = 1;
		while (true) {
			int size = list.size();
			for (int i = size - 1; i >= 0; i--) {
				int a = list.remove(i);
				if (a <= 5000) {
					if(rstArr[a*2] == 100001 && a!=0) {
						rstArr[a*2] = step;
						list.add(a * 2);
						route[a*2] = new ArrayList<>(route[a]);
						route[a*2].add(a*2);
					}
				}
				if (a < 100000) {
					if(rstArr[a+1] == 100001) {
						rstArr[a+1] = step;
						list.add(a+1);
						route[a+1] = new ArrayList<>(route[a]);
						route[a+1].add(a+1);
					}
				}
				if (a > 0) {
					if(rstArr[a-1] == 100001) {
						rstArr[a-1] = step;
						list.add(a-1);
						route[a-1] = new ArrayList<>(route[a]);
						route[a-1].add(a-1);
					}
				}
			}
			step++;
			if (rstArr[M] != 100001) { 
				break;
			}
		}

		System.out.println(rstArr[M]);
		for(int i=0;i<route[M].size();i++) {
			System.out.print(route[M].get(i) + " ");
		}

	}

}
