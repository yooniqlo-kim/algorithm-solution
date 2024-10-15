import java.util.*;
import java.io.*;
class Solution {
     public static int solution(int n, int[][] wires) {
	        int[][] adjMatrix = new int[n+1][n+1];
	        
	        for(int i=0; i<wires.length; i++) {
	        	int a = wires[i][0];
	        	int b = wires[i][1];
	        	adjMatrix[a][b] = adjMatrix[b][a] = 1;
	        }
	        
	        int result = divide(n,adjMatrix);
	        return result;
	    }

	private static int divide(int N, int[][] adjMatrix) {
		int min = Integer.MAX_VALUE;
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(adjMatrix[i][j] == 1) {
					adjMatrix[i][j] = adjMatrix[j][i] = 0;
					
					boolean[] visited = new boolean[N+1];
					int count = dfs(i, visited, adjMatrix);
					
					min = Math.min(min, Math.abs(2*count-N));
					
					adjMatrix[i][j] = adjMatrix[j][i] = 1;
				}
			}
		}
		return min;
	}

	private static int dfs(int current, boolean[] visited, int[][] adjMatrix) {
		visited[current] = true;
		int count = 1;
		
		for(int i=1; i<visited.length; i++) {
			if(!visited[i] && adjMatrix[current][i] == 1)
				count += dfs(i, visited, adjMatrix);
		}
		return count;

	}

}