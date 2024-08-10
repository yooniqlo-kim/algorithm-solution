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
		List<Integer> targetRowList = new ArrayList<Integer>();
		List<Integer> targetColList = new ArrayList<Integer>();
		
		int N = Integer.parseInt(br.readLine().trim()); // 잘라야 하는 점선의 개수
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int rowColCheck = Integer.parseInt(st.nextToken()); // 0이면 가로줄, 1이면 세로줄
			
			if (rowColCheck == 0) {
				targetRowList.add(Integer.parseInt(st.nextToken()));
			} else if (rowColCheck == 1) {
				targetColList.add(Integer.parseInt(st.nextToken()));
			}		
		}
		targetRowList.add(height);
		targetRowList.add(0);
		targetColList.add(width);
		targetColList.add(0);
		
		Collections.sort(targetRowList);
		Collections.sort(targetColList);
		
		int maxRowLen = 0, maxColLen = 0;
		
		for(int i=1; i<targetRowList.size(); i++) {
			int tmp = targetRowList.get(i)-targetRowList.get(i-1);
			maxColLen = Math.max(maxColLen, tmp);
		}
		
		for(int i=1; i<targetColList.size(); i++) {
			int tmp = targetColList.get(i) - targetColList.get(i-1);
			maxRowLen = Math.max(maxRowLen, tmp);
		}
		
		int result = maxRowLen * maxColLen;
		
		System.out.println(result);
		


	}// end main

} //end class

