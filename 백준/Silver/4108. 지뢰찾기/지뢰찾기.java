import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);
        int[] dr = {0, 0, 1, -1, -1, -1, 1, 1}; // 동 서 남 북 북서 북동 남서 남동
        int[] dc = {1, -1,0 ,0, -1, 1, -1, 1};

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            if(R==0 && C==0) break; // 반복문 탈출
            char[][] map = new char[R][C];

            for (int i = 0; i < R; i++) {
                String str = br.readLine().trim();
                for (int j = 0; j < C; j++) map[i][j] = str.charAt(j);
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == '*') continue;

                    int cnt = 0;
                    for (int k = 0; k < 8; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] != '*') continue;
                        cnt++;
                    }
                    map[i][j] = (char) (cnt + '0');
                }
            }
            // 출력
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        bw.write(sb.toString()); bw.close(); br.close();
    }
}

