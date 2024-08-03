import java.util.*;
class Solution {
    public String[] solution(String[] names) {
       // 0번째 5번째 10번째 .. 반환
       // i % 5 == 0 인 인덱스 반환
        
        List<String> list = new ArrayList<>();

        //인덱스가 필요하기 때문에 for문
        for(int i =0; i<names.length; i++) {
            if (i % 5 == 0) {
                list.add(names[i]);
            }
        }
        
        return list.toArray(new String[list.size()]);
    }
}