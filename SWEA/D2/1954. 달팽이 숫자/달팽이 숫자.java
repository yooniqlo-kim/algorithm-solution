import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(100);
		
		int T = Integer.parseInt(br.readLine().trim());
		
		int[] dx = {0, 1, 0, -1}; //동 남 서 북 
		int[] dy = {1, 0, -1, 0};
		
		for(int t=0; t<T; t++) {
			
			int N = Integer.parseInt(br.readLine().trim());
			int[][] arr = new int[N][N];
			int x=0, y=0; // 배열의 위치
			int d=0; //델타배열의 위치
			int num = 1; //배열의 값
			
			while(num <= N*N) {
				arr[x][y] = num++; // num으로 초기화하고 1더하기
				
				int flagX = x + dx[d];
				int flagY = y + dy[d];
				
				if (flagX >=0 && flagX < N && flagY >= 0 && flagY < N && arr[flagX][flagY] == 0) {
					x = flagX;
					y = flagY;
				} else {
					d = (d+1) % 4;
					flagX = x + dx[d];
					flagY = y + dy[d];
					x = flagX;
					y = flagY;
				}
				/*if (flagX < 0 || flagX >= N || flagY < 0 || flagY >= N || arr[flagX][flagY] != 0) {
					d = (d+1) % 4;
					flagX = x + dx[d];
					flagY = y + dy[d];
				} 
				
				x = flagX;
				y = flagY;*/
				
			}
			sb.append("#").append(t+1).append("\n");
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}//end for
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}//end main
}//end class
