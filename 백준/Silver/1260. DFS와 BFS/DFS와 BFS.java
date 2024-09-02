import java.util.*;
import java.io.*;

public class Main {
    static int N, E, V; // 노드 수, 간선 수, 시작 노드
    static boolean[] visited; // 노드 방문 여부를 기록하는 배열
    static int[][] adjacencyMatrix; // 그래프의 인접 행렬 표현
    static StringBuilder sb; // 결과 출력을 위한 StringBuilder
    static Queue<Integer> queue; // BFS를 위한 큐
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st; 
        sb = new StringBuilder();
        
        // 입력 처리
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken()); // 노드의 수
        E = Integer.parseInt(st.nextToken()); // 간선의 수
        V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 노드
        
        // 인접 행렬 및 방문 배열 초기화
        adjacencyMatrix = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        
        // 그래프의 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            
            adjacencyMatrix[nodeA][nodeB] = adjacencyMatrix[nodeB][nodeA] = 1; // 양방향 간선
        }
        
        // DFS 수행
        dfs(V);
        sb.append("\n");
        
        // BFS를 위해 방문 배열 초기화
        visited = new boolean[N + 1];
        queue = new LinkedList<>();
        
        // BFS 수행
        bfs(V);
        
        // 결과 출력
        bw.write(sb.toString()); bw.close(); br.close();
    }
    
    // BFS (너비 우선 탐색) 메서드
    private static void bfs(int start) {
        visited[start] = true; // 시작 노드를 방문 처리
        queue.add(start); // 큐에 시작 노드를 추가
        
        while (!queue.isEmpty()) { // 큐가 빌 때까지 반복
            int current = queue.poll(); // 큐에서 노드를 꺼냄
            sb.append(current).append(" "); // 결과에 현재 노드 추가
            
            // 현재 노드와 연결된 모든 노드를 검사
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && adjacencyMatrix[current][i] == 1) { // 연결된 노드 중 방문하지 않은 노드
                    queue.add(i); // 큐에 추가
                    visited[i] = true; // 방문 처리
                }
            }
        }
    }

    // DFS (깊이 우선 탐색) 메서드
    private static void dfs(int start) {
        visited[start] = true; // 현재 노드를 방문 처리
        sb.append(start).append(" "); // 결과에 현재 노드 추가
        
        // 현재 노드와 연결된 모든 노드를 검사
        for (int i = 1; i <= N; i++) { // 인덱스를 1부터 시작 (0은 사용하지 않음)
            if (!visited[i] && adjacencyMatrix[start][i] == 1) { // 연결된 노드 중 방문하지 않은 노드
                dfs(i); // 재귀적으로 다음 노드 탐색
            }
        }
    }
}
