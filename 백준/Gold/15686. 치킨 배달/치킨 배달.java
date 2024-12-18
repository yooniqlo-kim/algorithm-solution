import java.util.*;
import java.io.*;

public class Main {
    static int N, M, result;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static int[][] city;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 최대 치킨집 개수
        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                city[i][j] = value;
                if (value == 1) house.add(new int[]{i, j});
                else if (value == 2) chicken.add(new int[]{i, j});
            }
        }

        result = Integer.MAX_VALUE;
        visited = new boolean[chicken.size()];

        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int start, int depth) {
        if (depth == M) {
            int sum = 0;
            for (int[] h : house) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < chicken.size(); i++) {
                    if (visited[i]) {
                        int[] c = chicken.get(i);
                        int distance = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                        min = Math.min(distance, min);
                    }
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }
}