import java.util.*;
import java.io.*;

public class Main {
    static char[] alphabet;
    static char[] selected;
    static int L,C;
    static Set<String> set = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine().trim());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new char[C];
        selected = new char[L];
        st = new StringTokenizer(br.readLine().trim());
        for(int i=0; i<C; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphabet);
        combination(0,0);

        for(String password : set) {
            System.out.println(password);
        }
    }

    static void combination(int start, int depth) {
        if(depth==L) {
            StringBuilder sb = new StringBuilder();

            int mo=0;
            int ja=0;

            for(int i=0; i<L ;i++) {
                char c = selected[i];
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
                    mo++;
                } else {
                    ja++;
                }

                sb.append(c);
            }
            if(mo>=1 && ja>=2) {
                set.add(sb.toString());
            }

            return;
        }

        for(int i=start; i<C; i++) {
            selected[depth] = alphabet[i];
            combination(i+1, depth+1);
        }
    }

}
