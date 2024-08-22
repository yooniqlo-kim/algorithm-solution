import java.util.*;
import java.io.*;

public class SWEA_1218_괄호짝짓기 {
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);
		
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		map.put('<', '>');
		
		for(int t=0; t<10; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			String str = br.readLine().trim();
			int result = 1;
			Stack<Character> stack = new Stack<>();
			
			out: for(int i=0; i<str.length(); i++) { //문자열 순회
				char c = str.charAt(i);
				
				for(char key : map.keySet()) { //키 순회
					
					if(c == key) { //문자가 열린괄호라면 스택에 추가
						stack.push(c);
						continue out;
					} else if (c == map.get(key)) { //닫힌 괄호일 때 
						if(stack.peek()==key) stack.pop();	//stack에 열린괄호가 있다면 pop
						else if(stack.peek()!=key) result=0; //stack에 열린괄호가 없다면
						
					}
				}
			}
			if(!stack.isEmpty()) result = 0;
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
		}//end testcase
		bw.write(sb.toString());
		bw.close();
		br.close();
		

	}
	
}
