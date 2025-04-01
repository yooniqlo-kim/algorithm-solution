import java.util.*;
import java.io.*;

public class Main {
    private static int red = 0;
    private static int green = 1;
    private static int blue = 2;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

       int N = Integer.parseInt(br.readLine().trim());

       int[][] dp = new int[N][3];

       for(int i=0; i<N; i++) {
           st = new StringTokenizer(br.readLine().trim());

           dp[i][red] = Integer.parseInt(st.nextToken());
           dp[i][green] = Integer.parseInt(st.nextToken());
           dp[i][blue] = Integer.parseInt(st.nextToken());
       }

       for(int i=1; i<N; i++) {
           dp[i][red] += Math.min(dp[i-1][green],dp[i-1][blue]);
           dp[i][green] += Math.min(dp[i-1][red],dp[i-1][blue]);
           dp[i][blue] += Math.min(dp[i-1][red],dp[i-1][green]);

       }

        System.out.println(Math.min(Math.min(dp[N-1][red],dp[N-1][green]),dp[N-1][blue]));
    }

}
