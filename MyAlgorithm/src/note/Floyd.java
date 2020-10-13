package note;

import java.util.Arrays;

public class Floyd {
	static int N = 4;
	static int M = 8;
	static int INF = 100;
	static int[][] graph = {
			{1, 2, 4},
			{1, 3, 2},
			{1, 4, 7},
			{2, 1, 1},
			{2, 3, 5},
			{3, 1, 2},
			{3, 4, 4},
			{4, 2, 3}
	};
	static int[][] arr;
	static int[][] dist;
	
	public static void main(String[] args) {
		arr = new int[N + 1][N + 1];
		dist = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j) 
					arr[i][j] = dist[i][j] = 0;
				else
					arr[i][j] = dist[i][j] = INF;
			}
		}
		
		for(int i = 0; i < M; i++) {
			int from = graph[i][0];
			int to = graph[i][1];
			int weight = graph[i][2];
			arr[from][to] = dist[from][to] = weight;
		}
		
		System.out.println("ans:" + floyd());
	}
	
	static int floyd() {

		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(i == j || i == k || j == k) continue;
					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.println(Arrays.toString(dist[i]));
		}
		
		int ans = 0;
		return ans;
	}
}
