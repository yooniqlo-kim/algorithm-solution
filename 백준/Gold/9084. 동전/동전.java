import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine().trim());
    	
    	for(int t=0; t<T; t++) {
    		int N = Integer.parseInt(br.readLine().trim());
    		int[] coins = new int[N];
    		StringTokenizer st = new StringTokenizer(br.readLine().trim());
    		for(int i=0; i<N; i++)
    			coins[i] = Integer.parseInt(st.nextToken());
    		
    		int money = Integer.parseInt(br.readLine().trim());
    		int[] dp = new int[money+1];
    		
    		dp[0] = 1;
    		for(int i=0; i<N; i++) {
    			for(int j=coins[i]; j<=money; j++) {
    				dp[j] += dp[j-coins[i]];
    			}
    		}
    		System.out.println(dp[money]);
    		
    	} //end testcase
    
    }

	
}