package _2020._0831;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution_프로그래머스_해시_베스트엘범 {
	public int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
        ArrayList<Integer> ansAL = new ArrayList<>();
        int N = genres.length;
        PriorityQueue<int[]> pq;
        HashMap<String, Integer> totalHM = new HashMap<>();
        HashMap<String, PriorityQueue<int[]>> infoHM = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
        	if(totalHM.getOrDefault(genres[i], 0) == 0) {
        		pq = new PriorityQueue<>(new Comparator<int[]>() {
        			@Override
        			public int compare(int[] o1, int[] o2) {
        				// TODO Auto-generated method stub
                        if(o1[1] == o2[1]){
                            return Integer.compare(o1[0], o2[0]);
                        }
                        else{
                            return Integer.compare(o2[1], o1[1]);    
                        }
        			}
				});
        		infoHM.put(genres[i], pq);
        	}
        	totalHM.put(genres[i], totalHM.getOrDefault(genres[i], 0) + plays[i]);
        	infoHM.get(genres[i]).offer(new int[] {i, plays[i]});
        }
        ArrayList<Integer> list = new ArrayList<>(totalHM.values());
        list.sort(Collections.reverseOrder());
        for(Integer total : list) {
        	for(String key : totalHM.keySet()) {
        		if(totalHM.get(key).intValue() == total.intValue()) {        			
        			for(int i = 0; i < 2; i++) {
        				if(infoHM.get(key).isEmpty()) break;
        				ansAL.add(infoHM.get(key).poll()[0]);
        			}
        		}
        	}
        }
        answer = new int[ansAL.size()];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = ansAL.get(i).intValue();
        }
        return answer;
    }
}
