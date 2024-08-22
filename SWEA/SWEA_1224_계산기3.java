import java.util.*;
import java.io.*;

public class SWEA_1224_계산기3 {

	static Map<Character, Integer> map = new HashMap<Character, Integer>();
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);
		
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		
		for(int t=0; t<10; t++) {
			int N = Integer.parseInt(br.readLine().trim()); //문자열의 길이
			String str = br.readLine().trim();
			String postfix = infixToPostfix(str);
			int result = calculate(postfix);
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
			
		}//end testcase
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	// 후위표기법 계산
	private static int calculate(String postfix) {
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<postfix.length(); i++) { //후위표기식 순회
			char c = postfix.charAt(i);
			
			if(c >= '0' && c <= '9') { //피연산자는 stack에 push
				stack.push(c-'0');
			}
			else { //연산자라면 계산
				int num1 = stack.pop(); 
				int num2 = stack.pop();
				int calResult = 0;
				
				switch(c) {
				case '+':
					calResult = num1+ num2;
					break;
					
				case '-' :
					calResult = num2 - num1; //계산 순서 주의
					break;
				
				case'*':
					calResult = num2 * num1;
					break;
					
				case '/':
					calResult = num2 / num1;
					break;
				}
				stack.push(calResult); //연산한 결과 push
				
			}
		}
		return stack.pop(); //가장 마지막에 남은 값이 계산의 최종 결과
	}
	
	//후위표기법으로 변환
	private static String infixToPostfix(String str) { 
		Stack<Character> stack = new Stack<Character>();
		StringBuilder result = new StringBuilder();
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '(') stack.push(c); //여는괄호는 stack에 push
			else if(c >= '0' && c <= '9') result.append(c); //피연산자는 바로 출력
			else if(c == ')') { //닫는 괄호라면
				char popItem = stack.pop();
				while(popItem != '(') { //여는 괄호가 나올 때까지 pop
					result.append(popItem);
					popItem = stack.pop();
				}
			} else { //연산자라면, 자신보다 우선순위가 낮은 연산자가 나올 때까지 pop
				while(!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) >= map.get(c)) {
					char popItem = stack.pop();
					result.append(popItem);
				}
				stack.push(c);
			}
			
		}
		while(!stack.isEmpty()) { //스택 비워주기
			result.append(stack.pop());
		}
		return result.toString();
		
	}

}
