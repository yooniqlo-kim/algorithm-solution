import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(100);
		
		int T = Integer.parseInt(br.readLine().trim()); // 테스트케이스
		
		for(int t=0; t<T; t++) { //테스트케이스 10회 반복
			String str = br.readLine().trim(); // N과 M 을 포함하는 문자열 한 줄 읽기
			StringTokenizer st = new StringTokenizer(str); // 문자열 토큰으로 분리
			int N = Integer.parseInt(st.nextToken()); // N
			int M = Integer.parseInt(st.nextToken()); // M
			int[][] arr = new int[N][N];
			
			//배열 초기화
			for(int i=0; i<N; i++) {
				String[] strArr = br.readLine().trim().split(" ");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(strArr[j]);
				}
			}
			int max = 0;
			for(int i=0; i<N-M+1; i++) { //한 열에 N-M+1만큼 반복
				for(int j=0; j<N-M+1; j++) { //한 행에 N-M+1만큼 반복
					int sum = 0;
					for(int x=0; x<M; x++) { //파리채크기
						for(int y=0; y<M; y++) {
							sum += arr[i+x][j+y]; //파리채 한 번 내리칠 때 합
							
						}
					} 
                    max = Math.max(max, sum);
				}
			}
			
			sb.append("#").append(t+1).append(" ").append(max).append("\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}//end main
}//end class
