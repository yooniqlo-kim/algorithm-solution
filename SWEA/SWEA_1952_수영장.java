import java.util.*;
import java.io.*;

public class SWEA_1952_수영장 {
	static int[] days;
	static int dailyFee, monthlyFee, yearlyFee, threeMonthFee, minFee;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			dailyFee= Integer.parseInt(st.nextToken()); monthlyFee = Integer.parseInt(st.nextToken()); threeMonthFee = Integer.parseInt(st.nextToken()); yearlyFee = Integer.parseInt(st.nextToken());
			
			days = new int[12];
			st = new StringTokenizer(br.readLine().trim());
			for(int i=0; i<days.length; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			minFee = yearlyFee;
			dfs(0,0);
			
			sb.append("#").append(t+1).append(" ").append(minFee).append("\n");
		} //end testcase
		
		bw.write(sb.toString()); bw.close(); br.close();
		
	} //end main
	
	private static void dfs(int month, int currentFee) {
		if(currentFee >= minFee) return;
		
		if(month >= 12) {
			minFee = Math.min(currentFee, minFee);
			return;
		}
		
		if(days[month] == 0) dfs(month+1,currentFee);
		else {
			dfs(month+1, currentFee + days[month] * dailyFee);
			dfs(month+1, currentFee + monthlyFee);
			dfs(month +3, currentFee + threeMonthFee);
		}
		
	}
}
