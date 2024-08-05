import java.util.*;
import java.io.*;

// 학생들은 성별과 학년에 따라 방 배정
// 한 방에는 같은 성별, 같은 학년의 학생만 배정
// 2차원배열 (행 : 학년, 열 : 성별)
// 학생 정보에 따라 배열 요소 증가
public class Main {
	public static void main(String[] args) throws Exception {
	
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken()); //학생수
		int k = Integer.parseInt(st.nextToken()); //한 방에 배정할 수 있는 최대 인원수
		int[][] students = new int[7][2]; // 학년(1~6)과 성별(0:여,1:남)에 따른 학생수 저장 배열
		int room = 0; // 필요한 방의 수 
		
		for(int i=0; i<N; i++) { //학생수만큼 반복
			StringTokenizer str = new StringTokenizer(br.readLine().trim());
			int col = Integer.parseInt(str.nextToken()); //성별 (여:0 남:1)
			int row = Integer.parseInt(str.nextToken()); //학년 (1~6)
			students[row][col]++; //해당 학년, 성별의 학생 수 증가
		}
		
		for(int i=0; i<7; i++) { //1학년부터 6학년까지
			for(int j=0; j<2; j++) { //여학생, 남학생
				if(students[i][j] == 0) //해당 학년, 성별의 학생이 없으면 skip
					continue;
				else if(students[i][j] % k == 0) // 학생수가 최대 인원수로 나누어 떨어지는 경우
					room += students[i][j] / k;
				else if(students[i][j] < k) // 학생수가 최대 인원수보다 작으면 
					room += 1;
				else if(students[i][j] > k) // 학생 수가 최대 인원수보다 크면
					room += students[i][j] / k + 1;
			}
		}
		
		StringBuilder sb = new StringBuilder(100);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.append(room).toString());
		
		bw.close();
		br.close();
	}// end main
}// end class
