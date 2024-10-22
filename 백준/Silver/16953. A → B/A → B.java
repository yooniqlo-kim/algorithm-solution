import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

		System.out.println(bfs(A,B));
	}// end main

	private static int bfs(long start, long end) {
		int count = 1;
		Queue<Long> queue = new ArrayDeque<>();
		Set<Long> visited = new HashSet<>();
		queue.offer(start);
		 visited.add(start);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				 long current = queue.poll();
				
				if(current == end) return count;
				long twice = 2 * current;
                long addOne = current * 10 + 1;
				
                if (twice <= end && !visited.contains(twice)) {
                    queue.offer(twice);
                    visited.add(twice);
                }
				
                if (addOne <= end && !visited.contains(addOne)) {
                    queue.offer(addOne);
                    visited.add(addOne);
                }

			}
			count++;
		}
		return -1;
	}

} //end class

