import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] lengthArr = new int[6];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int perSquare = Integer.parseInt(br.readLine().trim()); //1m2의 넓이에 자라는 참외의 개수
        int maxWidth=0, minWidth=Integer.MAX_VALUE, maxWidthIdx=-1;
        int maxHeight=0, minHeight=Integer.MAX_VALUE, maxHeightIdx=-1;

        for(int i=0; i<6; i++){ //육각형 꼭짓점 순회
            st = new StringTokenizer(br.readLine().trim());
            int direction = Integer.parseInt(st.nextToken());
            lengthArr[i] = Integer.parseInt(st.nextToken());
            // 동 1 서 2
            if(direction == 1 || direction == 2) {
                maxWidth = Math.max(maxWidth, lengthArr[i]);
                if (lengthArr[i] == maxWidth) maxWidthIdx = i;
            } //남 3 북 4
            else if(direction == 3 || direction == 4){
                maxHeight = Math.max(maxHeight, lengthArr[i]);
                if(lengthArr[i] == maxHeight) maxHeightIdx = i;
            }
        }//end for
        minWidth = findMinLength(maxWidthIdx);
        minHeight = findMinLength(maxHeightIdx);
        int result = ((maxHeight * maxWidth) - (minHeight * minWidth)) * perSquare;
        System.out.println(result);

    }//end main
    public static int findMinLength(int idx){
        if(idx == 0) return Math.abs(lengthArr[1]-lengthArr[5]);
        else if(idx == 5) return Math.abs(lengthArr[4] - lengthArr[0]);
        else return Math.abs(lengthArr[idx-1] - lengthArr[idx+1]);
    }
}//end class
