import java.io.BufferedReader;
import java.io.InputStreamReader;

// 중복o , 순서o => 중복순열
public class Main {
    static StringBuilder sb;
    static int[] selected;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] str = br.readLine().trim().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        selected = new int[M];
        permutation(N,M,0);

        System.out.println(sb.toString().trim());

    }

    private static void permutation(int N, int M, int idx) {
        if(idx == M) {
            for(int i=0; i<M; i++) sb.append(selected[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++) {
            selected[idx] = i;
            permutation(N,M,idx+1);
        }
    }
}
