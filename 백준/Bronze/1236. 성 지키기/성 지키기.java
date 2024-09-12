import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().trim().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		char[][] map = new char[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine().trim();
			for(int j=0; j<M; j++)
				map[i][j] = s.charAt(j);
		}
	
		int rowCnt = 0;
		
		for(int i=0; i<N; i++) {
			boolean isX=false;
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'X') {
					isX = true;
					break;
				}
			}	
			if(!isX) rowCnt++;
		}
		
		int colCnt = 0;
		for(int j=0; j<M; j++) {
			boolean isX = false;
			for(int i=0; i<N; i++) {
				if(map[i][j]=='X') {
					isX = true;
					break;
				}
			}
			if(!isX) colCnt++;
		}
		System.out.println(Math.max(rowCnt, colCnt));
	} // end main
	
}
