import java.util.*;
import java.io.*;
import static java.util.stream.Collectors.toList;

public class Main {
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());

        // 입력
        char[][] originGrid = new char[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine().trim();
            for(int j=0; j<M; j++)
                originGrid[i][j] = str.charAt(j);
        }

        // 십자가 시작 지점 찾기
        Queue<Cross> crossQueue = findCross(originGrid, N, M);
        List<Cross> crossList = crossQueue.stream().collect(toList());

        // 새로운 격자판 그려서 기존 격자판과 같은지 비교
        boolean isSame = isSameGrid(originGrid, crossQueue, N, M);

        if(!isSame) System.out.println(-1);
        else {
            sb.append(crossList.size()).append("\n");
            for(int i=0; i<crossList.size(); i++) {
                Cross cross = crossList.get(i);
                sb.append(cross.row).append(" ").append(cross.col).append(" ").append(cross.size).append("\n");
            }
        }
        System.out.println(sb.toString());

    } // end main

    private static boolean isSameGrid(char[][] originGrid, Queue<Cross> crossQueue, int N, int M) {
        // 새로운 격자판 초기화
        char[][] newGrid = new char[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++)
                newGrid[i][j] = '.';
        }

        while(!crossQueue.isEmpty()) {
            Cross cross = crossQueue.poll();
            int r = cross.row - 1;
            int c = cross.col - 1;
            int size = cross.size;

            // 새로운 격자판 그리기
            newGrid[r][c] = '*';
            for(int i=1; i<=size; i++) {

                for(int k=0; k<4; k++) {
                    int nr = r + dr[k] * i;
                    int nc = c + dc[k] * i;

                    newGrid[nr][nc] = '*';
                }
            }
        } //end while

        boolean isSame = true;
        out : for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(originGrid[i][j] != newGrid[i][j]) {
                    isSame = false;
                    break out;
                }
            }
        }
        return isSame;
    }


    private static Queue<Cross> findCross(char[][] grid, int N, int M) {
        Queue<Cross> crossQueue = new ArrayDeque<>();
        // 십자가 찾기
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(grid[i][j] != '*') continue;

                int t = 1;
                out: while(true){

                    for(int k=0; k<4; k++) {
                        int nr = i + dr[k] * t;
                        int nc = j + dc[k] * t;

                        if(nr < 0 || nr >= N || nc < 0 || nc >= M || grid[nr][nc] != '*') {
                            t -= 1;
                            break out;
                        }
                    }
                    t++;
                } // end while

                if(t>=1) {
                    crossQueue.offer(new Cross(i+1, j+1, t));
                }
            }
        }
        return crossQueue;
    }
} //end class

class Cross {
    int row, col, size;

    public Cross(int row, int col, int size) {
        this.row = row;
        this.col = col;
        this.size = size;
    }
}
