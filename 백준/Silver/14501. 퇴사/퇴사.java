import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 퇴사까지 남은 기간

        int[] days = new int[N]; // 상담에 걸리는 시간
        int[] price = new int[N]; // 상담 수익
        int[] dp = new int[N+1];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            days[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {

            int nextDay = i+days[i];
            if(nextDay <= N) {
                dp[nextDay] = Math.max(dp[nextDay], dp[i]+price[i]);
            }

            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[N]);
    }
}
