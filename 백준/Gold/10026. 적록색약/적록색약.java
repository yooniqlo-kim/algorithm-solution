import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       N = Integer.parseInt(br.readLine().trim());
       grid = new char[N][N];
       visited = new boolean[N][N];

       for(int i=0; i<N; i++) {
           String str = br.readLine().trim();
           for(int j=0; j<N; j++) {
               grid[i][j] = str.charAt(j);
           }
       }

       int nonBlind = 0;
       int blind = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]) {
                    bfs(i, j);
                    nonBlind++;
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(grid[i][j] == 'G')
                    grid[i][j] = 'R';
            }
        }

        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]) {
                    bfs(i, j);
                    blind++;
                }
            }
        }

        System.out.println(nonBlind + " "+ blind);

    } //end main

    private static void bfs(int startR, int startC) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startR,startC});
        visited[startR][startC] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for(int k=0; k<4; k++) {
                int nr = row + dr[k];
                int nc = col + dc[k];

                if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
                if(grid[startR][startC] == grid[nr][nc] && !visited[nr][nc]) {
                    queue.offer(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }




}