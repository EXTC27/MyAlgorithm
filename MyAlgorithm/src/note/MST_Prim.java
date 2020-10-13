package note;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MST_Prim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {
				{ 0, 67,  0, 28, 17,  0, 12},
				{67,  0,  0, 24, 62,  0,  0},
				{ 0,  0,  0,  0, 20, 37,  0},
				{28, 24,  0,  0,  0,  0, 13},
				{17, 62, 20,  0,  0, 45, 73},
				{ 0,  0, 37,  0, 45,  0,  0},
				{12,  0,  0, 13, 73,  0,  0}
		};
		
		System.out.println("ans:" + prim(arr)); //ans: 123
	}
	
	static int prim(int[][] arr) {
		int ans = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);

		boolean[] visit = new boolean[arr.length];
		while(!queue.isEmpty()) {
			int from = queue.poll();
			visit[from] = true;
			
			for(int to = 0; to < arr.length; to++) {
				if(!visit[to] && arr[from][to] != 0) {
					pq.offer(new int[] {arr[from][to], to});
				}
			}
			while(!pq.isEmpty()) {
				int[] poll = pq.poll();
				int edge = poll[0];
				int vtx = poll[1];
				
				if(visit[vtx]) continue;
				
				queue.offer(vtx);
				ans += edge;
				break;
			}
			
		}
		
		return ans;
	}
}
