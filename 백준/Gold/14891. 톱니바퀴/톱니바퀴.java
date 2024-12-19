import java.util.*;
import java.io.*;

public class Main {
    static final int TOTAL_GEARS = 4;
    static final int TEETH_PER_GEAR = 8;
    static List<List<Integer>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        list = new ArrayList<>();
        for (int i = 0; i < TOTAL_GEARS; i++) {
            String str = br.readLine().trim();
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < TEETH_PER_GEAR; j++) {
                row.add(str.charAt(j) - '0');
            }
            list.add(row);
        }

        int K = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int gearNumber = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            rotateAllGears(gearNumber, direction);
        }

        System.out.print(calculateScore());
    }

    private static void rotateAllGears(int gearNumber, int direction) {
        int[] directions = new int[TOTAL_GEARS]; // 각 톱니바퀴의 회전 방향 저장
        directions[gearNumber] = direction;

        // 왼쪽 톱니바퀴 처리
        for (int i = gearNumber - 1; i >= 0; i--) {
            if (list.get(i).get(2) != list.get(i + 1).get(6)) {
                directions[i] = -directions[i + 1]; // 반대 방향
            } else {
                break; // 회전하지 않으면 더 이상 진행할 필요 없음
            }
        }

        // 오른쪽 톱니바퀴 처리
        for (int i = gearNumber + 1; i < TOTAL_GEARS; i++) {
            if (list.get(i).get(6) != list.get(i - 1).get(2)) {
                directions[i] = -directions[i - 1]; // 반대 방향
            } else {
                break; // 회전하지 않으면 더 이상 진행할 필요 없음
            }
        }

        // 각 톱니바퀴 회전
        for (int i = 0; i < TOTAL_GEARS; i++) {
            if (directions[i] == 1) {
                rotateClockwise(i);
            } else if (directions[i] == -1) {
                rotateCounterClockwise(i);
            }
        }
    }

    private static int calculateScore() {
        int score = 1;
        int sum = 0;
        for (List<Integer> row : list) {
            if (row.get(0) == 1) {
                sum += score;
            }
            score *= 2;
        }
        return sum;
    }

    private static void rotateClockwise(int gearNumber) {
        List<Integer> gear = list.get(gearNumber);
        int last = gear.remove(TEETH_PER_GEAR - 1);
        gear.add(0, last);
    }

    private static void rotateCounterClockwise(int gearNumber) {
        List<Integer> gear = list.get(gearNumber);
        int first = gear.remove(0);
        gear.add(first);
    }
}
