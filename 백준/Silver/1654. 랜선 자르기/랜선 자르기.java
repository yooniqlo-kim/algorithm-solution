import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine().trim());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] length = new int[K];
        long max = 0;

        for(int i=0; i<K; i++){
            length[i] = Integer.parseInt(br.readLine().trim());
            max = Math.max(max, length[i]);
        }

        max++;
        long min =0, mid=0;

        while(min < max) {
            mid = (min + max)/2;

            long count = 0;
            for(int i=0; i<K; i++) {
                count += (length[i] / mid);
            }

            if(count < N) {
                max = mid;
            } else {
                min = mid+1;
            }
        }

        System.out.println(min-1);
    }
}
