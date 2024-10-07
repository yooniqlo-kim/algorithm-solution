import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim()); // 지도의 크기
		map = new int[N][N];
		visited = new boolean[N][N];
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String str = br.readLine().trim();
			for(int j=0; j<N; j++) 
				map[i][j] = str.charAt(j)-'0';
		}
		
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					list.add(bfs(i,j));
					count++;
				}		
			}
		}
		
		System.out.println(count);
		Collections.sort(list);
		for(int n : list) System.out.println(n);
	}
	
	private static int bfs(int row, int col) {
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0,1,-1};
		int depth = 1;
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {row,col});
		visited[row][col] = true;
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int r = pos[0];
			int c = pos[1];
			
			for(int k=0; k<4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N || map[nr][nc] == 0 || visited[nr][nc]) continue;
				queue.offer(new int[] {nr,nc});
				visited[nr][nc] = true;
				depth++;
			}
		}
		return depth;
	}
	
	
}
