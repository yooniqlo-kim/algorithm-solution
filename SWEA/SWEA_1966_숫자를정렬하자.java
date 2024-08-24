import java.util.*;
import java.io.*;

public class SWEA_1966_숫자를정렬하자 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());

        for(int t=0; t<10; t++){
            int N = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine().trim());

            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            sb.append("#").append(t+1).append(" ");
            for(int n : arr) sb.append(n).append(" ");
            sb.append("\n");
        }//end testcase
        bw.write(sb.toString());
        bw.close();
        br.close();

    }
}
