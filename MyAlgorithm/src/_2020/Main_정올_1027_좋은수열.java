package _2020;

import java.io.*;
import java.util.*;

public class Main_정올_1027_좋은수열 {
	static int N;
	static int[] arr;
	static int[] ans;
	static boolean stop = false;
	
	static void dfs(int n) {
		if(stop) return;
		
		if(n == N) {
			for(int i = 0; i < N; i++) {
				if(arr[i] > ans[i]) return;
				ans[i] = arr[i];
			}
			stop = true;
			return;
		}
		
		roop:for(int i = 1; i <=3; i++) {
			if(i == arr[n - 1]) continue;
			arr[n] = i;
			for(int stride = 2; stride <= (n+1)/2; stride++) {
				int cnt = 0;
				for(int j = 0; j < stride; j++) {
					if(arr[n - j] != arr[n - stride - j]) {
						break;
					}
					cnt++;
				}
				if(cnt == stride) continue roop;
			}
			dfs(n + 1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		arr[0] = 1;
		ans = new int[N];
		Arrays.fill(ans, 3);
		
		dfs(1);
//		System.out.println(Arrays.toString(arr));
		String tmp = "";
		for(int i = 0; i < N; i++) {
			tmp += ans[i];
		}
		
		System.out.println(tmp);
	}
}
