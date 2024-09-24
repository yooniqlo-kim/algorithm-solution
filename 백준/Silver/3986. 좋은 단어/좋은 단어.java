import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine().trim());
    	int cnt = 0;
    	for(int i=0; i<N; i++) {
    		String str = br.readLine().trim();
    		if(str.length() % 2 == 1) continue;
    		ArrayDeque<Character> stack = new ArrayDeque();
    		stack.push(str.charAt(0));
    		
    		for(int j=1; j<str.length(); j++) {
    			char c = str.charAt(j);
    			
    			if(!stack.isEmpty() && stack.peek() == c) 
    				stack.pop();
    			else
    				stack.push(c);
    		}
    		if(stack.isEmpty()) cnt++;
    	}
    	System.out.println(cnt);
    	
    }
}