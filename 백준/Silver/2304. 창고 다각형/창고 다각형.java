
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim()); // 기둥의 개수
        int[] heights = new int[1001]; // 위치별 높이를 저장하는 배열
        int max = 0, maxIndex = 0, sum = 0;
        
        // 각 기둥의 위치와 높이를 저장하고, 최대 높이와 그 위치를 찾음
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int position = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            heights[position] = height;
            if (height > max) {
                max = height;
                maxIndex = position;
            }
        }
        
        // 왼쪽에서 최대 높이의 기둥까지 넓이를 계산
        int leftMax = 0;
        for (int i = 0; i <= maxIndex; i++) {
            if (heights[i] > leftMax) {
                leftMax = heights[i];
            }
            sum += leftMax;
        }
        
        // 오른쪽에서 최대 높이의 기둥까지 넓이를 계산
        int rightMax = 0;
        for (int i = 1000; i > maxIndex; i--) {
            if (heights[i] > rightMax) {
                rightMax = heights[i];
            }
            sum += rightMax;
        }

        System.out.println(sum);
    }
}
