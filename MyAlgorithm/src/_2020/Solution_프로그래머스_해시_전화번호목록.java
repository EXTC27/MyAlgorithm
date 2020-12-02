package _2020;

import java.util.Stack;

public class Solution_프로그래머스_해시_전화번호목록 {
	public int solution(String s) {
        int answer = 0;
        int N = s.length();
        int min = N;
        Stack<String> stack = new Stack<>();
        for(int i = 1; i <= N / 2 ; i++) {
        	int count = 0;
        	answer = 0;
        	for(int j = 0; j <= N - i; j += i) {
        		String tmp = s.substring(j, i + j);
        		if(!stack.isEmpty()) {
        			if(stack.peek().equals(tmp)) {
        				count++;
        				continue;
        			}
        			else {
        				if(count > 0) {
        					answer += Integer.toString(count + 1).length();
        					count = 0;
        				}
        			}
        		}
        		stack.push(tmp);
        	}
        	
        	if(count > 0) answer += Integer.toString(count + 1).length();
        	if(N % i != 0) answer += N % i;
        	answer += stack.size() * i;
        	
        	min = min < answer ? min : answer;
        	stack.clear();
        }
        return min;
    }
}
