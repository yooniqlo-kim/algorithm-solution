import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int N,M;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);
    }

    static void dfs(int depth) {
        if(depth==3) {
            spreadVirus();
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void spreadVirus() {
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        int[][] virusMap = copyMap();
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(virusMap[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for(int k=0; k<4; k++) {
                int flagR = row + dr[k];
                int flagC = col + dc[k];

                if(flagR>=0 && flagR<N && flagC>=0 && flagC<M && !visited[flagR][flagC] && virusMap[flagR][flagC] == 0) {
                    queue.offer(new int[]{flagR, flagC});
                    visited[flagR][flagC] = true;
                    virusMap[flagR][flagC] = 2;
                }
            }
        }

        countSafeZone(virusMap);
    }

    static void countSafeZone(int[][] virusMap) {
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(virusMap[i][j] == 0) {
                    count++;
                }
            }
        }

        max = Math.max(count, max);
    }

    static int[][] copyMap() {
        int[][] virusMap = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                virusMap[i][j] = map[i][j];
            }
        }
        return virusMap;
    }
}
