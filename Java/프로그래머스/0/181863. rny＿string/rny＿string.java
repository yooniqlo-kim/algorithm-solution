import java.util.*;
import java.io.*;
class Solution {
    public String solution(String rny_string) {
		List<Character> list = new ArrayList<>();
		
		for(int i=0; i< rny_string.length(); i++) {
			list.add(rny_string.charAt(i));
		}
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals('m')) {
				list.set(i, 'r');
				list.add(i+1, 'n');
			}
		}
        StringBuffer sb = new StringBuffer();
		for(char c : list)
			sb.append(c);
        return sb.toString();
    }
}