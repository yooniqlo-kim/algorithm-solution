import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine().trim());
    	String postfix = br.readLine();
    	
    	Deque<Double> calculateStack = new ArrayDeque<>();
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	char key = 'A';
    	for(int i=0; i<N; i++) {
    		int value = Integer.parseInt(br.readLine().trim());
    		map.put(key++, value);
    	}
    	
    	
    	for(int i=0; i<postfix.length(); i++) {
    		char c = postfix.charAt(i);
    		
    		if(c>='A' && c<='Z') {
    			calculateStack.push((double)map.get(c));
    		} else {
    			double num2 = calculateStack.pop();
    			double num1 = calculateStack.pop();
    			double result = 0;
    			
    			switch(c) {
    			case '+':
    				result = num1 + num2;
    				break;
    			case '-':
    				result = num1 - num2;
    				break;
    			case '*':
    				result = num1 * num2;
    				break;
    			case '/':
    				result = num1 / num2;
    				break;
    			}
    			calculateStack.push(result);
    		}
    	}
    	System.out.printf("%.2f",calculateStack.pop());
    }
}