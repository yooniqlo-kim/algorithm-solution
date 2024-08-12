import java.util.*;
import java.io.*;
public class Solution {
	static StringBuilder sb = new StringBuilder(100);
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=0; t<T; t++) { //테스트케이스 순회
			int N = Integer.parseInt(br.readLine().trim());
			sb.append("#").append(t+1).append("\n");
			pascalTriangle(N);
		}//end for
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}//end main
	
	public static void pascalTriangle(int N) {
		int[][] arr = new int[10][10]; // 10 * 10 배열
		Queue<Integer> queue = new LinkedList(); //파스칼 삼격형 계산에 사용할 큐
		
		//파스칼 삼각형의 첫번째와 마지막은 항상 1
		for(int i=0; i<10; i++) {
			arr[i][0] = 1;
			arr[i][i] = 1;
		}
		
		
		for(int i=2; i<arr.length; i++) {
			int sum = 0;
			// 이전 행의 값을 큐에 추가
			for(int j=0; j<=i/2; j++) {
				queue.add(arr[i-1][j]);
			}
			
			// 큐에서 값을 꺼내 현재 행의 값을 계산
			int pollItem = queue.poll();
			for(int j=1; j<=i/2; j++) {
				sum += pollItem + queue.poll();
				arr[i][j] = sum;
			}
			
			//파스칼 삼각형은 대칭이므로 대칭되는 값을 복사
			for(int j=i; j>i/2; j--) {
				arr[i][j] = arr[i][i-j];
			}
		}
		
		// 생성된 파스칼 삼각형을 출력 형식에 맞게 스트링빌더에 추가
		for(int i=0; i<N; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j] != 0) { //0이 아닌 값만 출력
					sb.append(arr[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}

	}
}
