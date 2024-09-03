import java.util.*;
import java.io.*;

public class SWEA_10966_물놀이를가자 {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static Queue<int[]> queue = new ArrayDeque<int[]>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int t=0; t<T; t++) {
			String[] str = br.readLine().trim().split(" ");
			N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]);
			map = new int[N][M]; visited = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				String st = br.readLine().trim();
				
				for(int j=0; j<M; j++) {
					if(st.charAt(j) == 'L') map[i][j] = -1; // 땅이면 표시
					else { // 물이면
						queue.add(new int[] {i,j,0}); // 큐에 추가하고 방문했다고 표시, 물이 시작점이 된다
						visited[i][j] = true;
					}
				}
			} // end input
			bfs();
			
			int sum = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] != 0) sum += map[i][j];
				}
			}
			sb.append("#").append(t+1).append(" ").append(sum).append("\n");
		}//end testcase
		
		bw.write(sb.toString()); bw.close(); br.close();
	}
	
	// 각 물 위치에서 시작하여 상하좌우 탐색하여 땅까지의 거리 계산
	// 방문여부를 체크하며, 물에서 각 땅까지 거리를 map에 저장
	private static void bfs() {

		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int r = tmp[0]; int c = tmp[1]; int distance = tmp[2];
		
			for(int k=0; k<4; k++) {
				int flagR = r + dr[k]; int flagC = c + dc[k];
				
				// 배열의 범위를 벗어나지 않고 방문하지 않았다면
				if(flagR >= 0 && flagR < N && flagC >= 0 && flagC < M && !visited[flagR][flagC]) {
					
					visited[flagR][flagC] = true; // 방문 표시
					map[flagR][flagC] = distance + 1; // 현재 거리 + 1
					queue.offer(new int[] {flagR, flagC, distance+1});
				}
			}
		}
	}
}

	
