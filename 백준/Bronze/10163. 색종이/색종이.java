import java.util.*;
import java.io.*;

public class Main { 
	public static void main(String[] args) throws Exception{
		
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] grid = new int[1001][1001]; //좌표평면
		int N = Integer.parseInt(br.readLine().trim());

		for(int n=1; n<N+1; n++) { 
			
			st = new StringTokenizer(br.readLine().trim());
			int startX = Integer.parseInt(st.nextToken()); //색종이 시작점의 X좌표
			int startY = Integer.parseInt(st.nextToken()); //색종이 시작점의 Y좌표
			int width = Integer.parseInt(st.nextToken()); //색종이 가로 길이
			int height = Integer.parseInt(st.nextToken()); //색종이 세로 길이
			
			for(int x=startX; x<startX+width; x++) {
				for(int y=startY; y<startY+height; y++) {
					grid[x][y] = n; //색종이가 차지하는 좌표평면에 n을 기록 (n번 색종이)
				}
			}
		}
		
		for(int n=1; n<N+1; n++) { 
			int cnt = 0;
		for(int x=0; x<grid.length; x++) {
			for(int y=0; y<grid[x].length; y++) {
				
					if(grid[x][y] == n) { //n번 색종이가 차지하는 영역을 센다
						cnt++;
					}
				}
			}
		System.out.println(cnt);
		}
		
	

	}// end main

} //end class

