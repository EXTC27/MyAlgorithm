package _2020;

import java.io.*;
import java.util.*;

//MST Prim
public class Main_백준_1197_최소스패닝트리 {
	static int V, E;
	static ArrayList<Node>[] nodes;
	static Queue<int[]> queue;
	
	static class Node implements Comparable<Node>{
		int to, edge;
		
		Node(int to, int edge){
			this.to = to;
			this.edge = edge;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.edge - o.edge;
		}
	}
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	V = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    	nodes = new ArrayList[V + 1];
    	for(int i = 0; i < nodes.length; i++) {
    		nodes[i] = new ArrayList<>();
    	}
    	
    	for(int i = 0; i < E; i++) {
    		st = new StringTokenizer(br.readLine());
    		int from = Integer.parseInt(st.nextToken());
    		int to = Integer.parseInt(st.nextToken());
    		int edge = Integer.parseInt(st.nextToken());
    		
    		nodes[from].add(new Node(to, edge));
    		nodes[to].add(new Node(from, edge));
    	}
    	
    	System.out.println(prim());
    }
    
    static int prim() {
    	int ans = 0;
    	
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	Queue<Integer> queue = new LinkedList<>();
    	queue.offer(1);
    	boolean[] visit = new boolean[V + 1];
    	while(!queue.isEmpty()) {
    		int from = queue.poll();
    		
    		visit[from] = true;
    		for(Node node : nodes[from]) {
    			if(visit[node.to]) continue;
    			pq.offer(new Node(node.to, node.edge));
    		}
    		
    		while(!pq.isEmpty()){
    			Node poll = pq.poll();
    			if(visit[poll.to]) continue;
    			queue.offer(poll.to);
    			ans += poll.edge;
    			break;
    		}
    	}
    	
    	return ans;
    }
}