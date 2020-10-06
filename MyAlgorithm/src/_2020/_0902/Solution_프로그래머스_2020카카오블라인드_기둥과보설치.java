package _2020._0902;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_프로그래머스_2020카카오블라인드_기둥과보설치 {

	public static void main(String[] args) {

		int n = 5;
		int[][] build_frame = new int[][] {
				{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}
		};
		
		int[][] arr = solution(n, build_frame);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
		
		n = 5;
		build_frame = new int[][] {
				{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}
		};
		
		arr = solution(n, build_frame);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
	}
	
	static class Node{
		boolean col;
		boolean bar;
		
		Node(){
			this.col = false;
			this.bar = false;
		}
	}
	
	public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        
        ArrayList<int[]> ansAL = new ArrayList<>();
        
        Node[][] arr = new Node[n + 1][n + 1];
        for(int i = 0; i < n + 1; i++) {
        	for(int j = 0; j < n + 1; j++) {
        		arr[i][j] = new Node();
        	}
        }
        
        for(int i = 0;  i < build_frame.length; i++) {
        	
        	int x = build_frame[i][0];
        	int y = build_frame[i][1];
        	int contruct = build_frame[i][2];
        	
    		if(build_frame[i][3] == 1) {
    			
    			if(contruct == 0) {
    				arr[x][y].col = true;
    				if(!checkAll(arr, x, y, build_frame, i)) {
    					arr[x][y].col = false;
    				}
    			}
    			else {
    				arr[x][y].bar = true;
    				if(!checkAll(arr, x, y, build_frame, i)) {
    					arr[x][y].bar = false;
    				}
    			}
				
    		}
    		else {
    			
    			if(contruct == 0) {
    				arr[x][y].col = false;
    				if(!checkAll(arr, x, y, build_frame, i)) {
    					arr[x][y].col = true;
    				}
    			}
    			else {
    				arr[x][y].bar = false;
    				if(!checkAll(arr, x, y, build_frame, i)) {
    					arr[x][y].bar = true;
    				}
    			}
    			
    		}
        }
        
        int idx = 0;
        
        for(int i = 0; i < n + 1; i++) {
        	for(int j = 0; j < n + 1; j++) {
    			if(arr[i][j].col) {
    				ansAL.add(new int[] {i, j, 0});
    			}
    			if(arr[i][j].bar) {
    				ansAL.add(new int[] {i, j, 1});
    			}
        	}
        }
        
        answer = new int[ansAL.size()][3];
        for(int[] val: ansAL) {
        	answer[idx++] = val;
        }
        
        return answer;
    }
	
	
	static boolean checkAll(Node[][] arr, int x, int y, int[][] bf, int idx) {
		
		for(int i = 0; i <= idx; i++) {
			int xx = bf[i][0];
			int yy = bf[i][1];
			
			if(bf[i][2] == 0 && !arr[xx][yy].col) continue;
			if(bf[i][2] == 1 && !arr[xx][yy].bar) continue;
			
			if(bf[i][2] == 0) {
				if(yy == 0) continue;
				if(arr[xx][yy - 1].col) continue;
				if(arr[xx][yy].bar) continue;
				if(xx > 0 && arr[xx - 1][yy].bar) continue;
			}
			else {
				if(yy > 0) {
					if(arr[xx][yy - 1].col) continue;
					if(xx < arr.length - 1 && arr[xx + 1][yy - 1].col) continue;
				}
				if(xx > 0 && xx < arr.length - 1 && arr[xx - 1][yy].bar && arr[xx + 1][yy].bar) continue;
				
			}
			
			return false;
		}
		
		return true;
	}
}
