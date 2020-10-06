package _2020._1006;

import java.io.*;
import java.util.*;

//탐욕
public class Solution_D4_4050_재관이의대량할인 {
	static int T, N, ans;
	static Integer[] arr;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution_D4_4050_재관이의대량할인.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new Integer[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			Arrays.sort(arr, (o1, o2) -> o2 - o1);
			for(int i = 0; i < N; i++) {
				if(i % 3 == 2) continue;
				ans += arr[i];
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		br.close();
	}
	
	
}
