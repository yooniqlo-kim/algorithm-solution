
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);
		
		for(int t=0; t<4; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int targetX = Integer.parseInt(st.nextToken());
			int targetY = Integer.parseInt(st.nextToken());
			int targetP = Integer.parseInt(st.nextToken());
			int targetQ = Integer.parseInt(st.nextToken());
			
			
			if(x > targetP || p < targetX || y > targetQ || q < targetY) sb.append("d").append("\n");
			else if((targetP==x && targetY==q) || (targetX==p&&targetY==q) || (targetP==x&&targetQ==y) || (targetX==p&&targetQ==y)) sb.append("c").append("\n");
			else if(targetQ == y || targetP == x || targetX == p || targetY ==q) sb.append("b").append("\n");
			else sb.append("a").append("\n");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}
