package _2020;

import java.io.*;
import java.util.*;

//BFS
public class Solution_D4_1868_파핑파핑지뢰찾기 {
	static int T, N, cnt, ans;
	static char[][] arr;
	
	static Queue<int[]> queue;
	static boolean[][] visit;
	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	static int[] dy = {1,1,0,-1,-1,-1,0,1};
	
	static void pre_process() {
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[0], y = poll[1];
			
			for(int n = 0; n < 8; n++) {
				int nx = x + dx[n];
				int ny = y + dy[n];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(arr[nx][ny] == '.') {
						arr[nx][ny] = '#';
						ans++;
					}
				}
			}
		}
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[0], y = poll[1];
			
			if(visit[x][y]) continue;
			
			visit[x][y] = true;
			
			for(int k = 0; k < 8; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) { 
					if(arr[nx][ny] == '.' && !visit[nx][ny]) {
						queue.offer(new int[] {nx, ny});
					}
					else if(arr[nx][ny] == '#'){
						arr[nx][ny] = '@';
						ans--;
					}
				}
			}
		}
		ans++;
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution_D4_1868_파핑파핑지뢰찾기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			ans = 0;
			queue = new LinkedList<int[]>();
			visit = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				arr[i] = br.readLine().toCharArray();
				for(int j = 0; j < N; j++) {
					if(arr[i][j] == '*') {
						queue.offer(new int[] {i, j});
					}
				}
			}
			pre_process();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] == '.' && !visit[i][j]) {
						queue.offer(new int[] {i, j});
						bfs();
					}
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		br.close();
	}
	
}
