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
				int tmpD = 0;
				if(dir==1 || dir==0) {
					tmpD =dir + 2;
				} else {
					tmpD =dir - 2;
				}
				
				int nr = row + dr[tmpD];
				int nc = col + dc[tmpD];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M && room[nr][nc]==0)
					queue.offer(new int[] {nr,nc,dir});
				else
					break;
				
				// 뒤쪽 칸이 벽이 아니라면 후진
				// 벽이라면 break
			} else { // 청소되지 않은 빈 칸이 있는 경우

				dir = dir%4-1 < 0 ? 3 : dir%4-1;// 반시계 방향 90도 회전
				
				int nr = row + dr[dir];
				int nc = col + dc[dir];
				
				// 앞 쪽이 청소되지 않은 빈칸이면 한칸 전진
				// 아니라면 현재 내위치 
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
