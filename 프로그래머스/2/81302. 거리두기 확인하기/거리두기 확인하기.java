import java.util.*;
import java.io.*;

class Solution {
    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    static char[][] room;
    static boolean[][] visited;
    static final int N=5;
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            answer[i] = 1;
        }
        
        
        for(int i=0; i<N; i++) {
            room = new char[N][N];
            visited = new boolean[N][N];
            
            for(int j=0; j<N; j++) {
                String str = places[i][j];
                
                for(int z=0; z<N; z++) {
                    char c = str.charAt(z);
                    room[j][z]=c;        
                }
            }

            for(int x=0; x<N; x++) {
                for(int y=0; y<N; y++) {
                    if(room[x][y]=='P') {
                        if(!bfs(x,y)) {
                            answer[i]=0;
                            break;
                        }
                    }
                }
                if(answer[i]==0) break;
            }
        }
        
        return answer;
    }
    
    private static boolean bfs(int r, int c) {
        int count = 0;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(new int[]{r,c});
        visited[r][c]=true;
        
        while(!deque.isEmpty()) {
            int[] current = deque.pollLast();
            int row = current[0];
            int col = current[1];
            int dis = Math.abs(row-r) + Math.abs(col-c);
            
            if(dis >0 && dis <=2 && room[row][col]=='P') {
                return false;
            }
            
            for(int k=0; k<4; k++) {
                int nr = row + dr[k];
                int nc = col + dc[k];
                
                if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc] 
                   || room[nr][nc]=='X') continue;
                
                visited[nr][nc]=true;
                if(Math.abs(nr-r) + Math.abs(nc-c) <=2) {
                    deque.offerLast(new int[]{nr,nc});
                }
            }
        }
        
        return true;
    }
}