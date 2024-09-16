import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine().trim());
    	int[][] map = new int[3][3];
    	int idx = 1; int result = 0;
    	
    	while(idx<=9) {
    		st = new StringTokenizer(br.readLine().trim());
    		int r = Integer.parseInt(st.nextToken())-1;
    		int c = Integer.parseInt(st.nextToken())-1;
    		
    		map[r][c] = N;
    		result = isBingo(r,c,N,map);
    		if(result != 0) break;
    		
    		N = N==2? 1: 2; 
    		idx++;
    	}
    	
    	System.out.println(result);

    }
    
    private static int isBingo(int row, int col, int player,int[][] map) {
		if(map[row][0] == map[row][1] && map[row][0] == map[row][2] && map[row][0] == player) return player;
		if(map[0][col] == map[1][col]  && map[0][col] == map[2][col] && map[0][col] == player) return player;
		if(map[0][0] == map[1][1] && map[0][0] == map[2][2] && map[0][0] == player) return player;
		if(map[0][2] == map[1][1] && map[0][2] == map[2][0] && map[0][2] == player) return player;
		return 0;
    	
	}
}