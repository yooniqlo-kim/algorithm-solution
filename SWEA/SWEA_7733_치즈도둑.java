import java.util.*;
import java.io.*;

public class SWEA_7733_치즈도둑 {
    static int[][] cheese;
    static boolean[][] isVisited;
    static int N, max;
    static int[] dr = {1, -1, 0, 0}; // 하 상 좌 우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            cheese = new int[N][N];
            int cheeseValueMax = Integer.MIN_VALUE;
            int cheeseValueMin = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    cheese[i][j] = Integer.parseInt(st.nextToken());
                    cheeseValueMax = Math.max(cheeseValueMax, cheese[i][j]);
                    cheeseValueMin = Math.min(cheeseValueMin, cheese[i][j]);
                }
            }

            max = 1;
            for (int day = cheeseValueMin; day <= cheeseValueMax; day++) {
                isVisited = new boolean[N][N];  // 매일 초기화
                int loafCnt = 0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (cheese[i][j] > day && !isVisited[i][j]) {  // 현재 날보다 치즈가 더 맛있고, 방문하지 않았으면
                            bfs(i, j, day);
                            loafCnt++;
                        }
                    }
                }

                max = Math.max(max, loafCnt);
            }
            sb.append("#").append(t + 1).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int i, int j, int day) {
		Queue<Integer> queueR = new LinkedList();
		Queue<Integer> queueC = new LinkedList();
		
		queueR.offer(i); queueC.offer(j); 
        isVisited[i][j] = true;

        while (!queueR.isEmpty()) {
        	int r = queueR.poll(); int c=queueC.poll();

            for (int k = 0; k < 4; k++) {
                int flagR = r + dr[k], flagC = c + dc[k];

                if (flagR >= 0 && flagR < N && flagC >= 0 && flagC < N && !isVisited[flagR][flagC] && cheese[flagR][flagC] > day) {
                	queueR.offer(flagR); queueC.offer(flagC);
                    isVisited[flagR][flagC] = true;
                }
            }
        }
    }
}
