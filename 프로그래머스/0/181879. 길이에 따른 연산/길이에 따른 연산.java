class Solution {
    public int solution(int[] num_list) {
        
        int length = num_list.length;
        int result = 1;

        if(length >= 11){
            for(int n : num_list){
                result += n;
            } return result-1;
        } else {
            for(int n : num_list){
                result *= n;
            } return result;
        }

        
    }
}