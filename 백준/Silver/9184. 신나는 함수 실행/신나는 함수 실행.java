import java.util.*;
import java.io.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int[][][] dp = new int[21][21][21];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a==-1 &&b==-1 &&c==-1)
				break;
			
			int n = 0;
			n +=function(a,b,c);
			
			sb.append("w(").append(a).append(", ")
			.append(b).append(", ").append(c)
			.append(") = ").append(n).append("\n");
		}
		
		
		System.out.println(sb);
		
}
	public static int function(int a, int b, int c) {
		
		if(a>=0&& a<=20&&b>=0&& b<=20&&c>=0&& c<=20&&dp[a][b][c]!=0)
			return dp[a][b][c];
			
		if(a <= 0 || b<=0 || c<=0) 
			return 1;
		
		if (a>20 || b>20 || c>20)
			return dp[20][20][20]=function(20, 20, 20);
		
		if (a<b&&b<c)
			return  dp[a][b][c]=function(a, b, c-1) + function(a, b-1, c-1) - function(a, b-1, c);
		
		
		return dp[a][b][c]=function(a-1, b, c) + function(a-1, b-1, c) + 
					function(a-1, b, c-1) - function(a-1, b-1, c-1);
	}
}