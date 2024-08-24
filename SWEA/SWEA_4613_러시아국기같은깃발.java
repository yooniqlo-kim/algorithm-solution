import java.util.*;
import java.io.*;
public class SWEA_4613_러시아국기같은깃발 {

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim()); //테스트케이스

        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine().trim());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

            String[] str = new String[N];
            for(int i=0; i<N; i++) {
                str[i] = br.readLine().trim();
            }

            int min = N*M; // 새로 칠해야 하는 칸의 개수의 최대값 (모든 칸을 새로 칠해야 하는 경우)

            // 봉사동아리처럼 모든 경우를 비교하여 최소값을 찾는다
            for(int w=1; w<N-1; w++) { //white와 blue의 경계
                for(int b=w+1; b<N; b++) { //blue와 red의 경계

                    int cnt = 0;

                    for (int i=0; i<w; i++) { // white
                        for(int j=0; j<M; j++) {
                            if(str[i].charAt(j) != 'W') cnt++; //white가 아니면 새로 칠한다
                        }
                    }

                    for(int i=w; i<b; i++) { // blue
                        for(int j=0; j<M; j++) {
                            if(str[i].charAt(j) != 'B') cnt++;
                        }
                    }

                    for(int i=b; i<N; i++) { //red
                        for(int j=0; j<M; j++) {
                            if(str[i].charAt(j) != 'R') cnt++;
                        }
                    }

                    min = Math.min(cnt, min); //최소값 갱신
                }
            }
            sb.append("#").append(t+1).append(" ").append(min).append("\n");
        }//end testcase
        bw.write(sb.toString());
        bw.close();
        br.close();


    }

}
