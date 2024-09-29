
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int N = Integer.parseInt(st.nextToken()); //동전의 개수
        int money = Integer.parseInt(st.nextToken()); // 가치의 합
        int[] coins = new int[N];
        int[] dp = new int[money+1];
        for(int i=0; i<N; i++)
            coins[i] = Integer.parseInt(br.readLine().trim());
        dp[0] =1;
        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= money; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        System.out.println(dp[money]);
    }
}
