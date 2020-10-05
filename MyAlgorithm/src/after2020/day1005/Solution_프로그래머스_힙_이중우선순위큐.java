package after2020.day1005;

import java.util.*;

public class Solution_프로그래머스_힙_이중우선순위큐 {
	
	public static int[] solution(String[] operations) {
		
		int N = operations.length;
		
		PriorityQueue<Integer> ascPQ = new PriorityQueue<>();
		PriorityQueue<Integer> descPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
		
		for(int i = 0; i < N; i++) {
			String[] tmp = operations[i].split(" ");
			if(tmp[0].equals("I")) {
				ascPQ.add(Integer.parseInt(tmp[1]));
				descPQ.add(Integer.parseInt(tmp[1]));
			}
			else {
				if(descPQ.isEmpty()) continue;
				
				if(Integer.parseInt(tmp[1]) == 1) {
					ascPQ.remove(descPQ.poll());
				}
				else {
					descPQ.remove(ascPQ.poll());
				}
			}
		}
		
		int[] answer = new int[2];
		
		if(descPQ.isEmpty()) return answer;
		
		answer[0] = descPQ.poll();
		answer[0] = ascPQ.poll();
		
		return answer;
	}
	
	
	public static void main(String[] args){
		System.out.println(Arrays.toString(solution(new String[] {"I 7"})));
		System.out.println(Arrays.toString(solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
		System.out.println(Arrays.toString(solution(new String[] {"I 7", "I 5", "I -5", "D 1"})));
		System.out.println(Arrays.toString(solution(new String[] {
				"I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", 
				"D 1", "D -1", "D 1", "D -1", 
				"I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", 
				"D 1", "D -1", "D 1", "D -1"})));
	}
}
