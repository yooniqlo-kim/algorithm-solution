import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine().trim());
    	int N = Integer.parseInt(st.nextToken());
    	int money = Integer.parseInt(st.nextToken());
    	
    	int[] dp = new int[money+1];
    	int[] coins = new int[N];
    	for(int i=0; i<N; i++)
    		coins[i] = Integer.parseInt(br.readLine().trim());
    	
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0]=0;
    	for(int i=1; i<=money; i++) {
    		for(int coin : coins) {
    			if(i>=coin && dp[i-coin]!=Integer.MAX_VALUE)
    				dp[i] = Math.min(dp[i], dp[i-coin]+1);
    		}
    	}
    	dp[money] = dp[money]==Integer.MAX_VALUE? -1 : dp[money];
    	System.out.println(dp[money]);
    }
}