import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int rst = 0;
		int maxIdx=-1;
		int maxNum=-1;
		int maxSum=-1;
		StringTokenizer st=null;
		int[] arr = new int[N+1];
		int[] memo = new int[N+1];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[N] = Integer.parseInt(st.nextToken());
		memo[0] = -1;
		memo[1] = arr[0] * arr[1] * arr[2];
		memo[N] = -1;
		
		if(N<=2) {
			rst=1;
			for(int i=0;i<N;i++) {
				rst *= arr[i];
			}
			System.out.println(rst);
			return;
		}
		for(int i=2;i<N;i++) {
			memo[i] = memo[i-1]/arr[i-2]*arr[i+1];
		}

		for(int k=0;k<N-1;k++) {
			for(int i=1;i<N;i++) {
				if(arr[i]>maxNum ) {
					maxNum = arr[i];
					maxIdx = i;
				}if(arr[i]==maxNum && memo[i] < maxSum) {
					maxIdx=i;
				}
			}
			rst+= memo[maxIdx];
			int leftIdx=maxIdx-1;
			int rightIdx = maxIdx+1;
			while(true) {
				if(arr[leftIdx] != -1)break;
				leftIdx--;
			}
			while(true) {
				if(arr[rightIdx] != -1)break;
				rightIdx++;
			}
			memo[leftIdx] /= arr[maxIdx];
			memo[leftIdx] *= arr[rightIdx];
			memo[rightIdx] /= arr[maxIdx];
			memo[rightIdx] *= arr[leftIdx];
			arr[maxIdx] = -1;
			maxNum=-1;
			maxIdx=-1;
			maxSum=-1;
		}
		
		System.out.println(rst);
	
	}
}
