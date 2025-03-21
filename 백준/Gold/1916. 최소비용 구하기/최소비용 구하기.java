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
    static int[] distance;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

       int N = Integer.parseInt(br.readLine().trim()); // 도시의 개수 (정점)
       int M = Integer.parseInt(br.readLine().trim()); // 버스의 개수

       adjList = new ArrayList[N+1];
       for(int i=1; i<=N; i++) {
           adjList[i] = new ArrayList<>();
       }

       distance = new int[N+1];
       Arrays.fill(distance, INF);

       for(int i=1; i<=M; i++) {
           st = new StringTokenizer(br.readLine().trim());
           int u = Integer.parseInt(st.nextToken());
           int v = Integer.parseInt(st.nextToken());
           int w = Integer.parseInt(st.nextToken());

           adjList[u].add(new Node(v, w));
       }

       st = new StringTokenizer(br.readLine().trim());
       int start = Integer.parseInt(st.nextToken());
       int end = Integer.parseInt(st.nextToken());

       dijkstra(start,end);

        System.out.println(distance[end]);


    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int currentV = current.v;
            int currentW = current.w;

            if(currentW > distance[currentV]) continue;

            for(Node neighbor : adjList[currentV]) {
                int neighborV = neighbor.v;
                int neighborW = neighbor.w+currentW;

                if(distance[neighborV] > neighborW) {
                    distance[neighborV] = neighborW;
                    pq.add(new Node(neighborV, neighborW));
                }
            }
        }
    }

}
