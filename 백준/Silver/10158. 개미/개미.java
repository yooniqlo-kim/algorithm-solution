import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine().trim());
        int gridX = Integer.parseInt(st.nextToken()); // 격자 x
        int gridY = Integer.parseInt(st.nextToken()); // 격자 y
        st = new StringTokenizer(br.readLine().trim());
        int startX = Integer.parseInt(st.nextToken()); // 시작 위치 x
        int startY = Integer.parseInt(st.nextToken()); // 시작 위치 y
        int T = Integer.parseInt(br.readLine().trim()); // 개미가 움직일 시간 T

       int resultX = (startX + T) % (2 * gridX);
       int resultY = (startY + T) % (2 * gridY);

       resultX = gridX - Math.abs(gridX - resultX);
       resultY = gridY - Math.abs(gridY - resultY);
       System.out.println(resultX + " "+resultY);

    }//end main
}//end class
