import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int x: tangerine){
            if(hm.containsKey(x))
                hm.put(x,hm.get(x)+1);
            else{
                hm.put(x,1);
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
            list.add(entry.getValue());
        }
        Collections.sort(list,Collections.reverseOrder());
        int sum=0;
        
        for(int x: list){
            sum+=x;
            answer++;
            if(sum>=k)
                break;
        }
        
        
        
        return answer;
    }
}