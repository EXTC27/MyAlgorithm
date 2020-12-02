package _2020;

import java.util.*;

//이분 탐색
public class Solution_프로그래머스_이분탐색_입국심사 {
	
	public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long right = (long)times[times.length - 1] * (long)n;
        long answer = right;
        
        while(left <= right) {
        	
        	long mid = (left + right) / 2;
        	
        	long cnt = 0;
        	for(int t : times) {
        		cnt += mid / t;
        	}
        	
        	if(cnt < n) {
        		left = mid + 1;
        	}
        	else if(cnt >= n){
        		answer = answer < mid ? answer : mid;
        		right = mid - 1;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args){
		System.out.println(solution (6, new int[] {10, 7}));
	}
}
