import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            int iceCnt = countIcebergs();
            if (iceCnt >= 2) break;  // 두 개 이상의 덩어리로 분리됨
            if (iceCnt == 0) {
                time = 0;  // 모든 빙산이 녹음
                break;
            }
            meltIcebergs(); // 빙산 녹이기
            time++;
        }
        System.out.println(time);
    }

    private static int countIcebergs() {
        visited = new boolean[N][M];
        int iceCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j);
                    iceCnt++;
                }
            }
        }
        return iceCnt;
    }

    private static void bfs(int startR, int startC) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) continue;
                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }

    private static void meltIcebergs() {
        int[][] newMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    int zeroCnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                            zeroCnt++;
                        }
                    }
                    newMap[i][j] = Math.max(map[i][j] - zeroCnt, 0);
                }
            }
        }

        // 새로운 상태로 업데이트
        for (int i = 0; i < N; i++) {
            System.arraycopy(newMap[i], 0, map[i], 0, M);
        }
    }
}
