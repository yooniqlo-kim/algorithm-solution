import java.util.*;
import java.io.*;

class Solution {
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
	static List<String> list;
   public int solution(String word) {
         list = new ArrayList<>();
         dfs("",0);
         
         for(int i=0; i<list.size(); i++) {
        	 if(list.get(i).equals(word)) {
        		 return i;
        	 }
         }
         return 0;
    }

	private void dfs(String str, int idx) {
		list.add(str);
		if(idx == vowels.length) 
			return;
		
		for(int i=0; i<5; i++) {
			dfs(str+vowels[i], idx+1);
		}
		
	}
}