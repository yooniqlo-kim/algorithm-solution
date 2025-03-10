import java.util.*;
import java.io.*;

public class Main {
    static int N,M,count;
    static int max = Integer.MIN_VALUE;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;

       st = new StringTokenizer(br.readLine().trim());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       board = new int[N][M];
       visited=new boolean[N][M];

       for(int i=0; i<N; i++) {
           st = new StringTokenizer(br.readLine().trim());
           for(int j=0; j<M; j++) {
               board[i][j] = Integer.parseInt(st.nextToken());
           }
       }

       count=0;
       for(int i=0; i<N; i++) {
           for(int j=0; j<M; j++) {
               if(!visited[i][j] && board[i][j]==1){
                   visited[i][j]=true;
                   max=Math.max(max,dfs(i,j,1));
                   count++;
               }
           }
       }

       if(max==Integer.MIN_VALUE) max=0;
       System.out.println(count);
       System.out.println(max);

    }

    private static int dfs(int row, int col, int cnt) {

        for(int k=0; k<4; k++){
            int nr = row+dr[k];
            int nc = col+dc[k];

            if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc] || board[nr][nc]!=1) continue;

            visited[nr][nc]=true;
            cnt = dfs(nr,nc,cnt+1);
        }

        return cnt;
    }



}
