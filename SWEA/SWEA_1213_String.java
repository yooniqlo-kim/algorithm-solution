import java.util.*;
import java.io.*;
public class SWEA_1213_String {

	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);
		
		for(int t=0; t<10; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			String pattern = br.readLine().trim(); //검색할 패턴 문자열
			String text = br.readLine().trim(); //검색 대상이 되는 전체 문자열
			
			sb.append("#").append(N).append(" ").append(bruteForce(text, pattern)).append("\n");

		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	private static int bruteForce(String text, String pattern) {
		int cnt = 0; //패턴이 텍스트에 등장한 횟수를 저장할 변수
		int ti=0, pi=0; //텍스트의 인덱스, 패턴의 인덱스
		
		while(ti < text.length()) { //텍스트 전체를 탐색
			if(text.charAt(ti) != pattern.charAt(pi)) { //텍스트와 패턴의 현재 위치 문자가 일치하지 않으면
				ti -= pi; //텍스트 인덱스를 원래 위치로 되돌림
				pi = -1; //패턴 인덱스 초기화
			}
			ti++; //텍스트 인덱스를 다음 위치로 이동
			pi++; //패턴 인덱스를 다음 위치로 이동
			
			if(pi == pattern.length()) { //패턴의 모든 문자가 일치한다면
				cnt ++; //횟수 증가
				pi = 0; //패턴 인덱스 초기화 후, 새로운 검색 시작
			}
		}//end while
		return cnt;
	}//end method

}
