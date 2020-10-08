package _2020._1007;

import java.util.*;

//이분 탐색
public class Solution_프로그래머스_이분탐색_징검다리 {
	public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        int left = 0;
        int right = distance;
                
        while(left <= right) {
        	int prevRock = 0; //마지막 바위 인덱스
            int remove = 0;
        	
            int mid = (left + right) / 2;

            for(int i = 0; i < rocks.length; i++) {
        		if(mid > rocks[i] - prevRock) {
        			remove++;
        			if(remove > n) break;
        		}
        		else 
        			prevRock = rocks[i];
        		
        	}
        	
        	if() {
        		
        	}
        	else {
        		
        	}
        }
        		
        
        return answer;
    }
	
	public static void main(String[] args){
		System.out.println(solution (25, new int[] {2, 14, 11, 21, 17}, 2));
	}
}
