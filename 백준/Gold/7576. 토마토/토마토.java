import java.util.*;
import java.beans.Visibility;
import java.io.*;

public class Main {
	static int M, N,day;
	static int[][] tomatoes;
	static boolean[][] visited;
	static Queue<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		tomatoes = new int[N][M];
		visited = new boolean[N][M];
		queue = new ArrayDeque<>();
		day = -1;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=0; j<M; j++) {
				tomatoes[i][j]= Integer.parseInt(st.nextToken());
				if(tomatoes[i][j]==1)
					queue.offer(new int[] {i,j});
			}
		}
		
		bfs();
		
		if(findUnripeTomato()) {
			day = -1;
		}
		
		
		System.out.println(day);

	} // end main

	private static boolean findUnripeTomato() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(tomatoes[i][j]==0) {
					return true;
				}
			}
		}
		return false;
	}

	private static void bfs() {
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0,1,-1};
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			
			for(int i=0; i<size; i++) {
				int[] current = queue.poll();
				int row = current[0];
				int col = current[1];
				
				for(int k=0; k<4; k++) {
					int nr = row + dr[k];
					int nc = col + dc[k];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M || tomatoes[nr][nc]!=0 || visited[nr][nc]) continue;
					queue.offer(new int[] {nr,nc});
					visited[nr][nc]=true;
					tomatoes[nr][nc]=1;
				}
			}
			day++;
		}
		
	}

}
