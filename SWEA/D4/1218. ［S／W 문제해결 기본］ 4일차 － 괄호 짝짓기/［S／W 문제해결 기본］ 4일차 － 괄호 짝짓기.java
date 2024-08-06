import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("src/김윤/A020_SWEA_1218_괄호짝짓기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);
		StringTokenizer st;
		
		for(int t = 0; t < 10; t++) {
			Map<Character, Character> map = new HashMap<Character, Character>();
			Stack<Character> stack = new Stack<Character>();
			int N = Integer.parseInt(br.readLine().trim());
			char[] arr = br.readLine().toCharArray();
			int result=0;
			
			map.put('(', ')'); //키 : 여는괄호, 값 : 닫는괄호
			map.put('<', '>');
			map.put('[', ']');
			map.put('{', '}');
			
			for(int i=0; i<arr.length; i++) {
				if(map.containsKey(arr[i])) { //여는 괄호라면 스택에 push
					stack.push(arr[i]);
				} else if(stack.isEmpty() || map.get(stack.peek()) != arr[i]) { // 닫는괄호가 나왔을 때, 스택이 비어있다면? 닫는괄호가 더 많음
					result = 0;													// 닫는괄호가 나왔을 때, 짝이 맞는 여는 괄호가 스택에 없으면 괄호 짝이 안 맞음
					break; 
				} else {
					stack.pop();
				} 
			}
			
			if(stack.isEmpty()) result = 1; // 모든 처리 후 스택에 괄호가 남아있다면, 여는 괄호가 더 많음
			sb.append("#").append(t+1).append(" ").append(result).append("\n");

		}//end for
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}