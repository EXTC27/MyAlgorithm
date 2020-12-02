package _2020;

import java.util.*;

public class Solution_프로그래머스_힙_디스크컨트롤러 {
	
	
	public static int solution(int[][] jobs) {
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
		
		int endTime = 0;
		int len = jobs.length;
		int idx = 0;
		int answer = 0;
		
		while(idx < len || !pq.isEmpty()) {
			while(idx < len && jobs[idx][0] <= endTime) {
				pq.offer(jobs[idx++]);
			}
			
			if(pq.isEmpty()) {
				endTime = jobs[idx][0];
			}
			else {
				int[] poll = pq.poll();
				answer += endTime - poll[0] + poll[1];
				endTime += poll[1];
			}
		}

		return answer/len;
	}
	
	public static void main(String[] args){
		
		int[][] jobs = {{0, 3},{1, 9},{2, 6}};
		System.out.println(solution(jobs));
	}
}
