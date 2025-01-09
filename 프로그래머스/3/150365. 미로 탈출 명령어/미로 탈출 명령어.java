import java.util.*;

class Solution {
    static int[] dr = {1,0,0,-1};
    static int[] dc = {0,-1,1,0};
    static char[] direction={'d','l','r','u'};
    static int K,N,M;
    static String answer = null;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        K = k; N = n; M = m;

        int dis = Math.abs(x-r) + Math.abs(y-c);
        if((dis > k) || (k-dis)%2 !=0 ) {
            return "impossible";
        }

        dfs(x,y,r,c, 0, new StringBuilder());
        
        return answer==null? "impossible" : answer;
    }

    static void dfs(int row, int col, int targetR, int targetC, int depth, StringBuilder path) {
        if(answer != null) return;
        
        // 남은 거리가 K보다 큰 경우
        int distance = Math.abs(row-targetR) + Math.abs(col-targetC);
        if(depth+distance > K) return;
        
        if(depth==K) {
            if((row==targetR)  && (col==targetC)) {
                answer = path.toString();
            }
            return;
        }
        
        for(int k=0; k<4; k++) {
            int nr = row + dr[k];
            int nc = col + dc[k];
            
            if(nr<1 || nr>N || nc<1 || nc>M) continue;
            
            path.append(direction[k]);
            dfs(nr,nc,targetR,targetC,depth+1,path);
            path.deleteCharAt(path.length()-1);
        }
    }

}