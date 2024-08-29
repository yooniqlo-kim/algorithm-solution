
import java.util.*;
import java.io.*;

public class SWEA_1873_상호의배틀필드 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);

		int T = Integer.parseInt(br.readLine().trim());
		int direction = -1, r=-1, c=-1; // direction : 방향 / r,c : 현재 위치
		int[] dr = {-1, 1, 0, 0}; // 델타배열 (상 하 좌 우)
		int[] dc = {0, 0, -1, 1};
				
		for(int t=0; t<T; t++) { //테스트케이스
			String[] st = br.readLine().trim().split(" "); 
			int R = Integer.parseInt(st[0]), C = Integer.parseInt(st[1]); // R:행 C:열 
			
			char[][] field = new char[R][C];
			Map<Character, Integer> directionMap = new HashMap<>(); 
			directionMap.put('U', 0); // 상
			directionMap.put('D', 1); // 하
			directionMap.put('L', 2); // 좌
			directionMap.put('R', 3); // 우
			
			//입력받기 및 초기 전차 위치와 방향 파악
			for(int i=0; i<R; i++) { // 행의 수만큼 반복
				String row = br.readLine().trim();
				
				for(int j=0; j<C; j++) { // 열의 수만큼 반복
					field[i][j] = row.charAt(j); 
					// 현재 방향 및 위치 기록
					if(row.charAt(j) == '^') direction = 0;
					else if(row.charAt(j) == 'v') direction = 1;
					else if(row.charAt(j) == '<') direction = 2;
					else if(row.charAt(j) == '>') direction = 3;
					
					// 전차 초기 위치 저장 후 해당 칸은 평지로 변경
					if(row.charAt(j) == '^' || row.charAt(j) == 'v' || row.charAt(j) == '<' || row.charAt(j) == '>') {
						r=i; c=j;
						field[i][j] = '.';
					}
				}
			}
			int commandCnt = Integer.parseInt(br.readLine().trim());
			String cmds = br.readLine().trim();
			// 입력 끝
			
			// 명령어 반복문
			for(int i=0; i<commandCnt; i++) { 
				char currentCmd = cmds.charAt(i); //현재 명령어
				
				// 이동 명령어
				if(directionMap.containsKey(currentCmd)) {
					direction = directionMap.get(currentCmd);
					int flagR = r + dr[direction];
					int flagC = c + dc[direction];
					
					// 평지일 경우에만 이동
					if(flagR >= 0 && flagC >= 0 && flagR < R && flagC < C && field[flagR][flagC] == '.') {
						r = flagR; c = flagC;
					}
				}
				
				// 발사 명령어 (S)
				else { 
					int idx = 1;
					while(true) {
						int flagR = r + dr[direction] * idx; // 행
						int flagC = c + dc[direction] * idx; // 열
						idx++;
						
						// 배열 범위 안에 있다면
						if(flagR >= 0 && flagC >= 0 && flagR < R && flagC < C) {
							if(field[flagR][flagC] == '*') { // 벽돌을 만나면 그 칸은 평지로 변경
							field[flagR][flagC] = '.';
							break; 
							} else if(field[flagR][flagC] == '#') break; // 강철을 만나면 아무 일도 일어나지 않는다
						} else break;
					}
			}
			} // end commands
			
			
			// 마지막 위치에서 전차 방향 표시
			if(direction==0) field[r][c] = '^';
			else if(direction==1) field[r][c] = 'v';
			else if(direction==2) field[r][c] = '<';
			else if(direction==3) field[r][c] = '>';
			
			// 출력
			sb.append("#").append(t+1).append(" ");
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					sb.append(field[i][j]);
				}
				sb.append("\n");
			}

		}//end testcase
	bw.write(sb.toString());
	bw.close();
	br.close();
}
}//end class

