import java.util.*;
import java.io.*;

public class Main { 
	static int n = 7;
	static int total = 9;
	static int[] height = new int[total]; //난쟁이 키
	static int[] dwarf;
	static StringBuilder sb = new StringBuilder(100);
	static boolean isFind;
	
	public static void main(String[] args) throws Exception{ 
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		dwarf = new int[n];
		
		for(int i=0; i<9; i++) {
			height[i] = Integer.parseInt(br.readLine().trim());
		}
		
		findDwarf(0,0);
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}//end main
	
	public static void findDwarf(int d, int start){
		if(isFind) return;
		if(d == n) { 
			
			int sum = 0;
			for(int i=0; i<n; i++) {
				sum += dwarf[i];
			}
			
			if(sum == 100) {
				Arrays.sort(dwarf);
				for(int dw : dwarf) {
					sb.append(dw).append("\n");
				}
				isFind = true;
			}
			return;
		}
		
		for(int i=start; i<total; i++) {
			dwarf[d] = height[i];
			findDwarf(d+1, i+1);
		
		}

	}// end method

}//end class