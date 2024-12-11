import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int minDiff = Integer.MAX_VALUE;

        int[][] ingredients = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }

        int totalCombination = 1<<N; // 모든 조합의 개수

        for(int i=1; i<totalCombination; i++) {
            int sour = 1;
            int bitter = 0;

            for(int j=0; j<N; j++) { // 재료 순회
                if((i & (1<<j)) > 0) { // 재료가 선택되었다면
                    sour *= ingredients[j][0];
                    bitter += ingredients[j][1];
                }
            }

            int diff = Math.abs(sour - bitter);
            minDiff = Math.min(minDiff, diff);
        }
        System.out.println(minDiff);
    }
}
