import java.util.*;
import java.io.*;
public class SWEA_3499_퍼펙트셔플 {

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim()); //테스트케이스

        for(int t=0; t<T; t++) {
            Queue<String> q1 = new LinkedList<>();
            Queue<String> q2 = new LinkedList<>();

            int N = Integer.parseInt(br.readLine().trim()); // 카드 수
            st = new StringTokenizer(br.readLine().trim());

            int M = N%2 == 0 ? N/2 : N/2+1;
            for(int i=0; i<M; i++) {
                q1.add(st.nextToken());
            }
            for(int i=M; i<N; i++) {
                q2.add(st.nextToken());
            }

            for(int i=0; i<M; i++) {
                sb.append(q1.poll()).append(" ");
                if(!q2.isEmpty()) sb.append(q2.poll()).append(" ");
            }


            sb.append("\n");
        }//end testcase
        bw.write(sb.toString().trim());
        bw.close();
        br.close();



    }

}
