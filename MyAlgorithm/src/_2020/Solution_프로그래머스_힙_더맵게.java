package _2020;

import java.util.*;

public class Solution_프로그래머스_힙_더맵게 {
	
	public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
        	pq.offer(scoville[i]);
        }
        
        int answer = 0;
        while(!pq.isEmpty() && pq.peek() < K) {
        	if(pq.size() == 1) {
        		answer = -1;
        		break;
        	}
        	
        	int poll1 = pq.poll();
        	int poll2 = pq.poll();
        	
        	pq.offer(poll1 + (poll2)*2);
        	answer++;
        }
        
        return answer;
    }
	
	public static void main (String[] args) {
		int[] scoville = {1,2,3,9,10,12};
		int K = 7;
		System.out.println(solution(scoville, K));
	}
}
