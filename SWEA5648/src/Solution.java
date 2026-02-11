import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			List<Atom> list = new ArrayList<>();
			int time = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				list.add(new Atom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			int rst = 0;
			while (time < 4001) {
				move(list);
				rst += explode(list);
				time++;
			}
			sb.append(rst);

			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int explode(List<Atom> list) {
		int rst = 0;
		Map<Atom, Integer> map = new HashMap<>();

		for (Atom a : list) {
			map.put(a, map.getOrDefault(a, 0) + 1);
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			Atom a = list.get(i);
			if (map.get(a) > 1) {
				rst += a.power;
				list.remove(i);
			}
		}
		return rst;
	}

	private static void move(List<Atom> list) {
		for (int i=list.size()-1;i>=0;i--) {
			Atom a = list.get(i);
			if (a.dir == 0)
				a.y += 0.5;
			if (a.dir == 1)
				a.y -= 0.5;
			if (a.dir == 2)
				a.x -= 0.5;
			if (a.dir == 3)
				a.x += 0.5;
			if (a.x < -1000 || a.x > 1000 || a.y < -1000 || a.y > 1000) {
		            list.remove(i);
		        }
		}

	}

	private static class Position {
		double x;
		double y;

		public Position(Atom a) {
			this.x = a.x;
			this.y = a.y;
		}

		@Override
		public boolean equals(Object obj) {
			Position p = (Position) obj;
			return (p.x == this.x) && (p.y == this.y);
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

	private static class Atom {
		double x;
		double y;

		@Override
		public boolean equals(Object obj) {
			Atom o = (Atom) obj;
			return (o.x == this.x) && (o.y == this.y);
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		int dir;
		int power;

		public Atom(int x, int y, int dir, int power) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.power = power;
		}
	}

}
