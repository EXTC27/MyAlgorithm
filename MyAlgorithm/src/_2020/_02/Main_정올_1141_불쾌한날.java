package _2020._02;

import java.io.*;
import java.util.*;

public class Main_정올_1141_불쾌한날 {
	static int N;
	static long ans;
	static long[] arr;
	static Stack<Long> stack;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long tmp = Long.parseLong(st.nextToken());
			while(true) {
				if(stack.isEmpty()) {
					stack.push(tmp);
					break;
				}
				if(stack.peek() > tmp) {
					stack.push(tmp);
					ans += (stack.size() - 1);
					break;
				}
				else {
					stack.pop();
				}
			}
		}
		System.out.println(ans);
	}

}
