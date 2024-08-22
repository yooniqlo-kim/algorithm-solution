import java.io.*;
import java.util.*;

public class SWEA_1217_거듭제곱 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);
		
		for(int t=0; t<10; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int num = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			sb.append("#").append(t+1).append(" ").append(mul(num,n)).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}//end main
	
	private static int mul(int num, int n) {
		if(n==0) {
			return 1;
		}
		
		return num * mul(num, n-1);
	}

}
