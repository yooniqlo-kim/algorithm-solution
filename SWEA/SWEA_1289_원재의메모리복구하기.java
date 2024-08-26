import java.util.*;
import java.io.*;

public class SWEA_1289_원재의메모리복구하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);
		
		int T = Integer.parseInt(br.readLine().trim()); 
		
		for(int t=0; t<T; t++) {
			
			String str = br.readLine().trim();
			
			int cnt = 0;
			if(str.charAt(0)!='0') cnt++; //첫 문자가 1이면 cnt 1 증가
			for(int i=0; i<str.length()-1; i++) { 
				if(str.charAt(i) != str.charAt(i+1)) cnt++; //현재 문자와 다음 문자가 일치하지 않으면,cnt 증가
			}
			
			sb.append("#").append(t+1).append(" ").append(cnt).append("\n");
			
		}//end testcase
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}
