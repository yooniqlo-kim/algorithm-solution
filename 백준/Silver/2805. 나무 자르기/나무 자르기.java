import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 상근이가 필요한 나무의 길이

        st = new StringTokenizer(br.readLine().trim());

        int[] trees = new int[N];
        for(int i=0; i<N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int min = 0;
        int max = trees[N-1];

        while(min < max) {
            int mid = (min+max)/2;
            long count = 0;
            
            for(int i=0; i<N; i++) {
                if(mid < trees[i]) {
                    count += (trees[i] - mid);
                }
            }

            if(count < M) {
                max = mid;
            } else {
                min = mid+1;
            }
        }
        System.out.println(min-1);

    }
}
