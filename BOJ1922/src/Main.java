import java.io.*;
import java.util.*;

public class Main {

	static int[] roots;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int cnt=0,rst=0;
		roots = new int[N+1];
		List<Cable> cables= new ArrayList<>();
		StringTokenizer st;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			cables.add(new Cable(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(cables);
		
		for(int i=1;i<=N;i++) {
			roots[i] = i;
		}
		
		for(Cable c : cables) {
			if(find(c.a) != find(c.b)) {
				union(c.a, c.b);
				rst += c.price;
				if(cnt == N-1)break;
			}
		}
		
		
		System.out.println(rst);
	}
	
	
	private static void union(int a, int b) {
		if(find(a) < find(b)) {
			roots[find(b)] = find(a);
		}else {
			roots[find(a)] = find(b);
		}
	}

	private static int find(int a) {
		if(roots[a] == a) return a;
		return find(roots[a]);
	}


	static class Cable implements Comparable<Cable>{
		int a;
		int b;
		int price;
		
		public Cable(int a, int b, int price) {
			this.a = a;
			this.b = b;
			this.price = price;
		}
		@Override
		public int compareTo(Cable o) {
			return this.price - o.price;
		}
	}
	
}

