import java.util.*;
import java.io.*;

public class Main {
    static int R,C;
    static int max = Integer.MIN_VALUE;
    static char[][] board;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static Set<Character> set;

    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;

       st = new StringTokenizer(br.readLine().trim());
       R = Integer.parseInt(st.nextToken());
       C = Integer.parseInt(st.nextToken());
       board = new char[R][C];
       set = new HashSet<>();

       for(int i=0; i<R; i++) {
           String str = br.readLine().trim();
           for(int j=0; j<C; j++) {
               board[i][j] = str.charAt(j);
           }
       }

       dfs(0,0,0);

       System.out.println(max+1);

    }
    
    static void dfs(int row, int col, int count) {
        max = Math.max(max, count);
        set.add(board[row][col]);

        for(int k=0; k<4; k++) {
            int nr = row + dr[k];
            int nc = col + dc[k];

            if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
            if(!set.contains(board[nr][nc])) {
                dfs(nr, nc, count+1);
            }
        }
        set.remove(board[row][col]);
    }

}
