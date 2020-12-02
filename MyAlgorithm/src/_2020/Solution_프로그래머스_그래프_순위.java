package _2020;

public class Solution_프로그래머스_그래프_순위 {
	public static void main(String[] args){
		int n = 5;
		int[][] results = {	{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5} };
		System.out.println(solution(n, results));
	}
	
	public static int solution(int n, int[][] results) {
        int answer = 0;
        char[][] arr = new char[n + 1][n + 1]; //boolean배열을 사용해서 만들수도 있다.
        for(int i = 1; i <= n; i++) {
    		for(int j = 1; j <= n; j++) {
    			if(i == j)
    				arr[i][j] = '0'; //자신과의 싸움은 의미 없으니까 '0'
    			else
    				arr[i][j] = 'N'; //승패를 모를 경우 'N'
    		}
    	}
        
        for(int i = 0; i < results.length; i++) {
        	int x = results[i][0];
        	int y = results[i][1];
        	arr[x][y] = 'W'; //이길 경우 'W'
        	arr[y][x] = 'L'; //질 경우 'L' 
        }
        
        //플로이드워셜을 사용하면 i->k, k->j인 경우 i->j의 승패가 정해진다.
        for(int k = 1; k <= n; k++) {
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= n; j++) {
        			if(k == i || i == j || j == k) continue;
        			if(arr[i][j] != 'N') continue;
        			if(arr[i][k] == 'W' && arr[k][j] == 'W') {
        				arr[i][j] = 'W';
        				arr[j][i] = 'L';
        			}
        		}
        	}
        }
        
        
        loop:for(int i = 1; i <= n; i++) {
    		for(int j = 1; j <= n; j++) {
    			if(arr[i][j] == 'N') continue loop; //배열을 돌면서 승패를 모르면 바로 다음 선수로 넘긴다.
    		}
    		answer++; //무사히 통과했으면 카운트
    	}
        
        return answer;
    }
}
