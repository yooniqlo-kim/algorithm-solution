
import java.io.*;
import java.util.*;

public class SWEA_6808_규영이와인영이의카드게임 {
	static int winCnt, loseCnt;
	static int[]A, B, cards;
	static boolean[] selected;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);
		
		int T = Integer.parseInt(br.readLine().trim()); // 테스트케이스
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
			A = new int[9]; B = new int[9]; // A : 규영, B : 인영
			selected = new boolean[9]; // 인영이의 카드 선택 여부 배열
			cards = new int[18]; // 전체 카드
			winCnt=0; loseCnt=0; // 규영이가 이기는 경우의 수, 지는 경우의 수
			
			for(int i=0; i<9; i++) { // 규영이 점수 입력받기
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<cards.length; i++) { // 전체 카드 ( 1~18 )
				cards[i] = i+1;
			}
			
			int[] tempB = oppositeCombination(); // 인영이 카드 구하기 위해 전체 카드에서 규영이의 카드를 제외한 배열
			permutation(0, tempB); // 인영이 카드로 가능한 순열 생성
			
			sb.append("#").append(t+1).append(" ").append(winCnt).append(" ").append(loseCnt).append("\n");
		}//end testcase
		bw.write(sb.toString());
		bw.close();
		br.close();

	}
	
	// 규영이 카드를 제외한 나머지 카드를 인영이 카드로 반환
	public static int[] oppositeCombination() {
		int[] tempB = new int[9];
		int idx = 0;
		
		for(int i=0; i<cards.length; i++) {
			boolean isCombination = false;
			
			for(int j=0; j<A.length; j++) {
				 if(cards[i] == A[j]) {
					 isCombination = true;
					 break;
				 }
			}
			if(!isCombination) tempB[idx++] = cards[i]; // 규영이 카드가 아니면 인영이 카드
		}
		return tempB;
	}
	
	// 일반순열
	public static void permutation(int cnt, int[] tempB) {
		if(cnt == 9) {
			countWinLose(A, B); // 이기고 지는 경우의 수 계산
		}
		
		for(int i=0; i<9; i++) {
			if(selected[i]) continue;
			
			B[cnt] = tempB[i];
			selected[i] = true;
			permutation(cnt+1, tempB);
			selected[i] =false;
			
		}
	}
	
	// 규영이&인영이 카드를 비교하여 규영이가 이기는 경우의 수, 지는 경우의 수 계산
	public static void countWinLose(int[] A, int[] B) {
		int scoreA =0, scoreB = 0;
		
		for(int i=0; i<9; i++) {
			if(A[i] > B[i]) scoreA += A[i] + B[i];
			if(A[i] < B[i]) scoreB += A[i] + B[i];
		}
		
		if(scoreA > scoreB) winCnt++;
		else if(scoreA < scoreB) loseCnt++;
		
	}

}
