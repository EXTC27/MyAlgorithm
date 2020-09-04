package after2020;

import java.io.*;
import java.util.*;

public class Main_정올_1092_제곱수출력 {
	static long X, Y;
	static long ans;
	static int mod = 20091024;
	
	static long pow(long x, long y) {
		if(y == 0) {
			return 1;
		}
		if(y % 2 > 0) {
			return(pow(x, y - 1) * x) % mod;
		}
		long half = pow(x, y/2) % mod;
		return (half * half) % mod;
	
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		ans = 1;
		if(X != 0 && Y != 0) {
			ans = pow(X, Y);
		}
		
		System.out.println(ans);
	}

}
