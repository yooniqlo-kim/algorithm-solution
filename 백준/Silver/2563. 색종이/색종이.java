import java.util.*;
import java.io.*;

public class Main { 
	public static void main(String[] args) throws Exception{
		
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		boolean[][] grid = new boolean[101][101]; //흰색 도화지
		int N = Integer.parseInt(br.readLine().trim());
		int totalSquare = 0;
		
		for(int n=0; n<N; n++) { //색종이의 수만큼 순회
			
				st = new StringTokenizer(br.readLine().trim());
				int startX = Integer.parseInt(st.nextToken()); //색종이 시작점의 X좌표
				int startY = Integer.parseInt(st.nextToken()); //색종이 시작점의 Y좌표

				// 색종이가 차지하는 영역을 grid에 표시
				for(int x=startX; x < startX + 10; x++) {
					for(int y=startY; y<startY + 10; y++) {
						grid[x][y] = true;
					}
				}	
			}
			
		//색종이가 차지하는 총 면적 구하기
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				if(grid[i][j]) totalSquare++;
			}
		}
		
		System.out.println(totalSquare);

	}// end main

} //end class

