import java.util.*;
import java.io.*;
public class SWEA_8931_제로 {

	public static void main(String[] args) throws Exception{
	
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int t=0; t<T; t++) {
			int K = Integer.parseInt(br.readLine().trim());
			Stack<Integer> stack = new Stack<>();
			int sum = 0;
			
			for(int k=0; k<K; k++) {
				int N = Integer.parseInt(br.readLine().trim());
				if(N!=0) stack.push(N); //0이 아니면 push
				else stack.pop(); //0이면 pop
			}
			
			while(!stack.isEmpty()) {
				sum += stack.pop();
			}
			
			sb.append("#").append(t+1).append(" ").append(sum).append("\n");
		}//end testcase
		bw.write(sb.toString());
		bw.close();
		br.close();

	}
	
}
