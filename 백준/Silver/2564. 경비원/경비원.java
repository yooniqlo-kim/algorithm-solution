import java.util.*;
import java.io.*;


public class Main{
	static int[][] map;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int width = Integer.parseInt(st.nextToken()); //가로
		int height = Integer.parseInt(st.nextToken()); //세로
		map = new int[2][width+height+1];
		int N = Integer.parseInt(br.readLine().trim()); //상점 개수
		
		// 상점 위치 입력받기 및 표시
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int direction = Integer.parseInt(st.nextToken());
			int location = Integer.parseInt(st.nextToken());
			++cnt;
			markPosition(direction,location,width,height);
		}
		cnt = 101;
		// 동근이 위치 입력받기 및 표시
		st = new StringTokenizer(br.readLine().trim());
		int myDirection = Integer.parseInt(st.nextToken());
		int myLocation = Integer.parseInt(st.nextToken());
		markPosition(myDirection, myLocation,width,height);
		
		int sum = 0;
		for(int i=1; i<=N; i++) {
			sum += findShortestPath(i);
		}
		System.out.println(sum);
	}//end main
	
	private static int findShortestPath(int target) {
		int targetRow = -1, targetCol = -1;
		int myRow = -1, myCol = -1;
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j] == 101) {
					myRow = i;
					myCol = j;
				}
				if(map[i][j] ==target) {
					targetRow=i;
					targetCol=j;
				}
			}
		}
		
		if(myRow == targetRow) {
			return Math.abs(targetCol-myCol);
		} else if(myRow != targetRow) {
			int clockWise = myCol + targetCol;
			int counterClockWise = Math.abs((map[0].length-1-myCol) + (map[0].length-1-targetCol));
			return Math.min(clockWise, counterClockWise);
		}
		return -1;
	}
	private static void markPosition(int direction, int location,int width,int height) {
		switch(direction) {
		case 1://북
			map[0][location] = cnt;
			break;
		case 4: //동
			map[0][location+width] = cnt;
			break;
		case 2: //남
			map[1][location+height] = cnt;
			break;
		case 3: //서
			map[1][location] = cnt;
			break;
		}
	}

}
