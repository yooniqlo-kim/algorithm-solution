class Solution {
    
    public int[] solution(String[] strlist) {
    	int[] len = new int[strlist.length];
    	for(int i=0; i<strlist.length; i++) {
    		len[i] = strlist[i].length();
    	}
    	
    	return len;
    }
}