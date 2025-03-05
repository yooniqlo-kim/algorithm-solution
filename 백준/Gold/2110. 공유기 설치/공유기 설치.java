import java.util.*;
import java.io.*;

// 집의 좌표 범위가 10억 이하이므로, 완전 탐색은 어렵다 => 이분탐색
// 공유기 간 최소거리의 최대값을 찾는 문제이다
public class Main {

    public static int[] house;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int C = Integer.parseInt(st.nextToken()); // 공유기의 개수

        house = new int[N];
        for(int i=0; i<N; i++) {
            house[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(house);

        int left = 1; // 가능한 최소 거리
        int right = house[N-1]-house[0]; // 가능한 최대 거리 (첫 집과 마지막 집의 거리)

        while (left <= right) {
            int mid = (left + right) / 2; // 현재 검사하는 최소 거리

            int current = 0; // 공유기 설치 위치 (첫 번째 집부터 시작)
            int count = 1; // 공유기 설치 개수 (첫 번째 집에 설치)

            for(int i=1; i < N; i++) {
                if(house[i] - house[current] >= mid) { // 최소 거리 이상이면 공유기를 설치할 수 있다
                    current = i;
                    count ++;
                }
            }

            // 설치한 공유기 개수 > C
            // 더 설치할 수 있다 => 최소 거리를 줄여야 한다
            if (count < C) {
                right = mid -1;
                continue;
            }

            left = mid + 1;
        }

        System.out.println(left - 1);

    }
}
