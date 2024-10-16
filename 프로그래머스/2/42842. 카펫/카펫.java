class Solution {
    public static void main(String[] args) throws Exception{
        System.out.println(solution(10,2));
    }

    public static int[] solution(int brown, int yellow) {
        int x=0;
        int y=0;
        for(int i=1; i<=yellow; i++) {
            if(yellow % i != 0) continue;
            x = i;
            y = yellow / i;


            if((x + y) * 2 + 4 == brown) break;
        }
        int width = Math.max(x,y)+2;
        int height = Math.min(x,y)+2;
        return new int[]{width,height};
    }
}