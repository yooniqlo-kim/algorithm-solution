import java.util.*;
import java.io.*;

public class Main {
	static boolean[] visited;
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st  = new StringTokenizer(br.readLine().trim());
       int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
       int K = Integer.parseInt(st.nextToken()); // 동생 위치
       visited = new boolean[100001];
       
       System.out.println(bfs(N,K));
    }

	private static int bfs(int start, int end) {
		Queue<Integer> queue = new ArrayDeque<>();
		visited[start] = true;
		queue.offer(start);
		
		int time = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				int current = queue.poll();
				
				if(current == end) 
					return time;
				
				int walkBefore = current - 1;
				int walkAfter = current + 1;
				int teleport = current * 2;
				
				if(walkBefore >= 0 && walkBefore <=100000 && !visited[walkBefore]) {
					queue.offer(walkBefore);
					visited[walkBefore] = true;
				}
				if(walkAfter >= 0 && walkAfter <=100000 && !visited[walkAfter]) {
					queue.offer(walkAfter);
					visited[walkAfter] = true;
				}
				if(teleport >= 0 && teleport <=100000 && !visited[teleport]) {
					queue.offer(teleport);
					visited[teleport] = true;
				}

			}
			time += 1;
		}
		return -1;
	}
}
