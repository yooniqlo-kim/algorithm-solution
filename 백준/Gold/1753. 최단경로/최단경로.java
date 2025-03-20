import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node>{
        int v,w;

        public Node(int v,int w) {
            this.v=v;
            this.w=w;
        }

        // 두 노드의 가중치를 비교
        // 가중치가 낮은 노드가 우선순위큐에서 먼저 깨내지도록 정렬
        public int compareTo(Node other) { //
            return Integer.compare(this.w , other.w);
        }
    }

    static final int INF=Integer.MAX_VALUE;
    static List<Node>[] adjList;
    static int[] distance; //현재까지 구한 최단거리

    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;

       st = new StringTokenizer(br.readLine().trim());
       int V = Integer.parseInt(st.nextToken()); //정점
       int E = Integer.parseInt(st.nextToken()); //간선
       int K = Integer.parseInt(br.readLine().trim()); //시작 정점의 번호

       adjList=new ArrayList[V+1];
       for(int i=1; i<=V; i++) {
           adjList[i]=new ArrayList<>();
       }

       distance = new int[V+1];
       Arrays.fill(distance,INF); // 최단 거리 배열을 INF로 초기화

       for(int i=0; i<E; i++) {
           st = new StringTokenizer(br.readLine().trim());
           int u = Integer.parseInt(st.nextToken()); //시작점
           int v = Integer.parseInt(st.nextToken()); //끝점
           int w = Integer.parseInt(st.nextToken()); //가중치

           adjList[u].add(new Node(v,w)); // u->v 방향그래프
       }

       dijkstra(K);

       for(int i=1; i<=V; i++) {
           if(distance[i]==INF)
               System.out.println("INF");
           else
               System.out.println(distance[i]);
       }

    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        distance[start]=0;

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int curV = current.v;
            int curW = current.w;

            if(curW > distance[curV]) continue; // 이미 더 짧기 때문에 연산하지 않음

            for(Node next :adjList[curV]) {
                int nextV = next.v;
                int nextW = curW + next.w; //현재까지 거리 + 새로 이동할 간선 가중치

                if(distance[nextV] > nextW) {
                    distance[nextV] = nextW;
                    pq.offer(new Node(nextV, nextW));
                }
            }
        }
    }



}
