import java.util.*;
import java.io.*;

public class IM_산책경로 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim()); //테스트케이스

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine().trim());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());// 행 열
            int[][] map = new int[N][M];

            int r=0, c=0, num=1;

            while(num <= N*M){
                map[r][c] = num++;

                r += 2;
                c += 1;

                if(r < 0 || r >= N || c < 0 || c >= M) {
                    r %= N;
                    c %= M;
                }
            }

            sb.append("#").append(t+1).append("\n");
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
        sb.append("\n");
        }//end testcase
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
