package note;

import java.util.*;

public class Dijstra {
	static int N = 4;
	static int M = 8;
	static int start = 2;
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
	static int[][] arr; //정점의 개수가 적으면 배열로 만들고 해도되는데 많으면 ArrayList로 만들자 
						//(최대 할당 크기 char: 약 100만, int: 약 25만)
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
		
		System.out.println("ans:" + dijstra(start));
		
		Arrays.fill(dist, 1, dist.length, INF);
		dist[start] = 0;
		
		System.out.println("ans:" + dijstra_pq(start));
	}
	
	static int dijstra(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int from = queue.poll();
			
			for(int i = 1; i <= N; i++) {
				if(i == start || i == from) continue;
				if(dist[i] > dist[from] + arr[from][i]) {
					dist[i] = dist[from] + arr[from][i];
					queue.offer(i);
				}
			}
		}
		
		System.out.println(Arrays.toString(dist));
		
		int ans = 0;
		return ans;
	}
	
	static class Node implements Comparable<Node>{
		int to, weight;
		Node(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static int dijstra_pq(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node poll = pq.poll();
			int from = poll.to;
			int weight = poll.weight;
			
			if(weight > dist[from]) continue;
			
			for(int i = 1; i <= N; i++) {
				if(i == start || i == from) continue;
				if(dist[i] > dist[from] + arr[from][i]) {
					dist[i] = dist[from] + arr[from][i];
					pq.offer(new Node(i, dist[i]));
				}
			}
		}
		
		System.out.println(Arrays.toString(dist));
		
		int ans = 0;
		return ans;
	}

}
