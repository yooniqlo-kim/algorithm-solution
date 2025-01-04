import java.util.*;
import java.io.*;

public class Main {
    // 전역 변수 선언
    static int N; // 물건의 개수
    static int K; // 배낭의 최대 무게
    static int[] weight; // 물건들의 무게
    static int[] value;  // 물건들의 가치

    public static void main(String[] args) throws Exception {
        // 입력을 위한 BufferedReader 및 StringTokenizer
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫 번째 줄: N (물건 수), K (최대 무게)
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 배열 초기화 (1-indexed로 사용하기 위해 크기를 N+1로 설정)
        weight = new int[N + 1];
        value = new int[N + 1];

        // 각 물건의 무게와 가치 입력 받기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        // DP 배열 생성 (최대 무게 K까지)
        int[][] dp = new int[N + 1][K + 1];

        // DP 배열 채우기
        for (int i = 1; i <= N; i++) { // i는 현재 고려 중인 물건
            for (int w = 0; w <= K; w++) { // w는 현재 배낭의 허용 무게
                if (weight[i] <= w) {
                    // 물건 i를 배낭에 넣을 수 있는 경우
                    dp[i][w] = Math.max(
                        dp[i - 1][w], // 물건 i를 선택하지 않은 경우
                        dp[i - 1][w - weight[i]] + value[i] // 물건 i를 선택한 경우
                    );
                } else {
                    // 물건 i를 배낭에 넣을 수 없는 경우
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // 결과 출력: dp[N][K]에는 최대 가치가 저장됨
        System.out.println(dp[N][K]);
    }
}
