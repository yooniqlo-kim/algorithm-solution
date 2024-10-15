import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
class Solution {
    static int[] num;
	static boolean[] visited;
	static int[] selected;
	static Set<Integer> set = new HashSet<>();
    
    public static int solution(String numbers) {
		 num = new int[numbers.length()];
		 for(int i=0; i<num.length; i++) {
			 num[i] = numbers.charAt(i) - '0';
		 }
		 
		 for(int i=1; i<=num.length; i++) {
			 selected = new int[i];
			 visited = new boolean[numbers.length()];
			 permutation(0,i); 
		 }
		 
		 return set.size();
	}

	private static void permutation(int idx, int size) {
		if(idx==size) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<size; i++) {
				sb.append(selected[i]);
			}
			
			int n = Integer.parseInt(sb.toString());
			if(isPrime(n))
				set.add(n);
			return;
		}
		
		for(int i=0; i<num.length; i++) {
			if(visited[i]) continue;
			
			selected[idx] = num[i];
			visited[i] = true;
			permutation(idx+1, size);
			visited[i] = false;
		}
		
	}

	private static boolean isPrime(int n) {
		if(n < 2) return false;
		for(int i=2; i*i <= n; i++) {
			if(n%i==0)
				return false;
		}
		
		return true;
	}
}