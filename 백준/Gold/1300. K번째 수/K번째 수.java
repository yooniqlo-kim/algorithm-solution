import java.util.*;
import java.io.*;

// B[K]=X 라면 X보다 작거나 같은 개수가 7개 있다는 것
// 즉, X보다 크기가 작거나 같은 개수가 K개인 X를 찾는 문제
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int K = Integer.parseInt(br.readLine().trim());

        int min = 1;
        int max = K;

        while(min < max) {
            int mid = (min+max)/2;
            int count = 0;

            for(int i=1; i<=N; i++) {
                count += Math.min(N, mid/i); // 배열 크기를 초과할 수 없다.
            }

            // mid > B[K]
            if(K <= count) { // mid >= X 이므로 max = mid
                max = mid;
            } else { // mid > X 이므로 mid 이전은 더 이상 볼 필요가 없다
                min = mid + 1;
            }
        }

        System.out.println(min);

    }
}
