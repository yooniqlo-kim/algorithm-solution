import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        // 집합 생성
        for(int i=0; i<=N; i++) {
            parent[i] = i;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int op = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(op == 0) { // 0이면 합집합
                union(x,y);
            }
            else { // 1이 각 집합의 대표자가 같은지 확인(같으면 동일한 집합)
                if (findSet(x) == findSet(y)) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }

        bw.write(sb.toString());
        bw.close(); br.close();

    } //end main

    private static int findSet(int x) {
        if(x != parent[x])
            parent[x] = findSet(parent[x]);
        return parent[x];
    }

    private  static void union(int x, int y) {
        parent[findSet(y)] = findSet(x);
    }


}