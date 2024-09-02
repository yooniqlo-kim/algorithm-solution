import java.util.*;
import java.io.*;

public class SWEA_14510_나무높이{
    
  public static void main(String[] args) throws IOException {
	  System.setIn(new FileInputStream("input.txt"));
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringBuilder sb = new StringBuilder();
      StringTokenizer st;
        
      int T = Integer.parseInt(br.readLine());
       
      for (int t=0; t<T; t++) {
    	  
          int N = Integer.parseInt(br.readLine());
          int[] heights = new int[N];
          int maxHeight = Integer.MIN_VALUE;
          
          st = new StringTokenizer(br.readLine().trim()); 
          for (int i=0; i<N; i++) {
        	  heights[i] = Integer.parseInt(st.nextToken());
        	  maxHeight = Math.max(maxHeight, heights[i]); // 나무의 최대 높이
          }
          
          // 각 나무마다 최대 높이와의 차이를 구해 배열에 저장
          for(int i=0; i<N; i++) {
        	  heights[i] = maxHeight - heights[i];
          }
          
          // 홀수와 짝수 단위의 높이 추가 작업 횟수를 계산
          int odd = 0, even = 0;
          for(int i=0; i<N; i++) {
              odd += heights[i] % 2; // 홀수 단위 작업은 1씩 추가
              even += heights[i] / 2; // 짝수 단위 작업은 2씩 추가
          }
          
          int min = Integer.MAX_VALUE;
          
          // 최소 작업 횟수를 계산하기 위해 가능한 조합 탐색
          while (even >= 0) {
        	  int tmp = Math.max(2*odd-1, 2*even); // 더 오래걸리는 시간이 작업시간
              min = Math.min(min, tmp); // 최소 작업 횟수 계산
              even -= 1; odd += 2; // 짝수단위 작업은 2단위씩, 홀수단위 작업은 1단위씩. 그래서 짝수 작업을 한 번 줄이면 홀수 작업은 2번 줄여야 함
          }
           
          sb.append("#").append(t+1).append(" ").append(min).append("\n");
      }// end testcase
       
      bw.write(sb.toString()); bw.close(); br.close();
  }
}
