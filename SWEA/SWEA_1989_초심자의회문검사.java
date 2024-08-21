import java.util.*;
import java.io.*;

public class SWEA_1989_초심자의회문검사{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);
		
		int T = Integer.parseInt(br.readLine().trim()); //테스트케이스 
		
		for(int t=0; t<T; t++) {
			int result = 1; //회문 여부를 판단하기 위한 변수 (회문이 아니면 0)
			String[] str = br.readLine().trim().split("");
			
			for(int i=0; i<str.length/2; i++) {  //문자열의 절반까지만 반복 (회문은 양쪽에서 비교하므로)
				if(!str[i].equals(str[str.length-1-i])) //앞과 뒤에서 같은 위치에 있는 문자가 다른 경우
					result = 0; //회문이 아니다
			}
			
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
		}//end testcase
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}

}
