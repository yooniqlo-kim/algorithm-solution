import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());

            map=new int[n+2][2];
            for(int i=0; i<n+2; i++) {
                st=new StringTokenizer(br.readLine());
                map[i][0]=Integer.parseInt(st.nextToken());
                map[i][1]=Integer.parseInt(st.nextToken());
            }

            if(bfs(n)) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }


    }

    private static boolean bfs(int n) {
        ArrayDeque<int[]> deque=new ArrayDeque<>();
        boolean[] visited = new boolean[n+2];

        int homeX = map[0][0];
        int homeY = map[0][1];
        deque.offerLast(new int[]{homeX, homeY});
        visited[0]=true;

        while(!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int x=current[0];
            int y=current[1];

            for(int i=1; i<n+2; i++) {
                if(!visited[i]) {
                    int distance = Math.abs(x-map[i][0]) + Math.abs(y-map[i][1]);

                    if(distance <= 1000) {
                        deque.offerLast(new int[]{map[i][0], map[i][1]});
                        visited[i]=true;
                    }
                }
            }
        }
        return visited[n+1];
    }

}
