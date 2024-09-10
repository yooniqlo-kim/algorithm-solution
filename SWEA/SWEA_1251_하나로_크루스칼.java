import java.util.*;
import java.io.*;

public class SWEA_1251_하나로_크루스칼 {
	static int[] p; 
	
	static class Edge {
		int from;
		int to;
		long distance;
		
		public Edge(int from, int to, long distance) {
			super();
			this.from = from;
			this.to = to;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", distance=" + distance + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st,st2;
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int t=0; t<T; t++) { // 테스트케이스
			int N = Integer.parseInt(br.readLine().trim());
			List<Edge> edgeList = new ArrayList<>(); 
			
			st = new StringTokenizer(br.readLine().trim());
			st2 = new StringTokenizer(br.readLine().trim());
			double E = Double.parseDouble(br.readLine().trim());
			int[] xArr = new int[N]; int[] yArr = new int[N];
			
			for(int i=0; i<N; i++) {
				xArr[i] = Integer.parseInt(st.nextToken()); // X좌표
				yArr[i] = Integer.parseInt(st2.nextToken()); // Y좌표
			}
			
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					long distance = (long) (Math.pow(xArr[j]-xArr[i],2) + Math.pow(yArr[j]-yArr[i],2)); // 각 좌표 사이의 거리 구하기
					edgeList.add(new Edge(i,j,distance)); 
				}
			}
			
			// 1. 거리(가중치) 순으로 정렬
			Collections.sort(edgeList, new Comparator<Edge>() {
				@Override
				public int compare(Edge o1, Edge o2) { 
					if(o1.distance - o2.distance < 0) return -1;
					else if (o1.distance - o2.distance > 0) return 1;
					return 0;
//					return (int)(o1.distance - o2.distance); // 기준이 모호해서 오류가 난다
				}
			});
			
			// 2. i를 포함하는 집합 만들기
			p = new int[N]; // 0번 부터 시작하기 때문에 , 크기는 V
			for(int i=0; i<N; i++) { 
				p[i] = i;
			}
			
			long totalDistance = 0; // 최소 거리를 저장하기 위한 변수
			int pick = 0; // 내가 뽑은 간선의 개수
			
			// 3. N-1개의 간선 뽑기
			for(int i=0; i<edgeList.size(); i++) {
				int pFrom = findSet(edgeList.get(i).from); 
				int pTo = findSet(edgeList.get(i).to);
				
				if(pFrom != pTo) { // 각 집합의 대표자가 같지 않다면, 같은 집합이 아니다
					union (pFrom, pTo); // 집합 합치기
					totalDistance += edgeList.get(i).distance; 
					pick++;
				}
				
				if(pick == (N-1)) break; // 간선을 정점-1개 뽑으면 종료
			}
			
			E *= totalDistance; 
			sb.append("#").append(t+1).append(" ").append(String.format("%.0f", E)).append("\n");
		} // end testcase
		
		bw.write(sb.toString()); bw.close(); br.close();
	}
	
	// pFrom과 pTo는 각 집합의 대표자
	private static void union(int pFrom, int pTo) {
		p[pTo] = pFrom; // pTo가 속한 집합의 대표자가 pFrom이 된다
	}
	
	// x를 포함하는 집합의 대표자 찾기
	private static int findSet(int x) {
		if(x != p[x]) p[x] = findSet(p[x]);
		return p[x];
	}

}
