package _2020._1005;

import java.io.*;
import java.util.*;

//완전탐색
public class Solution_D4_4613_러시아국기같은깃발 {
	static int T, N, M, ans;
	static char[][] arr;
	static char[] colors = {'W', 'B', 'R'};
	
	static void recur(int cnl, int startRaw, int cnt) {
		if(cnl == 3) {
			ans = cnt < ans ? cnt : ans;
			return;
		}
		
		int minLen = 0, maxLen = 0;
		
		switch(cnl) {
		case 0:
			minLen = 1;
			maxLen = N - 2;
			break;
		case 1:
			minLen = 1;
			maxLen = N - 1 - startRaw;
			break;
		case 2:
			minLen = N - startRaw;
			maxLen = minLen;
			break;
		}
		
		for(int k = minLen; k <= maxLen; k++) {
			int tmpCnt = 0;
			for(int i = startRaw; i < startRaw + k; i++) {
				for(int j = 0; j < M; j++) {
					if(arr[i][j] != colors[cnl]) {
						tmpCnt++;						
						if(cnt > ans) return;
					}
				}
			}
			recur(cnl + 1, startRaw + k, cnt + tmpCnt);
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution_D4_4613_러시아국기같은깃발.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new char[N][M];
			ans = N * M;
			for(int i = 0; i < N; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			recur(0, 0, 0);
			
			System.out.println("#" + tc + " " + ans);
		}
		br.close();
	}
	
}
