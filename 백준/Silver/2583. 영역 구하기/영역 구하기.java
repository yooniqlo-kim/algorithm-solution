import java.util.*;
import java.io.*;

public class Main {
	static int M,N;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken()); //행
		N = Integer.parseInt(st.nextToken()); //열
		int K = Integer.parseInt(st.nextToken());
		
		map=new int[M][N];
		visited=new boolean[M][N];
		List<Integer> list = new ArrayList<>();
		
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine().trim());
			int startC = Integer.parseInt(st.nextToken());
			int startR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());
			int endR = Integer.parseInt(st.nextToken());
			
			for(int i=startR; i<endR; i++) {
				for(int j=startC; j<endC; j++) 
					map[i][j] = 1;
			}

		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0 && !visited[i][j]) 
					list.add(bfs(i,j));
			}
		}
		
		sb.append(list.size()).append("\n");
		Collections.sort(list);
		for(int num:list)
			sb.append(num).append(" ");
		
		System.out.println(sb.toString());
	}// end main

	private static int bfs(int startR, int startC) {
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0,1,-1};
		int depth = 1;
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {startR,startC});
		visited[startR][startC]=true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int row = current[0];
			int col = current[1];
			
			for(int k=0; k<4; k++) {
				int nr = row + dr[k];
				int nc = col + dc[k];
				
				if(nr<0 || nr>=M || nc<0 || nc>=N || map[nr][nc]!=0 || visited[nr][nc]) continue;
				queue.offer(new int[] {nr,nc});
				visited[nr][nc]=true;
				depth++;
			}
		}
		return depth;
	}

} //end class

