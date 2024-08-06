import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("src/김윤/A019_SWEA_5432_쇠막대기자르기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int t=0; t<T; t++) {
			String sticks = br.readLine().trim();
			sb.append("#").append(t+1).append(" ").append(pieces(sticks)).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}//end main
	
	public static int pieces(String sticks) {
	    Stack<Character> stack = new Stack<>();
	    int cnt = 0;

	    for (int i = 0; i < sticks.length(); i++) {
	        char c = sticks.charAt(i);

	        if (c == '(') {
	            stack.push(c);
	        } else {
	            if (sticks.charAt(i-1) == '(') {
	                // 레이저를 만난 경우
	                stack.pop();
	                cnt += stack.size();
	            } else {
	                // 막대기의 끝을 만난 경우
	                stack.pop();
	                cnt++;
	            }
	        }
	    }//end for

	    return cnt;
	}

}