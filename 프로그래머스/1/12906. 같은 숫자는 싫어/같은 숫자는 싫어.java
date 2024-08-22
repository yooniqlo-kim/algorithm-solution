import java.util.*;

public class Solution {
    public static int[] solution(int []arr) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(arr[0]);
		
		for(int i=1; i<arr.length; i++) {
		
			if(arr[i] != stack.peek()) {
				stack.push(arr[i]);
			}
		}
		
		int[] result = new int[stack.size()];
		int idx = 0;
		while(!stack.isEmpty()) {
			result[result.length-1-(idx++)] = stack.pop();
		}
		
		return result;
	}
}