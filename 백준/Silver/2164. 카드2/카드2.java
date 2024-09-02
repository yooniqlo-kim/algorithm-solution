import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim()); int num = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<N+1; i++) queue.add(i);

        while(queue.size() > 1) {
            queue.poll();
            num = queue.poll();
            queue.offer(num);
        }
        System.out.println(queue.poll());
    }//end main
}
