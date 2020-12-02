package _2020;

public class Solution_프로그래머스_2020카카오블라인드_자물쇠와열쇠 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
		int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
		
		System.out.println(solution(key, lock));
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        int M = key.length;
        int N = lock.length;
        
//        printArr(rotateKey(key, M));
        
        int[][] rotatedArr = key.clone();
        loop: for(int r = 0; r < 4; r++) { //회전
        	
        	for(int i = -1*(M - 1); i < N; i++) { //이동 시작 점
        		for(int j = -1*(M - 1); j < N; j++) {
        			if(checkKey(rotatedArr, lock, M, N, i, j)) {
        				answer = true;
        				break loop;
        			}        			
        		}
        	}
        	
        	rotatedArr = rotateKey(rotatedArr, M);
        }
        
        
        
        return answer;
    }
	
	static int[][] rotateKey(int[][] key, int M) { //시계방향으로 90도씩 회전
		int[][] outArr = new int[M][M];
				
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < M; j++) {
				outArr[j][M - 1 - i] = key[i][j];
			}
		}
		
		return outArr;
	}
	
	static boolean checkKey(int[][] key, int[][] lock, int M, int N, int startI, int startJ){ //
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++) {
				
				if(lock[i][j] == 0) {
					if (!(i >= startI && i < startI + M && j >= startJ && j < startJ + M))
						return false;
					if(key[i - startI][j - startJ] == 0)
						return false;
				}
				else {
					if (i >= startI && i < startI + M && j >= startJ && j < startJ + M) {
						if(key[i - startI][j - startJ] == 1)
							return false;
					}
				}
				
			}
		}
		
		return true;
	}
	
}
