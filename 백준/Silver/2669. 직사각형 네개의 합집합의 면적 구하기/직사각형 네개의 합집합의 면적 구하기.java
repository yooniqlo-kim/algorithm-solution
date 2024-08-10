import java.util.*;
import java.io.*;

public class Main { 
	public static void main(String[] args) throws Exception{
		
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		boolean[][] grid = new boolean[101][101]; 
		
		for(int i=0; i<4; i++) {
			
				st = new StringTokenizer(br.readLine().trim());
				int startX = Integer.parseInt(st.nextToken()); //왼쪽아래 꼭짓점 X좌표
				int startY = Integer.parseInt(st.nextToken()); //왼쪽아래 꼭짓점 Y좌표
				int endX = Integer.parseInt(st.nextToken()); //오른쪽위 꼭짓점 X좌표
				int endY = Integer.parseInt(st.nextToken()); //오른쪽위 꼭짓점 Y좌표
				
				for(int x=startX; x<endX; x++) { 
					for(int y=startY; y<endY; y++) {
						grid[x][y] = true;
					}
				}
				
		}
		
		//사각형이 차지하는 총 면적 구하기
		int totalSquare = 0; 
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				if(grid[i][j]) totalSquare++;
			}
		}
		
		System.out.println(totalSquare);

	}// end main

} //end class
