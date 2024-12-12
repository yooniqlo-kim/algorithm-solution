import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static boolean isPeak;

    static int[] dr = {1,-1,0,0,1,1,-1,-1};
    static int[] dc = {0,0,1,-1,1,-1,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    isPeak = true;
                    dfs(i,j);
                    if(isPeak) count++;
                }
            }
        }

        System.out.println(count);
    } //end main

    private static void dfs(int row, int col) {
        visited[row][col] = true;

        for(int k=0; k<8; k++) {
            int nr = row + dr[k];
            int nc = col + dc[k];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

            if(map[row][col] < map[nr][nc]) isPeak=false;

            if(!visited[nr][nc] && map[row][col] == map[nr][nc]){
                dfs(nr,nc);
            }
        }
    }

}
