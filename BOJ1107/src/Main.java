import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int[] NArr = new int[line.length()];
		for(int i=0;i<line.length();i++) {
			NArr[i] = line.charAt(i) - '0';
		}
		int N = Integer.parseInt(line);
		int M = Integer.parseInt(br.readLine());
		boolean[] numbers = new boolean[10];
		if(M==0) {
			System.out.println(Math.min(Math.abs(N-100), line.length()));
			return;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			numbers[Integer.parseInt(st.nextToken())] = true;
		}
		
		int rst=Math.abs(N-100);
		
		if(M == 10) {
			System.out.println(rst);
			return;
		}
		
		int clickNum = click(numbers, NArr, line.length(), N);
		System.out.println(Math.min(clickNum, rst));
	}

	private static int click(boolean[] numbers, int[] nArr, int length, int N) {
		//numbers == true면 망가진거
		int result=0;
		int flag = 10;
		int firstNonMatchIndex=-1;
		for(int i=0;i<length;i++) {
			if(numbers[nArr[i]]) {
				firstNonMatchIndex = i;
				break;
			}
			result *=10;
			result += nArr[i];
		}
		
		boolean big = false;
		boolean small = false;
		int minNum=-1, maxNum=-1, nextBigNum= -1, nextSmallNum=-1;
		for(int i=0;i<10;i++) {
			if(!numbers[i]) {
				minNum=i;
				break;
			}
		}
		
		for(int i=0;i<10;i++) {
			if(!numbers[9-i]) {
				maxNum=9-i;
				break;
			}
		}
		if(firstNonMatchIndex==-1) {
			return length;
		}
		for(int i = nArr[firstNonMatchIndex]+1;i<10;i++) {
			if(!numbers[i]) {
				big = true;
				nextBigNum = i;
				break;
			}
		}
		
		for(int i=nArr[firstNonMatchIndex]-1;i>=0;i--) {
			if(!numbers[i]) {
				small = true;
				nextSmallNum = i;
				break;
			}
		}
		int bigNum = result;
		int smallNum = result;
		if(big) {
			bigNum *=10;
			bigNum += nextBigNum;
			for(int i=0;i<length-firstNonMatchIndex-1;i++) {
				bigNum *= 10;
				bigNum += minNum;
			}
		}else {
			bigNum = result;
			for(int i=0;i<length+1;i++) {
				bigNum *=10;
				bigNum += minNum;
			}	
			if(bigNum == result) {
				bigNum = -5000000;
			}
		}
		
		if(small) {
			smallNum *=10;
			smallNum += nextSmallNum;
			for(int i=0;i<length-firstNonMatchIndex-1;i++) {
				smallNum *= 10;
				smallNum += maxNum;
			}
		}else {
			smallNum=result;
			for(int i=0;i<length-1;i++) {
				smallNum *=10;
				smallNum += maxNum;
			}
			if(smallNum == result) {
				smallNum = -5000000;
			}
		}
		
		int bigNumDigit = 0;
		int smallNumDigit=0;
		int temp=bigNum;
		while(temp>0) {
			temp/=10;
			bigNumDigit++;
		}
		

		temp = smallNum;
		while(temp>0) {
			temp/=10;
			smallNumDigit++;
		}
		
		return Math.min(Math.abs(bigNum - N)+bigNumDigit, Math.abs(smallNum-N)+smallNumDigit);
	}

}
