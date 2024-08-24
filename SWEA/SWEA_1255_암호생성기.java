import java.util.*;
import java.io.*;
public class SWEA_1255_암호생성기 {

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);
        StringTokenizer st;

        for(int t=0; t<10; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            st = new StringTokenizer(br.readLine().trim());

            Queue<Integer> queue = new LinkedList<>();

            for(int i=0; i<8; i++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            int idx = 1; //감소하는 값
            while(true) {
                int pollItem = queue.poll()-idx++; //감소 후 뒤로 이동할 값
                if(pollItem <= 0) { //0보다 작거나 같으면
                    queue.add(0); //0을 추가하고 반복 종료
                    break;
                }
                queue.add(pollItem); //0보다 크면 pollItem 추가

                if(idx > 5) idx = 1;

            }

            sb.append("#").append(t+1).append(" ");
            for(int n : queue) sb.append(n).append(" ");
            sb.append("\n");
        }//end testcase
        bw.write(sb.toString().trim());
        bw.close();
        br.close();



    }

}
