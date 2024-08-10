import java.util.*;
import java.io.*;

public class Main { 
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
	
		st = new StringTokenizer(br.readLine().trim());
		int width = Integer.parseInt(st.nextToken()); // 종이의 가로 길이
		int height = Integer.parseInt(st.nextToken()); // 종이의 세로 길이
		
		// 가로줄과 세로줄 점선 위치를 저장하는 리스트
		List<Integer> targetRowList = new ArrayList<Integer>(); //가로줄의 점선위치
		List<Integer> targetColList = new ArrayList<Integer>(); //세로줄의 점선 위치
		
		int N = Integer.parseInt(br.readLine().trim()); // 잘라야 하는 점선의 개수
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int rowColCheck = Integer.parseInt(st.nextToken());
			
			if (rowColCheck == 0) {  // 0이면 가로줄
				targetRowList.add(Integer.parseInt(st.nextToken()));
			} else if (rowColCheck == 1) { // 1이면 세로줄
				targetColList.add(Integer.parseInt(st.nextToken()));
			}		
		}
		
		targetRowList.add(height); //종이의 세로 길이 추가
		targetRowList.add(0);
		targetColList.add(width); //종이의 가로 길이 추가
		targetColList.add(0);
		
		Collections.sort(targetRowList); //오름차순 정렬
		Collections.sort(targetColList);
		
		int maxRowLen = 0, maxColLen = 0;
		
		// 가로점선 잘랐을 때, 최대 세로 길이 계산
		for(int i=1; i<targetRowList.size(); i++) {
			int tmp = targetRowList.get(i)-targetRowList.get(i-1);
			maxColLen = Math.max(maxColLen, tmp);
		}
		
		// 세로점선 잘랐을 때, 최대 가로 길이 계산
		for(int i=1; i<targetColList.size(); i++) {
			int tmp = targetColList.get(i) - targetColList.get(i-1);
			maxRowLen = Math.max(maxRowLen, tmp);
		}
		
		int result = maxRowLen * maxColLen; //최대 넓이 계산
		
		System.out.println(result);
		


	}// end main

} //end class

