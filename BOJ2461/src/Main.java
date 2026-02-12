import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			Arrays.sort(arr[i]);
		}
		PriorityQueue<Student> pq = new PriorityQueue<>();
		int max=0;
		for(int i=0;i<N;i++) {
			pq.offer(new Student(i, 0, arr[i][0]));
			max = Math.max(max, arr[i][0]);
		}
		int rst = Integer.MAX_VALUE;
		while(true) {
			Student s1 = pq.poll();
			int min = s1.power;
			rst = Math.min(rst, max-min);
			if(s1.index == M-1)break;
			Student s2 = new Student(s1.classNum, s1.index+1, arr[s1.classNum][s1.index+1]);
			max = Math.max(s2.power, max);
			pq.offer(s2);
		}
		System.out.println(rst);
	}
	
	static class Student implements Comparable<Student>{
		int classNum;
		int index;
		int power;
		public Student(int classNum, int index, int power) {
			this.classNum = classNum;
			this.index = index;
			this.power = power;
		}
		@Override
		public int compareTo(Student o) {
			return this.power - o.power;
		}
	}

}