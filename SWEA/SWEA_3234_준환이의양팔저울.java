import java.util.*;
import java.io.*;

public class SWEA_3234_준환이의양팔저울 {
	static int N, result;
	static int[] weights; 
	static int[] weightSelect;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb  = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			weights = new int[N]; isSelected = new boolean[N]; weightSelect = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
			for(int i=0; i<N; i++) weights[i] = Integer.parseInt(st.nextToken());
			
			result = 0; // 가능한 경우의 수를 저장하는 변수
			permutaion(0); 
			
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
		} // end testcase
		
		bw.write(sb.toString());  bw.close(); br.close();
	} // end main

	// 무게추를 양팔저울에 올리는 순서를 정하는 순열
	private static void permutaion(int depth) {
		if(depth == N) {
//			System.out.println(Arrays.toString(weightSelect));
			powerset(0,0,0); // 부분집합 생성
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			
			weightSelect[depth] = weights[i];
			isSelected[i] = true;
			permutaion(depth+1);
			isSelected[i] = false;
		}
		
	}
	
	// 왼쪽과 오른쪽 저울에 무게추를 배치하는 부분집합
	private static void powerset(int depth, int left, int right) {
		if(left < right) return; // 오른쪽 저울이 왼쪽 저울보다 무거우면 안된다
		if(depth == N) { // 무게추가 다 배치되었으면 유효한 경우로 판단하고, 경우의 수 + 1
			result ++;
			return;
		}
		
		powerset(depth + 1, left+weightSelect[depth], right); // 현재 무게추를 왼쪽 저울에 배치한 경우
		powerset(depth + 1, left, right+weightSelect[depth]); // 현재 무게추를 오른쪽 저울에 배치한 경우
		
	}
	
}
