package _2020;

import java.io.*;
import java.util.*;

public class Main_정올_1809_탑 {
	static int N;
	static int[] arr;
	static String ans;
	
	static Stack<int[]> stack;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(stack.isEmpty()) {
				stack.push(new int[] {tmp, i+1});
				continue;
			}
			
//			if(stack.peek()[0] > tmp) {
//				arr[i] = stack.peek()[1];
//				stack.push(new int[] {tmp, i+1});
//			}
			if(stack.peek()[0] < tmp) {
				while(true) {
					stack.pop();
					if(stack.isEmpty() || stack.peek()[0] > tmp) break;
				}
			}
			
			if(!stack.isEmpty()) {
				arr[i] = stack.peek()[1];
			}
			stack.push(new int[] {tmp, i+1});
		}
		
		ans = Arrays.toString(arr);
		ans = ans.substring(1, ans.length() - 1);
		ans = ans.replace(",", "");
		System.out.println(ans);
	}
}
