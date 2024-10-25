import java.util.*;

class Solution {
   	 public int solution(int[] nums) {
	      	int size = nums.length;
	      	Set<Integer> set = new HashSet<>();
	      	
	      	for(int i=0; i<size; i++) {
	      		set.add(nums[i]);
	      	}
	      	
	      	if(set.size()>=size/2) {
	      		return size/2;
	      	}
	      	return set.size();
	 }
}