import java.util.*;
import java.io.*;

public class Main { 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken()); int T = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine().trim());
		int[] num = new int[N];
		int[] sum = new int[N+1];
		
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			sum[i+1] = num[i] + sum[i]; // 누적합 배열
		}
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(sum[end] - sum[start-1]).append("\n");
		}// end testcase
		
		bw.write(sb.toString());
		bw.close(); br.close();
		
	}// end main

} //end class

