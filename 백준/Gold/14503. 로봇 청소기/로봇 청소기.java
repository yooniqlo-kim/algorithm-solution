import java.util.*;
import java.beans.Visibility;
import java.io.*;

public class Main {
	static int N,M,count;
	static int[][] room;
	static boolean[][] cleaned;
	static int[] dr = {-1,0,1,0}; // 북 동 남 서
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		room = new int[N][M];
		cleaned=new boolean[N][M];
		count = 0;
		
		st = new StringTokenizer(br.readLine().trim());
		int startR = Integer.parseInt(st.nextToken());
		int startC = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=0; j<M; j++) 
				room[i][j] = Integer.parseInt(st.nextToken());
		}
		
		bfs(startR, startC, direction);
		System.out.println(count);
	} // end main

	private static void bfs(int startR, int startC, int direction) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {startR, startC, direction});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int row = current[0];
			int col = current[1];
			int dir = current[2];
			
			if(!cleaned[row][col]) {
				count++;
				cleaned[row][col] = true;
			}
			
			if(checkClean(row, col, dir)) { // 청소되지 않은 빈 칸이 없는 경우
				int tmpD = (dir+6) % 4;
				
				int nr = row + dr[tmpD];
				int nc = col + dc[tmpD];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M && room[nr][nc]==0)
					queue.offer(new int[] {nr,nc,dir});
				else
					break;
			} else { // 청소되지 않은 빈 칸이 있는 경우
				dir = (dir+3) % 4;
				
				int nr = row + dr[dir];
				int nc = col + dc[dir];

				if(nr>=0 && nr<N && nc>=0 && nc<M && room[nr][nc]==0 && !cleaned[nr][nc]) {
					queue.offer(new int[] {nr,nc,dir});
				} else
					queue.offer(new int[] {row,col,dir});
				
			}
			
		}

	}

	private static boolean checkClean(int row, int col, int d) {
		for(int k=0; k<4; k++) {
			int nr = row + dr[k];
			int nc = col + dc[k];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
			if(room[nr][nc] == 0 && !cleaned[nr][nc]) return false; // 아직 청소하지 않은 빈칸이 있는 경우
		}
		return true;
		
	}

}
