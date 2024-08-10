import java.util.*;
import java.io.*;

public class Main { 
	public static void main(String[] args) throws Exception{
		
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken()); //행
		int M = Integer.parseInt(st.nextToken()); //열
		char[][] guardArr = new char[N][M]; //경비원 배치 상태를 저장하는 배열
		
		int rowGuardCnt = 0; // 경비원이 없는 행의 수
		int colGuardCnt = 0; // 경비원이 없는 열의 수
		
		for(int i=0; i<guardArr.length; i++) { 
			guardArr[i] = br.readLine().trim().toCharArray();
		}
		
		// 각 행마다 경비원이 있는지 검사
		for(int i=0; i<N; i++) {
			boolean isFind = false;
			for(int j=0; j<M; j++) {
				if(guardArr[i][j] == 'X') { //경비원을 발견한다면 다음 행 검사
					isFind = true;
					break;
				} 
			}
			if(!isFind) { //현재 행에 경비원이 없다면 카운트 증가
				rowGuardCnt++;
			}
		}
		
		// 각 열마다 경비원이 있는지 검사
		for(int j=0; j<M; j++) {
			boolean isFind = false;
			for(int i=0; i<N; i++) {
				if(guardArr[i][j] == 'X') { //경비원을 발견한다면 다음 열 검사
					isFind = true;
					break;
				}
			}
			if(!isFind) { //현재 열에 경비원이 없다면 카운트 증가
				colGuardCnt++;
			}
		}
		
		// 추가로 필요한 최소 경비원의 수
		// 경비원이 없는 행의 수와 열의 수 중 더 큰 값
		System.out.println(Math.max(rowGuardCnt, colGuardCnt));


	}// end main

} //end class

