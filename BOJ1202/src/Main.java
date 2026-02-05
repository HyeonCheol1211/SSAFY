import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Jewel[] jewels = new Jewel[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(jewels, (o1, o2) -> o1.weight - o2.weight);

		int[] bags = new int[K];
		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		long rst = 0;
		int jewelIdx = 0;

		for (int i = 0; i < K; i++) {
			while (jewelIdx < N && jewels[jewelIdx].weight <= bags[i]) {
				pq.offer(jewels[jewelIdx].price);
				jewelIdx++;
			}
			
			if (!pq.isEmpty()) {
				rst += pq.poll();
			}
		}

		System.out.println(rst);
	}

	static class Jewel {
		int weight;
		int price;

		public Jewel(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
	}
}