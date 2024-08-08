class Solution {
    public static String solution(String my_string, int n) {
    	char [] arr = my_string.toCharArray();
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=0; i<arr.length; i++) {
    		for(int j=0; j<n; j++) {
    			sb.append(arr[i]);
    		}
    	}
    	return sb.toString();
}
}