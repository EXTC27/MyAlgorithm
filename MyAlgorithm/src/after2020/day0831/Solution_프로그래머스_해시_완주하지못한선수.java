package after2020.day0831;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Solution_프로그래머스_해시_완주하지못한선수 {

	public boolean solution(String[] phone_book) {
        HashMap<String, String> map = new HashMap<>();		
		
		Arrays.sort(phone_book, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				Integer len1 = o1.length();
				Integer len2 = o2.length();				
				return len1.compareTo(len2);
			}
		});		
		
		for(int i = 0; i < phone_book.length - 1; i++) {
			int len = phone_book[i].length();
			for(int j = i; j < phone_book.length; j++) {
				String tmp = phone_book[j].substring(0, len);
				if(!map.isEmpty() && map.getOrDefault(phone_book[i], "").equals(tmp)) {
					return false;
				}
				map.put(tmp, tmp);
			}
			map.clear();
		}
        
        return true;
    }

}
