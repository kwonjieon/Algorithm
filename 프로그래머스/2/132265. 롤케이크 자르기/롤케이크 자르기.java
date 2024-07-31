import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for(int x: topping){
            map2.put(x,map2.getOrDefault(x,0)+1);
        }
        for(int x:topping){
            map1.put(x,map1.getOrDefault(x,0)+1);
            if(map2.get(x)==1){
                map2.remove(x);
            }
            else{
                map2.replace(x,map2.get(x)-1);
            }
            if(map1.size()==map2.size())
                answer++;
        }
        return answer;
    }
}