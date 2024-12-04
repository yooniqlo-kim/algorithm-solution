import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int idx=0; idx<N; idx++) {
            arr[idx] = idx+1;
        }

        for(int t=0; t<M; t++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        for(int i=0; i<N; i++) {
            System.out.print(arr[i] + " ");
        }
    } //end main

}
