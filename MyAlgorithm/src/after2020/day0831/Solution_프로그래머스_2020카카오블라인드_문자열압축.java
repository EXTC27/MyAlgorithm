package after2020.day0831;

import java.util.HashMap;

public class Solution_프로그래머스_2020카카오블라인드_문자열압축 {
	public String solution(String[] participant, String[] completion) {
        String ans = "";
        HashMap<String, Integer> hm = new HashMap<>();
		for(String key : participant){
	        hm.put(key, hm.getOrDefault(key, 0) + 1);
	    }
        for(String key : completion){
        	hm.put(key, hm.get(key) - 1);           
        }
        for(String key : hm.keySet()) {
        	if(hm.get(key) == 1) {
        		ans = key;
        	}
        }
        return ans;
    }
}
