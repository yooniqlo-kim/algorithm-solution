class Solution {
	public static int solution(int n, int t)  {
		
		if(t==0)
			return n;
		return 2 * solution(n,t-1);
			
}
}