import java.util.*;

public class prac {
	
	public static void main(String[] args) {
		
		long cnt = 1;
		for(long i = 50000; i > 25000; i--) {
			cnt *= i / (i - 25000);
		}
		System.out.println(cnt);
			
		
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		
//		pq.offer(1);
//		pq.offer(1);
//		pq.offer(3);
//		pq.offer(4);
//		pq.offer(5);
//		
//		pq.poll();
//		
//		System.out.println(pq.toString());
		
    }
}

