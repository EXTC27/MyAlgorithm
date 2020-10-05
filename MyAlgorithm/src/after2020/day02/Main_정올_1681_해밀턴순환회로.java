package after2020;

import java.io.*;
import java.util.*;

public class Main_정올_1681_해밀턴순환회로 {
	static int N, ans;
	static int[][] graph;
	static boolean[] visit;
	
	static void dfs(int start, int depth, int sum) {
		if(ans < sum) {
			return;
		}
		if(depth == N - 1) {
			if(graph[start][0] == 0) return;
			ans = ans < sum + graph[start][0] ? ans : sum + graph[start][0];
			return;
		}
		
		for(int j = 1; j < N; j++) {
			if(!visit[j] && graph[start][j] != 0) {
				visit[j] = true;
				dfs(j, depth + 1, sum + graph[start][j]);
				visit[j] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		visit = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MAX_VALUE;
		for(int j = 1; j < N; j++) {
			if(graph[0][j] == 0) continue;
			
			visit[j] = true;
			dfs(j, 1, graph[0][j]);
			visit[j] = false;
		}
		
		System.out.println(ans);
	}
}
