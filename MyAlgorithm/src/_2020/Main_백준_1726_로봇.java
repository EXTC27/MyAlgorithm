package _2020;

import java.io.*;
import java.util.*;

public class Main_백준_1726_로봇 {
    static int M, N, ans;
    static int[][] track;
    static int[] start, end;
    static int[] dx = {0,  0, 1, -1}; //동서남북 순서
    static int[] dy = {1, -1, 0,  0};
    static boolean[][][] visit;
    static Queue<int[]> queue;
    
    //반대 방향인지 확인하는 함수
    static boolean isReverse(int a, int b) {
    	return (a == 0 && b == 1) || (a == 1 && b == 0) || (a == 2 && b == 3) || (a == 3 && b == 2);
    }
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(st.nextToken());
    	N = Integer.parseInt(st.nextToken());
    	track = new int[M][N];
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < N; j++) {
    			track[i][j] = Integer.parseInt(st.nextToken());
    		}    		
    	}

    	String[] tmp1 = br.readLine().split(" ");
    	String[] tmp2 = br.readLine().split(" ");
    	start = new int[3];
    	end = new int[3];
    	for(int i = 0; i < 3; i++) {
    		start[i] = Integer.parseInt(tmp1[i]) - 1;
    		end[i] = Integer.parseInt(tmp2[i]) - 1;
    	}
    	
    	queue = new LinkedList<int[]>();
    	queue.offer(new int[] {start[0], start[1], start[2], 0});
    	
    	visit = new boolean[4][M][N];
    	
    	while(!queue.isEmpty()) {
    		int[] poll = queue.poll();
    		int x = poll[0];
    		int y = poll[1];
    		int dir = poll[2];
    		int count = poll[3];
    		
    		if(x == end[0] && y == end[1] && dir == end[2]) {
    			ans = count;
    			break;
    		}
    		
    		//1, 2, 3 이동
    		for(int i = 1; i <= 3; i++) {
    			int nx = x + (dx[dir] * i);
    			int ny = y + (dy[dir] * i);
    			if(nx >= 0 && ny >= 0 && nx < M && ny < N) {
    				if(track[nx][ny] == 0) {
    					if(!visit[dir][nx][ny]) {
    						visit[dir][nx][ny] = true;
    						queue.offer(new int[] {nx, ny, dir, count + 1});
    					}
    				}
    				else break;
    			}
    		}
    		
    		//방향 전환
    		for(int i = 0; i < 4; i++) {
    			if(i == dir) continue;
    			if(!visit[i][x][y]) {
    				visit[i][x][y] = true;
    				
    				int tmp = 1;
    				if(isReverse(i, dir)) {
    					tmp = 2;
    				}
    				queue.offer(new int[] {x, y, i, count + tmp});
    			}
    		}
    	}
    	
    	System.out.println(ans);
    	br.close();
    }
}