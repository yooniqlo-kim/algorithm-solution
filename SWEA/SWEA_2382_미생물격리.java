import java.util.*;
import java.io.*;

public class SWEA_2382_미생물격리 {
    static int[] dr = {-1,1,0,0}; // 상 하 좌 우
    static int[] dc = {0,0,-1,1};
    static Microbe[] edges;
    static int N,K;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/김윤/A075_SWEA_2382_미생물격리.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken()); // 셀 크기
            int M = Integer.parseInt(st.nextToken()); // 격리 시간
            K = Integer.parseInt(st.nextToken()); // 미생물 군집 개수
            edges = new Microbe[K];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken());
                edges[i] = new Microbe(row, col, num, direction, true);
            }

            int idx = 1;

            while (idx <= M) { // 격리 시간만큼 반복
                move(); // 자리 이동
                Arrays.sort(edges); // 미생물 수에 따라 오름차순 정렬
                sameLocation(); // 이동한 위치가 같은 위치일 때 처리
                outOfRange(); // 크기를 벗어나면 미생물/2
                idx++;
            }
            sb.append("#").append(t+1).append(" ").append(calculateNum()).append("\n");
            } // end testcase
        bw.write(sb.toString()); bw.close(); br.close();
        } //end main

        private static void move () {
            for (int i = 0; i < K; i++) {
                if (edges[i].flag) {
                    Microbe edge = edges[i];
                    edge.row += dr[edge.direction - 1];
                    edge.col += dc[edge.direction - 1];
                    edges[i] = edge;
                }
            }
        }

        private static void sameLocation () {
            for (int i = 0; i < K - 1; i++) {

                for (int j = i+1; j < K; j++) {
                    if (edges[i].row == edges[j].row && edges[i].col == edges[j].col && edges[j].flag && edges[i].flag) {
                        edges[j].flag = false;
                        edges[i].direction = edges[j].direction;
                        edges[i].num += edges[j].num;
                    }
                }
            }
        }

        private static void outOfRange() {
            for(int i=0; i< K; i++) {
                if(edges[i].flag) {
                    if(edges[i].row == 0 || edges[i].row == N-1 || edges[i].col == 0 || edges[i].col == N-1) {
                        edges[i].num /= 2;
                        int d = edges[i].direction;
                        if(d==1) edges[i].direction = 2;
                        else if(d==2) edges[i].direction = 1;
                        else if(d==3) edges[i].direction = 4;
                        else if(d==4) edges[i].direction = 3;
                    }
                }
            }
        }

        private static int calculateNum() {
            int sum = 0;
            for(int i=0; i<K; i++) {
                if(edges[i].flag) {
                    sum += edges[i].num;
                }
            }
            return sum;
        }

} // end main class


class Microbe implements Comparable<Microbe>{
    int row,col,num,direction;
    boolean flag;

    public Microbe(int row, int col, int num, int direction, boolean flag) {
        this.row = row;
        this.col = col;
        this.num = num;
        this.direction = direction;
        this.flag = flag;
    }

    @Override
    public int compareTo(Microbe o) {
        return this.num-o.num;
    }
}
