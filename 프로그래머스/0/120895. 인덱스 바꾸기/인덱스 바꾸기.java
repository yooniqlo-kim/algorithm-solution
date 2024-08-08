class Solution {
	public String solution(String my_string, int num1, int num2) {

		StringBuilder sb = new StringBuilder();
		
		char [] charArr = my_string.toCharArray();
		char tmp = charArr[num1];
		charArr[num1] = charArr[num2];
		charArr[num2] = tmp;
		
		for(int i=0; i<charArr.length; i++) {
			sb.append(charArr[i]);
		}
		return sb.toString();
}
}