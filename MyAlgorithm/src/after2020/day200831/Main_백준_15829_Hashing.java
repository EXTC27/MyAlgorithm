package after2020.day200831;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_백준_15829_Hashing {
	static int N;
	static int r = 31, mod = 1234567891;
	static char[] str;
	static long ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		str = br.readLine().toCharArray();
		
		ans = 0;
		long p = 1;
		for(int i = 0; i < N; i++) {
			ans += ((str[i] - 'a' + 1) * p) % mod;
			p = (p * r) % mod;
		}
				
		bw.write(ans % mod + "");
		
		br.close();
		bw.close();
	}
}
