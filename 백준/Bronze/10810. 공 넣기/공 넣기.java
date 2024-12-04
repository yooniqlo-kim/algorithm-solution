import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int t=0; t<M; t++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;
            int k = Integer.parseInt(st.nextToken());

            for(int idx=i; idx<=j; idx++) {
                arr[idx] = k;
            }
        }

        for(int i=0; i<N; i++) {
            System.out.print(arr[i] + " ");
        }
    } //end main

}
