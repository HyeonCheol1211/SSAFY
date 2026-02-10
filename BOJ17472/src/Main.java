import java.util.*;
import java.io.*;

/* 	각 섬들사이의 다리의 최소값을 우선순위 큐에 저장한다.
모든 섬들이 집합을 이룰때까지 짧은 순으로 추가하고, 이미 집합에 포함된 다리들이라면 넘긴다.
연결 불가능일 시 -1
N,M 1 10
N*M 3 100
섬의 개수 2 6
제한시간 1초
섬의 4점을 저장한다.
섬끼리의 다리 길이를 계산한다?
*/

/*
 * 현재 사각형이라고 가정하고 문제를 풀었음.
 * 고쳐야할 부분. => 직사각형이 아닌 경우 범위만으로는 간선을 파악할 수 없음
 * 현재 로직 : 행 또는 열의 겹치는 부분이 있다면 열 또는 행의 차이를 거리로 체크한다.
 * 수정 할 로직 : 행 또는 열 부분에 겹치는 부분이 있다면 겹치는 부분에 대해 하나씩 거리를 탐색하도록 한다.
 * 섬 사이에 다른 섬이 절묘하게 끼어있을수 있다고 판단. u, n 처럼 겹치도록? 그런경우 현재 구현으로는 내섬인지 남의 섬인지 판단이 어려움. 섬마다 번호를 부여해야할 것 같음.
 * 
 */

public class Main {
	static int[] roots;
	static int landNum = 0;
	static PriorityQueue<Bridge> pq = new PriorityQueue<>();
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					if (!visited[i][j]) {
						bfs(i, j, N, M, visited);
					}
				}
			}
		}
		roots = new int[landNum+1];
		for (int i = 0; i < landNum+1; i++) {
			roots[i] = i;
		}


		for (int i = 0; i < N; i++) {
			for (int j =0; j < M; j++) {
				if (map[i][j] != 0) {
					makeEdge(i, j, N, M);
				}
			}
		}

		int rst = 0;
		int cnt = 0;
		while (!pq.isEmpty()) {
			Bridge b = pq.poll();
			if (find(b.a) != find(b.b)) {
				union(b.a, b.b);
				rst += b.length;
				cnt++;
				if (cnt == landNum - 1)
					break;
			}
		}

		if (cnt == landNum - 1) {
			System.out.println(rst);
		} else {
			System.out.println(-1);
		}

	}

	private static void makeEdge(int i, int j, int N, int M) {
		int cLandNum = map[i][j];
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int d = 0; d < 4; d++) {
			int nr = i;
			int nc = j;
			int length=-1;
			while (true) {
				nr += dr[d];
				nc += dc[d];
				length++;
				if(nr>N-1||nr<0||nc>M-1||nc<0||map[nr][nc]==cLandNum)break;
				if(map[nr][nc]!=0) {
					if(length<2) break;
					pq.offer(new Bridge(cLandNum, map[nr][nc], length));
					break;
				}
			}
		}

	}

	private static void union(int a, int b) {
		if (find(a) > find(b)) {
			roots[find(a)] = find(b);
		} else {
			roots[find(b)] = find(a);
		}
	}

	private static int find(int a) {
		if (roots[a] == a)
			return a;
		return find(roots[a]);
	}

	private static class Bridge implements Comparable<Bridge> {
		int a;
		int b;
		int length;

		public Bridge(int a, int b, int length) {
			this.a = a;
			this.b = b;
			this.length = length;
		}

		@Override
		public int compareTo(Bridge o) {
			return this.length - o.length;
		}
	}

	private static void bfs(int i, int j, int n, int m, boolean[][] visited) {
		landNum++;
		Queue<Integer> queue = new LinkedList<>();
		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		queue.offer(i * m + j);
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			int cr = temp / m;
			int cc = temp % m;
			visited[cr][cc] = true;
			map[cr][cc] = landNum;

			for (int k = 0; k < 4; k++) {
				int nr = cr + dr[k];
				int nc = cc + dc[k];
				if (nr > n - 1 || nr < 0 || nc > m - 1 || nc < 0 || visited[nr][nc] || map[nr][nc] == 0)
					continue;
				queue.offer(nr * m + nc);
			}
		}
	}
}