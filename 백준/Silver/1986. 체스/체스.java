import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] safeBoard;
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        safeBoard = new boolean[N][M];
        
        input(br, 'Q');
        input(br, 'K');
        input(br, 'P');
        
        moveQueen();
        moveKnight();
        
        int safeCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!safeBoard[i][j]) {
                    safeCount++;
                }
            }
        }
        
        System.out.println(safeCount);
    }

    private static void input(BufferedReader br, char role) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int size = Integer.parseInt(st.nextToken());

        for (int i = 0; i < size; i++) {
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = role;
            safeBoard[r][c] = true; // 그 자리는 안전하지 않음 (말이 있으므로)
        }
    }

    // Queen의 이동 처리
    private static void moveQueen() {
        int[] dr = {0, 0, 1, -1, 1, 1, -1, -1}; // 동 서 남 북 남동 남서 북동 북서
        int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 'Q') continue;

                for (int d = 0; d < 8; d++) {
                    int idx = 1;
                    while (true) {
                        int nr = i + dr[d] * idx;
                        int nc = j + dc[d] * idx;

                        // 범위 벗어나거나 장애물(다른 말 포함) 만났을 때 중단
                        if (nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 'P' || board[nr][nc] == 'Q' || board[nr][nc] == 'K') {
                            break;
                        }
                        safeBoard[nr][nc] = true; // Queen이 공격할 수 있는 칸은 안전하지 않음
                        idx++;
                    }
                }
            }
        }
    }

    // Knight의 이동 처리
    private static void moveKnight() {
        int[] dr = {-2, -2, 2, 2, -1, -1, 1, 1};
        int[] dc = {1, -1, 1, -1, 2, -2, 2, -2};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 'K') continue;

                for (int k = 0; k < 8; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    safeBoard[nr][nc] = true; // Knight가 이동할 수 있는 칸은 안전하지 않음
                }
            }
        }
    }
}
