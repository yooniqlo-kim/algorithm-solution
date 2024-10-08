import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		int maxSafeCnt = 1; // 안전한 영역의 최대 개수
	
		for(int height=1; height<=100; height++) {
			visited = new boolean[N][N];
			int safeCnt = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] > height && !visited[i][j]) {
						bfs(i,j,height);
						safeCnt++;
					}
				}
			}
			maxSafeCnt = Math.max(maxSafeCnt, safeCnt);
		}
		System.out.println(maxSafeCnt);
	}

	private static void bfs(int startR, int startC, int height) {
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0,1,-1};
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {startR, startC});
		visited[startR][startC] = true;
		
		while(!queue.isEmpty()) {
			int[] position = queue.poll();
			int row = position[0];
			int col = position[1];
			
			for(int k=0; k<4; k++) {
				int nr = row + dr[k];
				int nc = col + dc[k];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc] || map[nr][nc] <=height) continue;
				queue.offer(new int[] {nr,nc});
				visited[nr][nc] = true;
			}
		}
			
		
	}
	
	
}
