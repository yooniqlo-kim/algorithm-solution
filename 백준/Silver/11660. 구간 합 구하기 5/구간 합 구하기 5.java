import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);
        StringTokenizer st;

        st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken()); int T = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][N];
        int[][] sum = new int[N][N+1];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j=0; j<N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j+1] = sum[i][j] + grid[i][j]; // 누적합
            }
        }

        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine().trim());
            int startR = Integer.parseInt(st.nextToken()); int startC = Integer.parseInt(st.nextToken());
            int endR = Integer.parseInt(st.nextToken()); int endC = Integer.parseInt(st.nextToken());

            int result = 0;
            for(int i=startR-1; i<endR; i++) {
                result += sum[i][endC] - sum[i][startC-1];
            }

            sb.append(result).append("\n");
        }//end t

        bw.write(sb.toString());
        bw.close(); br.close();
    }
}
