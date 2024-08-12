import java.io.*;
import java.util.*;

public class Solution {
	static StringBuilder sb = new StringBuilder(100);
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("src/김윤/A037_SWEA_1926_간단한369게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine().trim());
		game369(N);
		bw.write(sb.toString());
		bw.close();
		br.close();

	}// end main
	
	public static void game369(int N) {
		String[] arr = new String[N+1];
	
		for(int i=1; i<N+1; i++) {
			arr[i] = Integer.toString(i);
		}
		
		for(int i=1; i<N+1; i++) {
				int cnt = 0;
				String[] splitArr = arr[i].split("");
				for(int s=0; s<splitArr.length; s++) {
					if(splitArr[s].equals("3") || splitArr[s].equals("6") || splitArr[s].equals("9") ) {
						cnt++;
					} 
				}
				if(cnt > 0) {
					for(int j=0; j<cnt; j++) {
						sb.append("-");
					}
				} else {
					sb.append(arr[i]);
				}
		if(i != N) sb.append(" ");
		}
	} //end method

}//end class
