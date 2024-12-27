import java.util.*;
import java.io.*; 

class Solution {
    public int solution(int[][] board, int[] moves) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int N = board.length;
        
        int answer = 0;
        
        for(int i=0; i<moves.length; i++) {
            int current = 0;
            int col = moves[i]-1;
            
            for(int j=0; j<N; j++) {
                if(board[j][col]!=0) {           
                    current = board[j][col];
                    board[j][col]=0;
                    break;
                }
            }
            
            if(current ==0 ) continue;
            
            if(!queue.isEmpty() && queue.peekLast()==current) {
                queue.pollLast();
                answer+=2;
            } else {
                queue.offerLast(current);
            }
            
        }
        return answer;
    }
}