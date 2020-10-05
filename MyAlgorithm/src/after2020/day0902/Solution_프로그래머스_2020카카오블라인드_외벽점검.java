package after2020.day0902;

import java.util.*;

public class Solution_프로그래머스_2020카카오블라인드_외벽점검 {
	static int N, MIN;
	static boolean terminate;
	
	static int[] glbWeak;
	static int[] glbDist;
	static int[] combArr;
	static int[] permArr;
	static boolean[] check; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
		int[] weak = new int[] { 1,5,6,10 };
		int[] dist = new int[] { 1,2,3,4 };
		System.out.println(solution(n, weak, dist));
		
		n = 12;
		weak = new int[] {1,3,4,9,10};
		dist = new int[] {3,5,7};
		System.out.println(solution(n, weak, dist));
		
		n = 200;
		weak = new int[] {0, 10};
		dist = new int[] {1, 1};
		System.out.println(solution(n, weak, dist));
		
		n = 200;
		weak = new int[] {0, 10, 50, 80, 120, 160};
		dist = new int[] {1, 10, 5, 40, 30};
		System.out.println(solution(n, weak, dist));
	}

	public static int solution(int n, int[] weak, int[] dist) {
		int answer = -1;
		N = n;
		MIN = n;
		
		glbWeak = weak.clone();
		
		Arrays.sort(dist);
		glbDist = new int[dist.length];
		for(int i = 0; i < dist.length; i++) {
			glbDist[i] = dist[dist.length - 1 - i];
		}
		
		terminate = false;
		for(int r = 1; r <= dist.length; r++) {
			combArr = new int[r];
//			comb(0, 0, r);
			comb(0, 0, 0, r);
		}
		
		if (terminate) answer = MIN;
		
		return answer;
	}
	
	static void comb(int start, int flag, int count, int r) {
		if(terminate) return;
		if(count == r) {
			
			permArr = new int[r];
			perm(0, 0, r);
			
			return;
		}
		
		for(int i = start; i < glbDist.length; i++) {
			if((flag & 1 << i) == 0) {
				combArr[count] = glbDist[i];
				comb(i + 1, flag | 1 << i, count + 1, r);
			}

		}
	}
	
	static void perm(int flag, int count, int r) {
		if(terminate) return;
		if(count == r) {
			int n = glbWeak.length;
			check = new boolean[n];
			
//			System.out.println(Arrays.toString(glbDist));
//			System.out.println(Arrays.toString(glbWeak));
			
			for(int i = 0; i < r; i++) {
				
				int range = combArr[i];
				int startIdx = permArr[i];
				
				for(int j = startIdx; j < startIdx + n; j++) {
					
					if(j >= n) {
						if(glbWeak[j % n] + N > glbWeak[startIdx] + range) {
							break;
						}
					}
					else {
						if(glbWeak[j] > glbWeak[startIdx] + range) {
							break;
						}
					}
					
					if(!check[j % n]) {
						check[j % n] = true;
					}
				}
			}
			
			for(int i = 0; i < n; i++) {
				if(!check[i]) return;
			}
			
			terminate = true;
			MIN = r;
			
			return;
		}
		for(int i = 0; i < glbWeak.length; i++) {
			if((flag & 1 << i) == 0) {
				permArr[count] = i;
				perm(flag | 1 << i, count + 1, r);
			}
		}
	}
	
//	static void comb(int start, int count, int r) {
//		if(terminate) return;
//		if(count == r) {
//			
//			permArr = new int[r];
//			boolean[] visit = new boolean[glbWeak.length];
//			perm(visit, 0, r);
//			
//			return;
//		}
//		
//		for(int i = start; i < glbDist.length; i++) {
//			combArr[count] = glbDist[i];
//			comb(i + 1, count + 1, r);
//		}
//	}
//	
//	static void perm(boolean[] visit, int count, int r) {
//		if(terminate) return;
//		if(count == r) {
//			int n = glbWeak.length;
//			check = new boolean[n];
//			
//			for(int i = 0; i < r; i++) {
//				
//				int range = combArr[i];
//				int startIdx = permArr[i];
//				
//				for(int j = startIdx; j < startIdx + n; j++) {
//					
//					if(j >= n) {
//						if(glbWeak[j % n] + N > glbWeak[startIdx] + range) {
//							break;
//						}
//					}
//					else {
//						if(glbWeak[j] > glbWeak[startIdx] + range) {
//							break;
//						}
//					}
//					
//					if(!check[j % n]) {
//						check[j % n] = true;
//					}
//				}
//			}
//			
//			for(int i = 0; i < n; i++) {
//				if(!check[i]) return;
//			}
//			
//			terminate = true;
//			MIN = r;
//			
//			return;
//		}
//		for(int i = 0; i < glbWeak.length; i++) {
//			if(visit[i]) continue;
//			permArr[count] = i;
//			visit[i] = true;
//			perm(visit, count + 1, r);
//			visit[i] = false;
//		}
//	}

}
