package _2020._1013;

import java.util.*;

public class Solution_프로그래머스_그래프_가장먼노드 {
	
	public static void main(String[] args){
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(n, edge));
	}
	
	static int INF = 50001;
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<Integer>[] graph =  new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
        	graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edge.length; i++) {
        	int x = edge[i][0];
        	int y = edge[i][1];
        	graph[x].add(y);
        	graph[y].add(x); //양방향 그래프
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 1, dist.length, INF);
        dist[1] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        
        while(!queue.isEmpty()) {
        	int poll = queue.poll();
        	
        	for(int i = 2; i <= n; i++) {
        		if(i == poll) continue;
        		if(!graph[poll].contains(i)) continue;
        		if(dist[i] > dist[poll] + 1) {
        			dist[i] = dist[poll] + 1;
        			queue.offer(i);
        		}
        	}
        }
        
        Arrays.sort(dist);
        int max = dist[n];
        for(int i = n; i > 1; i--) {
        	if(dist[i] < max) break;
        	answer++;
        }
        
        return answer;
    }
}
