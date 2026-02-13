import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			System.out.println(check(br.readLine(), true));
		}
	}

	private static int check(String str, boolean first) {
		
		int head = 0;
		int tail = str.length() - 1;
		while (tail > head) {
			if (str.charAt(head) != str.charAt(tail) && first) {
				if(check(str.substring(head+1, tail+1), false)==0 || check(str.substring(head, tail), false)==0) {
					return 1;
				}else {
					return 2;
				}
			}
			if(str.charAt(head) != str.charAt(tail) && !first) {
				return 2;
			}
			head++;
			tail--;
		}
		return 0;
	}
}