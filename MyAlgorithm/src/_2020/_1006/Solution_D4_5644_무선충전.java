package _2020._1006;

import java.io.*;
import java.util.*;

//완탐
public class Solution_D4_5644_무선충전 {
	static int T, M, A, ans;
	static int[] userMoveA, userMoveB;
	static int[][] userCoorA, userCoorB;
	static int[][] AP;
	static Queue<int[]> queue;
	static int[][][] map;
	static int[] dx = {0,-1,0,1,0};
	static int[] dy = {0,0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution_D4_5644_무선충전.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			userMoveA = new int[M];
			userMoveB = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				userMoveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				userMoveB[i] = Integer.parseInt(st.nextToken());
			}
			
			AP = new int[A][4];
			queue = new LinkedList<int[]>();
			map = new int[10][10][A];
			for(int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				AP[i][0] = Integer.parseInt(st.nextToken()) - 1;
				AP[i][1] = Integer.parseInt(st.nextToken()) - 1;
				AP[i][2] = Integer.parseInt(st.nextToken());
				AP[i][3] = Integer.parseInt(st.nextToken());
				queue.offer(AP[i]);
				initMap(i);
			}
			ans = 0;
			move();
			
			System.out.println("#" + tc + " " + ans);
		}
		br.close();
	}
	
	static void initMap(int idx) {
		boolean[][] visit = new boolean[10][10];
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int range = poll[2];
			
			if(range == -1) {
				queue.clear();
				break;
			}

			int y = poll[0];
			int x = poll[1];
			
			if(visit[x][y]) continue;
			
			visit[x][y] = true;

			int power = poll[3];
			map[x][y][idx] = power;
			
			for(int i = 1; i < 5; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < 10 && ny < 10 
						&& !visit[nx][ny]) {
					queue.offer(new int[] {ny, nx, range - 1, power});
				}
			}
		}
	}
	
	static void move() {

		int[] aa = new int[] {0, 0};
		int[] bb = new int[] {9, 9};
		ans += checkAP(aa, bb);
		
		for(int i = 0; i < M; i++) {
			aa = new int[] {aa[0] + dx[userMoveA[i]], aa[1] + dy[userMoveA[i]]};
			bb = new int[] {bb[0] + dx[userMoveB[i]], bb[1] + dy[userMoveB[i]]};
			ans += checkAP(aa, bb);
		}
	}
	
	static int checkAP(int[] userA, int[] userB) {
		int max = 0;
		int[] powerA = map[userA[0]][userA[1]];
		int[] powerB = map[userB[0]][userB[1]];
		
		for(int i = 0; i < A; i++) {
			for(int j = 0; j < A; j++) {
				if(i == j && powerA[i] == powerB[i]) {
					max = Math.max(max, powerA[i]);
				}
				else {
					max = Math.max(max, powerA[i] + powerB[j]);
				}
			}
		}
		
		return max;
	}
	
}
//public class Solution_D4_5644_무선충전 {
//	static int T, M, A, ans;
//	static int[] userMoveA, userMoveB;
//	static int[][] userCoorA, userCoorB;
//	static int[][] AP;
//	static PriorityQueue<int[]> pq;
//	static ArrayList<int[]>[][] map;
//	static int[] dx = {0,-1,0,1,0};
//	static int[] dy = {0,0,1,0,-1};
//	
//	static void initMap() {
//		map = new ArrayList[10][10];
//		
//		for(int i = 0; i < 10; i++) {
//			for(int j = 0; j < 10; j++) {
//				map[i][j] = new ArrayList<int[]>();
//			}
//		}
//		
//		int idx = 0;
//		while(!pq.isEmpty()) {
//			int[] poll = pq.poll();
//			int y = poll[0];
//			int x = poll[1];
//			int range = poll[2];
//			int power = poll[3];
//			
//			for(int i = -range; i <= range; i++) {
//				for(int j = -range; j <= range; j++) {
//					if(Math.abs(i) + Math.abs(j) <= range && x + i >= 0 && x + i < 10 && y + j >= 0 && y + j < 10) {
//						map[x + i][y + j].add(new int[] {power, idx});
//					}
//				}
//			}
//			idx++;
//		}
//		
//	}
//	
//	static void move() {
//		
//		int[] aa = new int[] {0, 0};
//		int[] bb = new int[] {9, 9};
//		ans += checkAP(aa, bb);
//		
//		//타임라인
//		for(int i = 0; i < M; i++) {
//			aa = new int[] {aa[0] + dx[userMoveA[i]], aa[1] + dy[userMoveA[i]]};
//			bb = new int[] {bb[0] + dx[userMoveB[i]], bb[1] + dy[userMoveB[i]]};
//			
//			ans += checkAP(aa, bb);
//		}
//		
//	}
//	
//	static int checkAP(int[] userA, int[] userB) {
//		int power = 0;
//		int a = 0;
//		int b = 0;
//		
//		if(map[userA[0]][userA[1]].size() > 0) {
//			a = map[userA[0]][userA[1]].get(0)[0];
//		}
//		if(map[userB[0]][userB[1]].size() > 0) {
//			b = map[userB[0]][userB[1]].get(0)[0];
//		}
//		
//		if(a != b) {
//			power = a + b;
//		}
//		else {
//			if(a == 0) return 0;
//			
//			int tmp = 0;
//			int max = 0;
//			
//			for(int[] i : map[userA[0]][userA[1]]) {
//				for(int[] j : map[userB[0]][userB[1]]) {
//					if(i[1] == j[1]) {
//						tmp = i[0];
//					}
//					else {
//						tmp = i[0] + j[0];
//					}
//					max = max > tmp ? max : tmp;
//				}
//			}
//			power = max;
//		}
//		
//		return power;
//	}
//	
//	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/Solution_D4_5644_무선충전.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		T = Integer.parseInt(br.readLine());
//		for(int tc = 1; tc <= T; tc++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			M = Integer.parseInt(st.nextToken());
//			A = Integer.parseInt(st.nextToken());
//			
//			userMoveA = new int[M];
//			userMoveB = new int[M];
//			st = new StringTokenizer(br.readLine());
//			for(int i = 0; i < M; i++) {
//				userMoveA[i] = Integer.parseInt(st.nextToken());
//			}
//			st = new StringTokenizer(br.readLine());
//			for(int i = 0; i < M; i++) {
//				userMoveB[i] = Integer.parseInt(st.nextToken());
//			}
//			
//			AP = new int[A][4];
//			pq = new PriorityQueue<>((o1, o2) -> o2[3] - o1[3]);
//			for(int i = 0; i < A; i++) {
//				st = new StringTokenizer(br.readLine());
//				AP[i][0] = Integer.parseInt(st.nextToken()) - 1;
//				AP[i][1] = Integer.parseInt(st.nextToken()) - 1;
//				AP[i][2] = Integer.parseInt(st.nextToken());
//				AP[i][3] = Integer.parseInt(st.nextToken());
//				pq.offer(AP[i]);
//			}
//			
//			initMap();
//			
//			ans = 0;
//			move();
//			
//			System.out.println("#" + tc + " " + ans);
//		}
//		br.close();
//	}
//	
//}
