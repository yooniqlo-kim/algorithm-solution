import java.util.*;
import java.io.*;

public class Main { 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);
		
		int switchSize = Integer.parseInt(br.readLine().trim()); // 스위치 개수
		boolean[] switchStatus = new boolean[switchSize]; // 스위치 상태를 저장하는 boolean 배열
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		// 스위치 초기 상태를 배열에 저장
		// 스위치가 켜져있으면(1이면) true, 꺼져있으면 false
		for(int i=0; i<switchSize; i++) {
			if(Integer.parseInt(st.nextToken()) == 1) switchStatus[i]=true;
			else switchStatus[i] = false;
		}
		
		int S = Integer.parseInt(br.readLine().trim()); //학생 수
		
		//각 학생이 스위치 상태를 변경하는 과정
		for(int i=0; i<S; i++) { 
			st = new StringTokenizer(br.readLine().trim());
			int gender = Integer.parseInt(st.nextToken()); //학생 성별 (1:남,2:여)
			int num = Integer.parseInt(st.nextToken()); //학생이 받은 수
			
			switch(gender) {
			case 1: //남학생인 경우
				//남학생이 받은 수의 배수 위치에 있는 스위치 상태 변경
				for(int y = num-1; y<switchSize; y+=num) {
					switchStatus[y] = !switchStatus[y];
				}
				break;
			case 2: //여학생인 경우
				// 여학생이 받은 수를 중심으로 대칭이 되는 스위치 상태 변경
				for(int k=1; k<num; k++) {
					if(num-1-k >= 0 && num-1+k < switchSize && switchStatus[num-1-k] == switchStatus[num-1+k]) {
						switchStatus[num-1-k] = !switchStatus[num-1-k];
						switchStatus[num-1+k] = !switchStatus[num-1+k];
					} else {
						break;
					}
				}
				switchStatus[num-1] = !switchStatus[num-1]; //자기자신 변경
			default:
				break;
			}
		
		}//end for
		
		//출력
		for(int i=0; i<switchSize; i++) {
			if(switchStatus[i]) sb.append(1).append(" ");
			else sb.append(0).append(" ");
			
			if((i+1) % 20 ==0) sb.append("\n");
		}
		
		bw.write(sb.toString().trim());
		bw.close();
		br.close();
	}// end main

} //end class

