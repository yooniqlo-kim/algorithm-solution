import java.util.*;
import java.io.*;

public class SWEA_7465_창용마을무리의개수 {
	static int[][] adjacencyMatrix;
	static boolean[] isVisited;
	static int N,M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken()); // 사람의 수 (정점의 수)
			M = Integer.parseInt(st.nextToken()); // 관계의 수 (간선의 수)
			
			adjacencyMatrix = new int[N+1][N+1];
			isVisited = new boolean[N+1];
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int nodeA = Integer.parseInt(st.nextToken());
				int nodeB = Integer.parseInt(st.nextToken());
				
				adjacencyMatrix[nodeA][nodeB] = adjacencyMatrix[nodeB][nodeA] = 1;
			}
			
			// 몇 개의 무리가 있는지 계산하는 로직
			// 마을에 모든 사람을 탐색하여 무리가 몇 개 존재하는지 찾아내야 함
			int count = 0; //무리의 수
			for(int i=1; i<=N; i++) { // N은 마을에 있는 사람의 수로, 1번부터 N번 사람까지 순서대로 확인
				if(!isVisited[i]) { // i번째 사람이 아직 탐색되지 않았다면, 이 사람은 아직 어떤 무리에도 속하지 않은 상태
					dfs(i); // 이 사람을 중심으로 새로운 무리 찾기 위해 DFS
					count++; // DFS가 끝나면 하나의 무리가 완전히 탐색이 끝나는 것이므로, 카운트 증가
				}
			}

			sb.append("#").append(t+1).append(" ").append(count).append("\n");
		} // end testcase
		
		bw.write(sb.toString()); bw.close(); br.close();
		
		
	}
	
	// V번째 사람과 연결된 모든 사람을 탐색
	// 재귀적으로 연결된 모든 사람을 방문하여, 해당 무리에 속하는 모든 사람들을 isVisited배열에 기록
	// DFS가 끝나면 V번째 사람을 포함한 하나의 무리가 모두 탐색
	private static void dfs(int V) {
		isVisited[V] = true;
		
		for(int i=1; i<=N; i++) {
			if((!isVisited[i])  && adjacencyMatrix[V][i] == 1) dfs(i);
		}
		
	}
}
