package _2020;

import java.io.*;
import java.util.*;

public class Main_백준_20061_모노미노도미노2 {
	static int N, T, X, Y, score, blocks; 
	static boolean[][] rBoard = new boolean[4][6];
	static boolean[][] bBoard = new boolean[6][4];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		score = blocks = 0;
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());		
			Y = Integer.parseInt(st.nextToken());
			
			stackRight(T, X);
			stackBottom(T, Y);
			
		}
		checkBlock();
		
		System.out.println(score);
		System.out.println(blocks);
		
		br.close();
	}

	static void stackRight(int t, int x) {
		for(int i = 2; i <= 6; i++) {
			if(i == 6) {
				rBoard[x][5] = true;
				if(t == 2) {
					rBoard[x][4] = true;
				}
				else if(t == 3){
					rBoard[x + 1][5] = true;
				}
			}
			else {
				if(t == 3) {
					if(rBoard[x][i] || rBoard[x + 1][i]) {
						rBoard[x][i - 1] = true;
						rBoard[x + 1][i - 1] = true;
						break;
					}
				}
				else {
					if(rBoard[x][i]) {
						rBoard[x][i - 1] = true;
						if(t == 2) rBoard[x][i - 2] = true;
						break;
					}
				}
			}
		}
		
		checkCol();
		
		loop: for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 4; j++) {
				if(rBoard[j][i]) {
					
					for(int l = 0; l < 4; l++) {
						for(int k = 5; k >= 2; k--) {
							rBoard[l][k] = rBoard[l][k - (2 - i)];
						}
						for(int k = 1; k >= i; k--) {
							if(rBoard[l][k]) rBoard[l][k] = false;
						}
					}
					
					break loop;
				}
			}
		}
	}
	
	static void checkCol() {
		loop: for(int i = 2; i < 6; i++) {
			for(int j = 0; j < 4; j++) {
				if(!rBoard[j][i]) continue loop;
			}
			delCol(i);
			score++;
		}
	}
	
	static void delCol(int yIdx) {
		for(int i = yIdx; i >= 0; i--) {
			int cnt = 0;
			for(int j = 0; j < 4; j++) {
				if(i > 0) rBoard[j][i] = rBoard[j][i - 1];
				else rBoard[j][i] = false;
				
				if(!rBoard[j][i]) cnt++;
			}
			if(cnt == 4) break;
		}
	}
	
	static void stackBottom(int t, int y) {
		for(int i = 2; i <= 6; i++) {
			if(i == 6) {
				bBoard[5][y] = true;
				if(t == 2) {
					bBoard[5][y + 1] = true;
				}
				else if(t == 3) {
					bBoard[4][y] = true;
				}
			}
			else {
				if(t == 2) {
					if(bBoard[i][y] || bBoard[i][y + 1]) {
						bBoard[i - 1][y] = true;
						bBoard[i - 1][y + 1] = true;
						break;
					}
				}
				else {
					if(bBoard[i][y]) {
						bBoard[i - 1][y] = true;
						if(t == 3) bBoard[i - 2][y] = true;
						break;
					}
				}
			}
		}
		
		checkRaw();
		
		loop: for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 4; j++) {
				if(bBoard[i][j]) {
					for(int l = 0; l < 4; l++) {
						for(int k = 5; k >= 2; k--) {
							bBoard[k][l] = bBoard[k - (2 - i)][l];
						}
						for(int k = 1; k >= i; k--) {
							if(bBoard[k][l]) bBoard[k][l] = false;
						}
					}
					break loop;
				}
			}
		}
	}
	
	static void checkRaw() {
		loop: for(int i = 2; i < 6; i++) {
			for(int j = 0; j < 4; j++) {
				if(!bBoard[i][j]) continue loop;
			}
			delRaw(i);
			score++;
		}
	}
	
	static void delRaw(int xIdx) {
		for(int i = xIdx; i >= 0; i--) {
			int cnt = 0;
			for(int j = 0; j < 4; j++) {
				if(i > 0) bBoard[i][j] = bBoard[i - 1][j];
				else bBoard[i][j] = false;
				
				if(!bBoard[i][j]) cnt++;
			}
			if(cnt == 4) break;
		}
	}
	
	static void checkBlock() {
		for(int i = 2; i < 6; i++) {
			for(int j = 0; j < 4; j++) {
				if(rBoard[j][i]) blocks++;
				if(bBoard[i][j]) blocks++;
			}
		}
	}
	
}
