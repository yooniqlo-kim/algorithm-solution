import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine().trim());
      
      for(int t=1; t<=T; t++) {
    	  StringTokenizer st = new StringTokenizer(br.readLine().trim());
    	  M = Integer.parseInt(st.nextToken()); // 열
    	  N = Integer.parseInt(st.nextToken()); // 행
    	  int K = Integer.parseInt(st.nextToken()); // 배추 개수
    	  map = new int[N][M];
    	  visited = new boolean[N][M];
    	  
    	  for(int i=0; i<K; i++) {
    		  st = new StringTokenizer(br.readLine().trim());
    		  int col = Integer.parseInt(st.nextToken());
    		  int row = Integer.parseInt(st.nextToken());
    		  map[row][col] = 1;
    	  }
    	  
    	  int cnt = 0;
    	  for(int i=0; i<N; i++) {
    		  for(int j=0; j<M; j++) {
    			  if(map[i][j]==1 && !visited[i][j]) {
    				  bfs(i,j);
    				  cnt++;
    			  }	  
    		  }
    	  }
    	  System.out.println(cnt);
      } //end testcase
    }
	private static void bfs(int startR, int startC) {
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0,1,-1};
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {startR, startC});
		visited[startR][startC] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int row = current[0];
			int col = current[1];
			
			for(int k=0; k<4; k++) {
				int nr = row + dr[k];
				int nc = col + dc[k];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != 1 || visited[nr][nc]) continue;
				queue.offer(new int[] {nr,nc});
				visited[nr][nc] = true;
			}
		}
	}
}
