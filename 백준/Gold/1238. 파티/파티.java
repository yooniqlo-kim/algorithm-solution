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
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken()); // 마을 수
        int M = Integer.parseInt(st.nextToken()); // 도로 수 (간선)
        int X = Integer.parseInt(st.nextToken()); // 도착

        List<Node>[] adjList = new ArrayList[N+1];
        List<Node>[] reverseList=new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            adjList[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[start].add(new Node(end, weight));
            reverseList[end].add(new Node(start,weight));
        }

        int[] toX = dijkstra(adjList, X);
        int[] fromX = dijkstra(reverseList, X);

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++) {
            max = Math.max(max, toX[i]+fromX[i]);
        }

        System.out.println(max);

    }

    private static int[] dijkstra(List<Node>[] list, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] distance = new int[N+1];
        Arrays.fill(distance,INF);
        boolean[] visited = new boolean[N+1];

        pq.offer(new Node(start,0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int currentV = current.v;

            if(visited[currentV]) continue;
            visited[currentV]=true;

            for(Node neighbor : list[currentV]) {
                if(distance[neighbor.v] > distance[currentV] + neighbor.w) {
                    distance[neighbor.v] = distance[currentV] + neighbor.w;
                    pq.offer(new Node(neighbor.v, distance[neighbor.v]));
                }
            }

        }
        return distance;

    }

}
