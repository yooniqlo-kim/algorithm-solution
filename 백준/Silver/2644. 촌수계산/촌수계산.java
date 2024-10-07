import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] adjMatrix;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim()); // 정점의 개수
        adjMatrix = new int[N+1][N+1];
        visited = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int start = Integer.parseInt(st.nextToken());  // 시작점 (촌수를 계산할 첫 번째 사람)
        int end = Integer.parseInt(st.nextToken());    // 종료점 (촌수를 계산할 두 번째 사람)

        int M = Integer.parseInt(br.readLine().trim()); // 간선의 개수
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjMatrix[x][y] = adjMatrix[y][x] = 1;  // 양방향 그래프
        }

        int result = bfs(start, end);
        System.out.println(result == -1 ? -1 : result);  // 촌수가 없으면 -1 출력
    }

    private static int bfs(int start, int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        int depth = 0;  // 촌수를 나타내는 변수

        while (!queue.isEmpty()) {
            int size = queue.size();  // 현재 레벨에 있는 노드의 수

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == end) {  // 목표하는 사람을 찾으면 촌수 반환
                    return depth;
                }

                // 현재 노드와 연결된 모든 노드 탐색
                for (int j = 1; j <= N; j++) {
                    if (!visited[j] && adjMatrix[current][j] == 1) {
                        queue.offer(j);
                        visited[j] = true;
                    }
                }
            }
            depth++;  // 한 레벨이 끝날 때마다 촌수 증가
        }

        return -1;  // 두 사람이 연결되어 있지 않으면 -1 반환
    }
}
