package after2020.day200831;

import java.util.Stack;

public class Solution_프로그래머스_2020카카오블라인드_괄호변환 {
	
	public static String solution(String p) {
		String answer = "";
		answer = splitStr(p);
        return answer;
    }
    
    public static String splitStr(String p){
    	if(p.length() == 0) return p;
    	
    	Stack<Character> stack = new Stack<>();
    	char[] chArr = p.toCharArray();
    	int splitIdx = 0;
    	
    	for(int i = 0; i < p.length(); i++) {
    		
    		char tmp = chArr[i];
    		
    		if(stack.isEmpty()) {
    			stack.push(tmp);
    			continue;
    		}
    		
    		if(stack.peek().equals(tmp)) {
    			stack.push(tmp);
    		}
    		else {
    			stack.pop();
    			if(stack.isEmpty()) {
    				splitIdx = i + 1;
    				break;
    			}
    		}
    	}
    	
    	String u = p.substring(0, splitIdx);
    	String v = p.substring(splitIdx, p.length());
    	
    	if(u.toCharArray()[0] == '(') {
    		return u + splitStr(v);
    	}
    	else {
    		u = u.substring(1, u.length() - 1);
    		char[] uChar = u.toCharArray();
    		for(int i = 0; i < uChar.length; i++) {
    			if(uChar[i] == '(') uChar[i] = ')';
    			else uChar[i] = '(';
    		}
    		String empty = "(" + splitStr(v) + ")";
    		u = String.valueOf(uChar);
    		return empty + u;
    	}
    }
}
