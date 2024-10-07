import java.io.*;
import java.util.*;

public class Main {
	static int[][] adjMatrix;
	static boolean[] visited;
	static int N,E,depth;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim()); // 정점의 수
		E = Integer.parseInt(br.readLine().trim()); // 간선의 수
		depth = 0;
		adjMatrix = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjMatrix[a][b] = adjMatrix[b][a] = 1;
		}
		dfs(1,depth);
		System.out.println(depth);
	}
	
	private static void dfs(int current, int d) {
		visited[current] = true;
		
		for(int i=1; i<=N; i++) {
			if(!visited[i] && adjMatrix[current][i]==1) 
				dfs(i, ++depth);
		}
	}
}
