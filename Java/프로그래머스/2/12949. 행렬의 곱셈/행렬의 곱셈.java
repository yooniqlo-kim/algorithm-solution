import java.util.*;
import java.io.*;

//행렬의 곱셈
// 1 4   3 3
// 3 2 * 3 3
// 4 1
// (3 * 2) * (2 * 2) => (3 * 2)

//

public class Solution {
    public static void main(String[] args) {

        int[][] arr1 = {{1,4}, {3,2}, {4,1}};
        int[][] arr2 = {{3,3}, {3,3}};

        int[][] arr3 = {{2,3,2}, {4,2,4}, {3,1,4}};
        int[][] arr4 = {{5,4,3}, {2,4,1}, {3,1,1}};
        int[][] result = solution(arr1,arr2);
        int[][] result2 = solution(arr3,arr4);


    }
    public static int[][] solution(int[][] arr1, int[][] arr2) {

        int row1 = arr1.length; //행렬 곱의 행
        int col1 = arr1[0].length;
        int row2 = arr2.length;
        int col2 = arr2[0].length; //행렬 곱의 열

        int[][] result = new int[row1][col2];

        for(int i=0; i<row1; i++) { //arr1 행 순회
            for (int j = 0; j < col2; j++) {    //arr2 열 순회

                for (int k = 0; k < row2; k++) {    //arr1의 열 & arr2행 순회 (row2 와 col1 둘다 가능)
                    result[i][j] += arr1[i][k] * arr2[k][j];  //result[0][0] = arr1[0][0] * arr2[0][0] + arr1[0][1] * arr2[1][0]
                }
            }
        }
        //System.out.println(Arrays.deepToString(result));


        return result;

    }
}
