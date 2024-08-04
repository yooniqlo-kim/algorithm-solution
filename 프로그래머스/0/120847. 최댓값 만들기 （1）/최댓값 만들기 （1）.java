class Solution {
    public int solution(int[] numbers) {
        
        int max = 0;
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                int mul = numbers[i] * numbers[j];
                max = Math.max(max, mul);
            }
        }
        
        return max;
    }
}