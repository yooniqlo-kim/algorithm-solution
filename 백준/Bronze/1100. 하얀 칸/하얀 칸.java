import java.util.*;
import java.io.*;

// 00 01 02 03 04 05 06 07 //짝수 행: i+j가 짝수인 행이 흰색
// 10 11 12 13 14 15 16 17 //홀수 행: i+j가 짝수인 행이 흰색
// ...

public class Main {
public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);
        int size = 8;
        int cnt = 0;
        char[][] arr = new char[size][size];

        //배열 입력받기
        for(int i=0; i<size; i++){
            String str = br.readLine().trim(); //한 줄씩 문자열을 읽어
            for(int j=0; j<size; j++) {
                arr[i][j] = str.charAt(j);    //문자형으로 변환하여 배열에 넣기
            }
        }

        // 행과 열을 더한 값이 짝수이고
        // 그 자리에 말이 있다면 카운트 증가
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if( (i+j) % 2 == 0 && arr[i][j] == 'F'){
                    cnt++;
                }
            }
        }
        sb.append(cnt);
        bw.write(sb.toString());
        bw.close();
        br.close();

    }
}