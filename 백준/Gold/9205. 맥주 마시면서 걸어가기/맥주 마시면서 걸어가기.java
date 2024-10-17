import java.util.*;
import java.io.*;

public class Main {
	private static final int MAX_DISTANCE = 1000;
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim()); // 테스트케이스
        
        for(int t=1; t<=T; t++) {
            int n = Integer.parseInt(br.readLine().trim()); // 편의점 개수
            int[][] map = new int[n+2][2];
            
            for(int i=0; i<n+2; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[i][0] = x;
                map[i][1] = y;
            }
            
            if(bfs(n,map))
                System.out.println("happy");
            else
                System.out.println("sad");

        } // end testcase
    }

    private static boolean bfs(int n, int[][] map) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+2];
        
        // 상근이네 집
        int homeX = map[0][0];
        int homeY = map[0][1];
        queue.offer(new int[] {homeX,homeY});
        visited[0] = true;

        while(!queue.isEmpty()) {
        	int[] location = queue.poll();
        	int x = location[0];
        	int y = location[1];
        	
        	for(int i=1; i<=n+1; i++) {
        		if(!visited[i]) {
        			int distance = Math.abs(x-map[i][0]) + Math.abs(y-map[i][1]);
        			
        			if(distance <= MAX_DISTANCE) {
        				queue.offer(new int[] {map[i][0], map[i][1]});
        				visited[i] = true;
        			}
        		}
        		}
        	}
        
        return visited[n+1];
        }
        
    
}
