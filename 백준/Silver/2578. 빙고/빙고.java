import java.util.*;
import java.io.*;

public class Main { 
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
	
		int[][] bingo = new int[5][5]; //빙고판을 저장할 배열
		boolean[][] isCalled = new boolean[5][5];  //사회자가 번호를 불렀는지 확인하기 위한 배열
		Queue<Integer> bingoCalls = new LinkedList<Integer>(); //사회자가 부르는 번호 저장하는 큐
		
		//빙고판 입력받기
		for(int i=0; i<bingo.length; i++) { 
			st = new StringTokenizer(br.readLine().trim());
			for(int j=0; j<bingo[i].length; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		
		//사회자가 부르는 번호 입력받기
		for(int i=0; i<5; i++) {
			st=new StringTokenizer(br.readLine().trim());
			for(int j=0; j<5; j++) {
			bingoCalls.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int callCount = 0; //사회자가 몇번째 번호 부르는지 확인하기 위한 변수
		while(!bingoCalls.isEmpty()) { //사회자가 번호를 다 부를 때까지 반복
			
			int bingoCount = 0; //빙고인 줄의 수
			int pollItem = bingoCalls.poll(); //사회자가 부르는 번호 꺼내기
			callCount++; //사회자가 번호를 호출하면 1증가
			
			//사회자가 부른 번호와 빙고판 번호가 일치하면 true
			for(int i=0; i<bingo.length; i++) {
				for(int j=0; j<bingo[i].length; j++) {
					if(bingo[i][j] == pollItem) {
						isCalled[i][j] = true;
					}
				}		
			}
			
			// 행 빙고체크
			for(int i=0; i<5; i++) {
				boolean isBingo = true;
				for(int j=0; j<5; j++) {
					if(!isCalled[i][j]) {
						isBingo = false;
						break;
					}
				}
				if(isBingo) bingoCount++; // 가로줄이 빙고이면 증가
			}
			
			// 열 빙고 체크
			for(int j=0; j<5; j++) {
				boolean isBingo = true;
				for(int i=0; i<5; i++) {
					if(!isCalled[i][j]) {
						isBingo = false;
						break;
					}
				}
				if(isBingo) bingoCount++;
			}
				
			// 대각선 좌상 -> 우하 빙고체크
			boolean isBingoLeftUp= true;
			for(int i=0; i<5; i++) {
				if(!isCalled[i][i]) {
					isBingoLeftUp = false;
					break;
				}
			}
			if(isBingoLeftUp) bingoCount++;
			
			// 대각선 좌하 -> 우상 빙고체크
			boolean isBingoLeftDown = true;
			for(int i=0; i<5; i++) {
				if(!isCalled[i][4-i]) {
					isBingoLeftDown = false;
					break;
				}
			}
			if(isBingoLeftDown) bingoCount++;
			
			if(bingoCount>=3) { //빙고줄이 3이상이면
				System.out.println(callCount); //사회자가 몇번째 번호를 호출한지 출력
				break;
			}
			
		}//end while

	}// end main

} //end class
