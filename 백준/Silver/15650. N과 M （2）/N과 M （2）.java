import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb;
	static int[] selected;
//	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		selected = new int[M]; 
		
		recursive(N,M,0,0);
		System.out.println(sb.toString());
	} //end main

	private static void recursive(int N, int M, int depth, int start) {
		
		if(depth == M) {
			for(int i=0; i<M; i++) sb.append(selected[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			selected[depth] = i+1;
			recursive(N, M, depth+1,i+1);
		}
	}
	
	

}
