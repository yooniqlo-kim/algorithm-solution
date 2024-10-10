import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static int F,U,D;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		F = Integer.parseInt(st.nextToken()); // 건물의 층
		int S = Integer.parseInt(st.nextToken()); // 강호의 현재 위치
		int G = Integer.parseInt(st.nextToken()); // 목표 위치
		U = Integer.parseInt(st.nextToken()); 
		D = Integer.parseInt(st.nextToken());
		
		visited = new boolean[F+1];
		
		int result = bfs(S,G);
		if(result >= 0) System.out.println(result);
		else System.out.println("use the stairs");
	}
	private static int bfs(int start, int end) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start]=true;
		
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			
			for(int i=0; i<size; i++) {
				int current = queue.poll();
				
				if(current == end) return count; // 목적지에 도착하면 누른횟수를 반환
				
				int up = current+U;
				int down = current-D;
				
				if(up <= F && !visited[up]) {
					queue.offer(up);
					visited[up]=true;
				}
				if(down >= 1 && !visited[down]) {
					queue.offer(down);
					visited[down] = true;
				}
				
			}
			count++;
		}
		return -1;
		
	}


	
	
}
