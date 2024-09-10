import java.util.*;
import java.io.*;

public class SWEA_3289_서로소집합 {
	static int[] p; // 집합의 대표자를 저장할 배열

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		
		int T= Integer.parseInt(br.readLine().trim());
		
		for(int t=0; t<T; t++) {
			sb.append("#").append(t+1).append(" ");
			
			st = new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
			p = new int[N+1];
			
			// 집합 생성
			for(int i=0; i<N; i++) {
				p[i] = i;
			}
			

			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int check = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken());
				
				if(check == 0) { // 0이면, 집합 합치기 (합집합)
					union(x,y);
				} else { // 1이면 각 집합의 대표자가 같은지 확인 : 대표자가 같다면 같은 집합에 속한다
					if(findSet(x) == findSet(y)) sb.append(1); 
					else sb.append(0);
				}
			}
			sb.append("\n");
		}//end testcase
		
		bw.write(sb.toString()); bw.close(); br.close();
	}//end main
	
	private static int findSet (int x) {
		if (x != p[x]) p[x] = findSet(p[x]);
		return p[x];
	}
	
	private static void union (int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}
