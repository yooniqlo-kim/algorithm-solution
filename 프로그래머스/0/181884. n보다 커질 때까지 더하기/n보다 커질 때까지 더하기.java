class Solution {
    public int solution(int[] numbers, int n) {
        int sum = 0;

        for(int c : numbers){
            sum += c;
            if(sum > n)
                break;
        }
        
        return sum;
    }
}