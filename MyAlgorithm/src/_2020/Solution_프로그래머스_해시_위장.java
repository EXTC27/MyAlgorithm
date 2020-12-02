package _2020;

import java.util.HashMap;

public class Solution_프로그래머스_해시_위장 {
	public int solution(String[][] clothes) {
        int N = clothes.length;
		HashMap<String, Integer> hm = new HashMap<>();
		for(int i = 0; i < N; i++) {
			hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
		}
		
		int answer = 1;
		for(String key : hm.keySet()) {
			answer *= hm.get(key) + 1;
		}
		
		return answer - 1;
    }
}
