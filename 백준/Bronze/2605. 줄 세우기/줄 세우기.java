import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
	
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim()); //학생수 입력
		int[] arr = new int[N]; // 학생들이 뽑은 번호를 담는 배열
		List<Integer> list = new ArrayList<Integer>(); // 학생의 순서를 저장할 리스트
		// 리스트를 사용한 이유 : 배열은 크기가 고정되어 있어 중간에 요소를 삽입하기 번거롭다
		
		//학생들이 뽑은 번호 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int idx = 0; // 현재 처리중인 학생의 인덱스
		int num = 1; // 학생에게 부여할 번호 (1부터 시작)
		while(idx < N) { //학생수만큼 반복
			
			if (arr[idx] >= 1) { //학생이 뽑은 번호가 1이상인 경우, (현재위치-뽑은 번호)만큼 앞으로 간다
				list.add(idx-arr[idx], num++);
			} else {	
				list.add(num++); //학생이 뽑은 번호가 0인 경우, 현재 위치에 추가
			}
			
		idx++; //다음 학생으로 이동
		}//end while
		
		for(int n : list)
			System.out.print(n + " ");
	}// end main
}// end class
