import java.util.*;
import java.beans.Visibility;
import java.io.*;

public class Main {
	static int M, N,H,day;
	static int[][][] tomatoes;
	static boolean[][][] visited;
	static Queue<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		tomatoes = new int[H][N][M];
		visited = new boolean[H][N][M];
		queue = new ArrayDeque<>();
		day = -1;
		
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int j=0; j<M; j++) {
					tomatoes[h][i][j] = Integer.parseInt(st.nextToken());
					if(tomatoes[h][i][j]==1) 
						queue.offer(new int[] {h,i,j});
				}
			}
		}
		
		bfs();
		
		if(findUnripeTomato()) {
			day = -1;
		}
		
		
		System.out.println(day);

	} // end main

	private static boolean findUnripeTomato() {
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(tomatoes[h][i][j]==0)
						return true;
				}
			}
		}
		return false;
	}

	private static void bfs() {
		int[] dh = {1,-1,0,0,0,0};
		int[] dr = {0,0,1,-1,0,0};
		int[] dc = {0,0,0,0,1,-1};
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				int[] current = queue.poll();
				int height = current[0];
				int row = current[1];
				int col = current[2];
				
				
				for(int k=0; k<6; k++) {
					int nh = height + dh[k];
					int nr = row + dr[k];
					int nc = col + dc[k];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M || nh<0 || nh>=H || tomatoes[nh][nr][nc]!=0 || visited[nh][nr][nc]) continue;
					queue.offer(new int[] {nh,nr,nc});
					visited[nh][nr][nc]=true;
					tomatoes[nh][nr][nc]=1;
				}
			}
			day++;
		}
		
	}

}
