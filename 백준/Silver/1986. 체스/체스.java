import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static boolean[][] safeBoard;
	static char[][] board;
	static StringTokenizer st;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine().trim());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	board = new char[N][M];
    	safeBoard = new boolean[N][M];
    	
    	input(br,st,'Q');
    	input(br,st,'K');
    	input(br,st,'P');
    	
    	moveQueen();
    	moveKnight();
    	
    	int cnt = 0;
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			if(!safeBoard[i][j]) cnt++;
    		}
    	}
    	
    	System.out.println(cnt);
    	
    	
    }
    

	private static void input(BufferedReader br, StringTokenizer st, char role) throws Exception  {
    	st = new StringTokenizer(br.readLine().trim());
    	int size = Integer.parseInt(st.nextToken());
    	
    	for(int i=0; i<size; i++) {
    		int r = Integer.parseInt(st.nextToken())-1;
    		int c = Integer.parseInt(st.nextToken())-1;
    		board[r][c] = role;
    		safeBoard[r][c] = true;
    	}
    }
    
    private static void moveQueen() {
    	int[] dr = {0,0,1,-1,1,1,-1,-1}; // 동 서 남 북 남동 남서 북동 북서
    	int[] dc = {1,-1,0,0,1,-1,1,-1};
    	
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			if(board[i][j] != 'Q') continue;
    			
    			for(int d=0; d<8; d++) {
    				
    			int idx = 1;
    				while(true) {
    					int nr = i + dr[d] * idx;
    					int nc = j + dc[d] * idx;
    	    		
    					if (nr < 0 || nr >= N || nc < 0 || nc >= M || 
    							board[nr][nc] == 'P' || board[nr][nc] == 'Q' || board[nr][nc] == 'K') break;
    					
    					safeBoard[nr][nc] = true;
    					idx++;
    	    		}
    			}
    		}
    	}
    }
    

    private static void moveKnight() {
		int[] dr = {-2,-2,2,2,-1,-1,1,1};
		int[] dc = {1,-1,1,-1,2,-2,2,-2};
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j] != 'K') continue;
				
				for(int k=0; k<8; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					safeBoard[nr][nc] = true;
					
				}
			}
		}
		
	}
 
}