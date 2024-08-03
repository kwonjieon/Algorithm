import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        if(set.size()>=n/2){
            answer=n/2;
        }
        else{
            answer=set.size();
        }
        
        
        
        return answer;
    }
}