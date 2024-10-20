import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int N = stones.length;
        int min=1;            
        int max=200000000;
        int mid=0;
        while(min<=max){
            mid = (min+max)/2;
            if(canCross(stones,k,mid)){
                min=mid+1;
                answer=Math.max(mid,answer);
            }
            else{
                max=mid-1;
            }   
        }
        return answer;
    }
    public boolean canCross(int[] stones,int k, int friends){
        int skip=0;
        for(int i:stones){
            if(i<friends){
                skip++;
            }
            else{
                skip=0;
            }
            if(skip==k)
                return false;
        }
        return true;
    }
}
     