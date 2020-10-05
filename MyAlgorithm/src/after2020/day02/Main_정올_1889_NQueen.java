package after2020;

import java.io.*;

public class Main_정올_1889_NQueen {
	static int N;
	static int[] dy = {-1, +1};
	static boolean[] visitY;
	static int[][] arr;
	
	static int ans;
	
	static boolean checkQueen(int x, int y) { //현재 위치에서 왼쪽, 오른쪽 위에 퀸이 있는지 확인
		for(int i = 1; i <= x ; i++) {
			for(int n = 0; n < 2; n++) {
				int ny = y + dy[n]*i;
				
				if(ny >= 0 && ny < N) {
					int nx = x - i; 
					if(arr[nx][ny] == 1) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	static void backtrack(int depth) {
		if(depth == N) {
			ans++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visitY[i] && checkQueen(depth, i)) {
				arr[depth][i] = 1;
				visitY[i] = true;
				backtrack(depth + 1);
				arr[depth][i] = 0;
				visitY[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visitY = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			arr[0][i] = 1;
			visitY[i] = true;
			backtrack(1);
			arr[0][i] = 0;
			visitY[i] = false;
		}
		
		System.out.println(ans);
	}

}
