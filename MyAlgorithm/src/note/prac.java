package note;
import java.math.BigInteger;
import java.util.*;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class prac {
	
	public static void main(String[] args) {
		
		long cnt = 1;
		for(long i = 50000; i > 25000; i--) {
			cnt *= i / (i - 25000);
		}
		System.out.println(cnt);
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		BigInteger bigInteger;
		
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

