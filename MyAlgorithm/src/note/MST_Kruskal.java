package note;

import java.util.PriorityQueue;

public class MST_Kruskal {

	static int[] parent;
	
	public static void main(String[] args) {
		int[][] arr = {
				{ 0, 67,  0, 28, 17,  0, 12},
				{67,  0,  0, 24, 62,  0,  0},
				{ 0,  0,  0,  0, 20, 37,  0},
				{28, 24,  0,  0,  0,  0, 13},
				{17, 62, 20,  0,  0, 45, 73},
				{ 0,  0, 37,  0, 45,  0,  0},
				{12,  0,  0, 13, 73,  0,  0}
		};
		
		System.out.println("ans:" + kruskal(arr)); //ans: 123
	}

	static int find(int a) {
		if(parent[a] == a) return a;
		else return parent[a] = find(parent[a]);
	}
	static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		if(parentA == parentB) return;
		if(parentA < parentB)  
			parent[b] = parentA;
		else   		           
			parent[a] = parentB;
	}
	static int kruskal(int arr[][]) {
		parent = new int[arr.length];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		
		for(int i = 0; i < arr.length; i++) {
			parent[i] = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i][j] == 0) continue;
				pq.offer(new int[] {arr[i][j], i, j});
			}
		}
		
		int ans = 0;
		while(!pq.isEmpty()) {
			int[] poll = pq.poll();
			int edge = poll[0];
			int x = poll[1];
			int y = poll[2];
			
			if(parent[x] == parent[y]) continue;
			
			union(x, y);
			ans += edge;
		}
		
		return ans;
	}
}
