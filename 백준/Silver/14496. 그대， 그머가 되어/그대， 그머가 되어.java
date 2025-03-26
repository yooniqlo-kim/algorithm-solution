import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.w, other.w);
        }
    }

    static final int INF=Integer.MAX_VALUE;
    static List<Node>[] adjList;
    static int[] count;
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine().trim());
        int before = Integer.parseInt(st.nextToken());
        int after = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken()); // 노드
        int M = Integer.parseInt(st.nextToken()); // 간선

        adjList = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }

        count = new int[N+1];
        Arrays.fill(count,INF);

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjList[start].add(new Node(end, 1));
            adjList[end].add(new Node(start,1));
        }

        dijkstra(before, after);

        int result = count[after] == INF ? -1 : count[after];
        System.out.println(result);

    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];

        pq.offer(new Node(start,0));
        count[start] = 0;

        while(!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int current = currentNode.v;

            if(visited[current]) continue;
            visited[current]=true;

            if(current == end) return;

            for(Node neighbor : adjList[current]) {
                int nextV = neighbor.v;
                int nextW = neighbor.w;

                if(count[nextV] > count[current] + nextW) {
                    count[nextV] = count[current]+nextW;
                    pq.offer(new Node(nextV, count[nextV]));
                }
            }


        }

    }

}
