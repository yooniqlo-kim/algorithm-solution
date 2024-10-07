import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] adjMatrix;
	static boolean[] visited;
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine().trim());
      N = Integer.parseInt(st.nextToken()); // 정점
      int M = Integer.parseInt(st.nextToken()); // 간선
      
      adjMatrix = new int[N+1][N+1];
      visited = new boolean[N+1];
      
      for(int i=0; i<M; i++) {
    	  st = new StringTokenizer(br.readLine().trim());
    	  int a = Integer.parseInt(st.nextToken());
    	  int b = Integer.parseInt(st.nextToken());
    	  adjMatrix[a][b] = adjMatrix[b][a] = 1; //무방향그래프
      }
      
      int cnt = 0;
      for(int i=1; i<=N; i++) {
    	  if(!visited[i]) {
    		  dfs(i);
    		  cnt ++;
    	  }
      }
      System.out.println(cnt);
    }
	private static void dfs(int current) {
		visited[current] = true;
		
		for(int i=1; i<=N; i++) {
			if(adjMatrix[current][i] == 1 && !visited[i])
				dfs(i);
		}
		
	}
	
}
