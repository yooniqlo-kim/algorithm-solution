import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int N = Integer.parseInt(st.nextToken()); //행
        int M = Integer.parseInt(st.nextToken()); //열
        int[][] map = new int[N+1][M+1];

        st = new StringTokenizer(br.readLine().trim());
        for(int i=1;i<N+1; i++) map[i][0] = Integer.parseInt(st.nextToken()); //왼쪽가장자리

        st = new StringTokenizer(br.readLine().trim());
        for(int i=1;i<M+1; i++) map[0][i] = Integer.parseInt(st.nextToken()); //위쪽가장자리

        for(int i=1; i<N+1; i++) {
            for(int j=1; j<M+1; j++) {
                map[i][j] = (map[i-1][j] == map[i][j-1]) ? 0 : 1;
            }
        }
        System.out.println(map[N][M]);
    }
}
