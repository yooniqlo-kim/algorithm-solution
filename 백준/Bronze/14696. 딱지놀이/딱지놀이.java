import java.util.*;
import java.io.*;

public class Main { 
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stA,stB;
		
		int T = Integer.parseInt(br.readLine().trim()); //딱지놀이 총 라운드 수
		
		for(int t = 0; t < T; t++) { //라운드 수만큼 순회
			
			stA = new StringTokenizer(br.readLine().trim()); // 어린이A의 카드 정보
			stB = new StringTokenizer(br.readLine().trim()); // 어린이B의 카드 정보
			
			int[][] card = new int[2][];
			card[0] = new int[Integer.parseInt(stA.nextToken())]; // 어린이A가 뽑은 카드를 저장하는 배열
			card[1] = new int[Integer.parseInt(stB.nextToken())]; // 어린이B가 뽑은 카드를 저장하는 배열
			
			int[] countA = new int[5]; //각 모양별 카드 개수를 세기 위한 배열 (인덱스0 무시)
			int[] countB = new int[5];
			char result = 0; //결과를 저장하는 변수
			
			for(int i=0; i<card[0].length; i++) { //어린이A 카드 정보
				card[0][i] = Integer.parseInt(stA.nextToken());
				countA[card[0][i]]++;
			}
			
			for(int i=0; i<card[1].length; i++) { //어린이B 카드 정보
				card[1][i] = Integer.parseInt(stB.nextToken());
				countB[card[1][i]]++;
			}
			
			for(int i=countA.length-1; i>=1; i--) { //별 - 동그라미 - 네모 - 세모 순으로 비교
				if(countA[i]>countB[i]) {
					result = 'A'; 
					break;
				}
				else if(countA[i] < countB[i]) {
					result = 'B';
					break;
				}
			}
			if(result == 0) result='D'; // 모든 모양 개수가 같으면 무승부
			
			System.out.println(result);
		}//end round

	}// end main

} //end class

