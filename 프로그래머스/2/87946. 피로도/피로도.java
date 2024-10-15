class Solution {
    static int[] selected;
	static boolean[] visited;
	static int[] idxArr;
	static int size;
	static int max = Integer.MIN_VALUE;
    
    public static int solution(int k, int[][] dungeons) {
		 size = dungeons.length;
		 
		 selected = new int[size];
		 visited = new boolean[size];
		 idxArr = new int[size];
		 
		 for(int i=0; i<size; i++) {
			 idxArr[i] = i;
		 }
		 
		 permutation(0,k,dungeons);
		 return max;
	}
    
    // 일반순열
	 private static void permutation(int current,int hp,int[][] dungeons) {
		 if(current == size) {
			 max = Math.max(max, explore(hp,dungeons));
			 return;
		 }
		 
		 for(int i=0; i<size; i++) {
			 if(visited[i]) continue;
			 
			 selected[current] = idxArr[i];
			 visited[i] = true;
			 permutation(current+1,hp,dungeons);
			 visited[i] = false;
		 }
	 }
    
    private static int explore(int hp,int[][] dungeons) {
		int count = 0;
		for(int i=0; i<size; i++) {
			int least = dungeons[selected[i]][0];
			int use = dungeons[selected[i]][1];
			
			if(hp < least) break;
			hp -= use;
			count++;
		}
		
		return count;
		
	}
}