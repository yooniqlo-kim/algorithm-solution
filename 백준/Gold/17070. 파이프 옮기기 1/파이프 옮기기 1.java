import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] room;
    static ArrayDeque<int[]> queue;
    static int count = 0;

    public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine().trim());
    room = new int[N][N];

    for(int i=0; i<N; i++) {
        st = new StringTokenizer(br.readLine().trim());
        for(int j=0; j<N; j++) {
            room[i][j] = Integer.parseInt(st.nextToken());
        }
    }
    bfs();
    System.out.println(count);


    }//end main

    static void bfs() {
        queue = new ArrayDeque<>();
        queue.offerLast(new int[]{0,1,0});

        while(!queue.isEmpty()) {
            int[] current = queue.pollLast();
            int row = current[0];
            int col = current[1];
            int direction = current[2]; //0은가로, 1은세로, 2는 대각선

            if(direction==0) {
                moveRight(row,col);
            } else if(direction==1) {
                moveDown(row,col);
            } else {
                moveRight(row,col);
                moveDown(row,col);
            }
            moveAcross(row,col);
        }
    }

    static void moveRight(int row, int col) {
        int dc = col + 1;
        if(dc>=0 && dc<N && room[row][dc]==0) {
            queue.offerLast(new int[]{row,dc,0});
            countEnd(row,dc);
        }
    }

    static void moveDown(int row, int col) {
        int dr = row + 1;
        if(dr>=0 && dr<N && room[dr][col]==0) {
            queue.offerLast(new int[]{dr,col,1});
            countEnd(dr,col);
        }
    }

    static void moveAcross(int row, int col) {
        int right = col + 1;
        int down = row + 1;

        if(right>=0 && right<N && down>=0 && down<N) {
            if(room[row][right]==0 && room[down][col]==0 && room[down][right]==0) {
                    queue.offerLast(new int[]{down,right,2});
                    countEnd(down,right);

            }
        }
    }

    static void countEnd(int row, int col) {
        if(row==(N-1) && col==(N-1))
            count++;
    }


}
