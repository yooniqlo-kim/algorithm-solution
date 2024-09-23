import java.util.*;
import java.io.*;

public class Main { 
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine().trim());
		int cnt=1;
		
		for(int i=0; i<N; i++) {
			stack.push(Integer.parseInt(br.readLine().trim()));
		}

		int longStick;
		int stick = stack.pop();
		while(!stack.isEmpty()) {
			longStick = stack.pop();
			if(longStick > stick) {
				stick = longStick;
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
		

	}// end main

} //end class

