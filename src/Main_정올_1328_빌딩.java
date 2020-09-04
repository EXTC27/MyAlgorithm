package 재활훈련;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_정올_1328_빌딩 {
	static int N, ans;
	static int[] arr;
	static Stack<int[]> stack;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		stack = new Stack<>();
		
		int idx = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken());
			
			if(stack.isEmpty()) {
				stack.push(new int[] {height, i});
				continue;
			}
			
			if(stack.peek()[0] < height) {
				while(!stack.isEmpty()) {
					int[] tmp = stack.pop();
					arr[tmp[1]] = i + 1; 
					if(!stack.isEmpty() && stack.peek()[0] >= height) {
						break;
					}
				}
				stack.push(new int[] {height, i});
				System.out.println(stack);
			}
			else {
				stack.push(new int[] {height, i});
			}
		}
		
//		System.out.println(Arrays.toString(arr));
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}
}
