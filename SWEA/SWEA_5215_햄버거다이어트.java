import java.util.*;
import java.io.*;

public class SWEA_5215_햄버거다이어트{
	static int N,L; 
	static int[] calories; // 각 재료의 칼로리
	static int[] grade; // 각 재료의 맛에 대한 점수
	static boolean[] isSelected; // 각 재료가 선택되었는지 여부를 저장
	static int max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim()); //테스트케이스
		for(int t=0; t<T; t++) { 
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken()); // 재료수
			L = Integer.parseInt(st.nextToken()); // 최대 칼로리
			isSelected = new boolean[N]; 
			grade = new int[N];
			calories = new int[N]; 
			max = Integer.MIN_VALUE;
			
			//입력 받기
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				grade[i] = Integer.parseInt(st.nextToken()); 
				calories[i] = Integer.parseInt(st.nextToken()); 
			}
			
			powerset(0); //부분집합 생성
			System.out.println("#"+(t+1) + " "+ max);
		}//end testcase
		

	}//end main
	
	// 부분집합
	public static void powerset(int idx) {
		
		// 기저 조건 : 모든 재료에 대해 선택 여부를 결정한 경우
		if(idx == N) {
			int totalCalories = 0, gradeSum =0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) { //선택된 재료만
					totalCalories += calories[i]; //칼로리 합 더하기
					gradeSum += grade[i]; //점수 합 더하기
				}
			}
			
			// 최대 칼로리 제한을 넘지 않는 경우, 리스트에 맛 점수의 합 추가
			if(totalCalories <= L) max = Math.max(max, gradeSum);
			return;
		}
		
		isSelected[idx] = false;
		powerset(idx+1);
		
		isSelected[idx] = true;
		powerset(idx+1);
		
		
	}//end method

}
