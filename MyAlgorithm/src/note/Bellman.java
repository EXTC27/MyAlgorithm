package note;

import java.util.Arrays;

public class Bellman {
	static int N = 3; //정점 개수
	static int M = 4; //간선 개수
	static int start = 1;
	static int INF = 10000;
	static int[][] graph = {
			{1, 2, 4},
			{1, 3, 3},
			{2, 3, -1},
			{3, 1, -2}
	};
	static int[][] arr;
	static int[] dist;
	
	
	public static void main(String[] args) {
		
		arr = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			Arrays.fill(arr[i], 1, arr[i].length, INF);
		}
		for(int i = 0; i < M; i++) {
			int from = graph[i][0];
			int to = graph[i][1];
			int weight = graph[i][2];
			arr[from][to] = weight;
		}
		
		dist = new int[N + 1];
		Arrays.fill(dist, 1, dist.length, INF);
		dist[start] = 0;
		
		System.out.println("ans:" + bellman(start));
	}
	
	static int bellman(int start) {
		
		for(int k = 0; k <= N; k++) { //정점개수+1의 반복을 해준다. 마지막은 음수싸이클이 나오는 경우를 확인하기 위함이다.
			for(int i = 0; i < M; i++) {
				int from = graph[i][0];
				int to = graph[i][1];
				int weight = graph[i][2];
				
				if(dist[to] > dist[from] + weight) { //다익스트라와 같다.
					if(k == N) return -1;
					dist[to] = dist[from] + weight;
				}
			}
		}
		
		System.out.println(Arrays.toString(dist));
		
		int ans = 0;
		return ans;
	}

}
