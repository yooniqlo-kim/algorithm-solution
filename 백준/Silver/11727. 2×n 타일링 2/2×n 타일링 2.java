import java.util.*;
import java.io.*;

public class Main {
    private static final int N=1001;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] dp = new int[N];

        dp[1]=1;
        dp[2]=3;
        dp[3]=5;

        for(int i=4; i<=n; i++) {
            dp[i] = (2 * dp[i-2] + dp[i-1]) % 10007;
        }

        System.out.println(dp[n]);
    }

}
