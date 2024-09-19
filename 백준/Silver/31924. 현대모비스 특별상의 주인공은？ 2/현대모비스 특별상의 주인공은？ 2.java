import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		
		int[] dr = {0,0,1,-1,-1,-1,1,1}; // 동 서 남 북 북동 북서 남동 남서
		int[] dc = {1,-1,0,0,1,-1,1,-1};
		int N = Integer.parseInt(br.readLine().trim());
		
		// 입력
		char[][] map = new char[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine().trim();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 'M') continue;
				
				for(int k=0; k<8; k++) {
					sb = new StringBuilder();
					for(int t=0; t<5; t++) {
						int nr = i + dr[k] * t;
						int nc = j + dc[k] * t;
						if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
						
						sb.append(map[nr][nc]);
					}
					if(sb.toString().equals("MOBIS"))  cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
