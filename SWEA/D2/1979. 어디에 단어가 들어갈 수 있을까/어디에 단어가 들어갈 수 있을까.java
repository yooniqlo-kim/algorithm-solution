import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(100);
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(st.nextToken()); //퍼즐의 크기
			int K = Integer.parseInt(st.nextToken()); //단어의 길이
			int[][] puzzle = new int[N][N];
			int totalCnt =0; //단어가 들어갈 수 있는 자리의 수
			
			// 배열 초기화 및 행 검사
			for(int i=0; i<N; i++) {
				int cnt = 0;
				st = new StringTokenizer(br.readLine().trim());
				for(int j=0; j<N; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
			
					if(puzzle[i][j] == 1) cnt++; // 1인 경우
					else { //0인 경우
						if(cnt == K) totalCnt++;
						cnt = 0;
					}
				} 
				if(cnt == K) totalCnt++; //행 끝에서 검사
			}
			
			//열 검사
			for(int j=0; j<N; j++) {
				int cnt = 0;
				for(int i=0; i<N; i++) {
					if(puzzle[i][j] == 1) cnt++;
					else {
						if(cnt == K) totalCnt++;
						cnt = 0;
					}
				}
				if(cnt == K) totalCnt++;
			}
			sb.append("#").append(t+1).append(" ").append(totalCnt).append("\n");
		}//end testcase
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}
