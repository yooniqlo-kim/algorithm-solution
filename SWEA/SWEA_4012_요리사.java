import java.util.*;
import java.io.*;

public class SWEA_4012_요리사 {
	static int N; 
	static int[][] synergy; 
	static int[] ingredientsIdx; 
    static int[] selectedA; 
    static int[] selectedB;
    static int[] pair;
    static boolean[] isUsed;
    static int min;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine().trim()); //테스트케이

        for(int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            synergy = new int[N][N];
            ingredientsIdx = new int[N];
            
            selectedA = new int[N/2];
            selectedB = new int[N/2];
            pair = new int[2];
            isUsed = new boolean[N/2];

            min = Integer.MAX_VALUE;
           
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                ingredientsIdx[i] = i; //재료인덱스
                for(int j=0; j<N; j++) {
                    synergy[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            combination(0,0);
            System.out.println("#" +(t+1)+" "+ min);
        }//end testcase

    }//end main

    // N개 중에서 N/2 개를 뽑는 조합 생성
    public static void combination(int start, int cnt) {
        if(cnt == N/2) { 
           int sumA = calculateSynergy(0, selectedA); // A음식의 시너지 합계 계산
           oppositeCombination(selectedA, 0); // 선택되지 않은 재료로 B음식 구성
           int sumB = calculateSynergy(0,selectedB); // B음식의 시너지 합계 계산
           
           min = Math.min(min, Math.abs(sumA-sumB)); // A음식과 B음식의 시너지 차이 최소값 갱신

            return;
        }
        
        // 조합 생성
        for(int i=start; i<ingredientsIdx.length; i++) {
        	selectedA[cnt] = ingredientsIdx[i];
            combination(i+1, cnt+1);
        }
    }
    
    public static void oppositeCombination(int[] selected, int idx) {
    
    	for(int i=0; i<ingredientsIdx.length; i++) {
    		boolean isCombination = false;
    		
    		// 현재 재료가 A음식에 속하는지 확인
    		for(int j=0; j<selected.length; j++) {
    			if(ingredientsIdx[i] == selected[j]) {
    				isCombination = true;
    				break;
    			}
    		}
    		
    		// A음식에 속하지 않는다면 B음식에 추가
    		if(!isCombination) selectedB[idx++] = ingredientsIdx[i];
    	}
    	
    }
    
    // 두 재료의 시너지 계산 (순열 사용)
    public static int calculateSynergy(int cnt, int[] selected) {
        if(cnt == 2) { // 두 재료가 선택되면 시너지 값 반환
            return synergy[pair[0]][pair[1]];
        }
        
        int sum = 0;
        for(int i=0; i<selected.length; i++) {
            if(isUsed[i]) continue;

            pair[cnt] = selected[i];
            isUsed[i] = true;
            sum += calculateSynergy(cnt+1,selected);
            isUsed[i] = false;
        }
        return sum; //총 시너지 
    }
}
