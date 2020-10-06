package _2020._1006;

import java.io.*;
import java.util.*;

//해시
public class Solution_D4_4261_빠른휴대전화키패드 {
	static int T, N, ans;
	static char[] S;
	static char[][] words;
	static HashMap<Character, Character> HM;
	
	static void initHM() {
		HM = new HashMap<>();
		char num = '2';
		for(int i = 'a'; i <= 'z'; i++) {
			if(i == 'd' || i == 'g' || i == 'j' || i == 'm' || i =='p' || i == 't' || i == 'w')
				num++;
			HM.put((char)i, num);
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution_D4_4261_빠른휴대전화키패드.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S = st.nextToken().toCharArray();
			N = Integer.parseInt(st.nextToken());
			String[] tmp = br.readLine().split(" ");
			
			initHM();
			ans = 0;
			
			loop: for(int n = 0; n < N; n++) {
				char[] word = tmp[n].toCharArray();
				for(int i = 0; i < tmp[n].length(); i++) {
					if(HM.get(word[i]) != S[i]) {
						continue loop;
					}
				}
				ans++;
			}
			
			System.out.println("#" + tc + " " + ans);
			
		}
		br.close();
	}
	
}
