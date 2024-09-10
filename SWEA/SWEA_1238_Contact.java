import java.util.*;
import java.io.*;

public class SWEA_1238_Contact {
    static int[][] adjMatrix;
    static boolean[] visited;
    static List<Integer> list;
    static final int SIZE = 100;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int t=0; t<10; t++) {
            st = new StringTokenizer(br.readLine().trim());
            int N = Integer.parseInt(st.nextToken()); int start = Integer.parseInt(st.nextToken());
            adjMatrix = new int[SIZE+1][SIZE+1];
            visited = new boolean[SIZE+1];
            list = new ArrayList<>();

            st = new StringTokenizer(br.readLine().trim());
            for(int i=0; i<N/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjMatrix[from][to] = 1;
            } // end input

            bfs(start);
            int max = Collections.max(list);
            sb.append("#").append(t+1).append(" ").append(max).append("\n");
        } // end testcase

        bw.write(sb.toString()); bw.close(); br.close();
    } // end main

    private static void bfs(int start) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start, 0});
        visited[start] = true;
        int level = 0;

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int current = tmp[0]; int currentLevel = tmp[1];

            if(currentLevel > level) {
                level = currentLevel;
                list.clear();
            }
            list.add(current);

            for(int i=1; i<=SIZE; i++) {
                if((!visited[i]) && adjMatrix[current][i] == 1) {
                    queue.offer(new int[] {i,level+1});
                    visited[i] = true;
                }
            }

        } //end while
    }
}
