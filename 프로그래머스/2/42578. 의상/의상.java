import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> hm = new HashMap<>();
        Set<String> set = new HashSet<>();
        int n = clothes.length;
        for(int i=0;i<n;i++){
            if(!set.contains(clothes[i][0])){
                hm.put(clothes[i][1],hm.getOrDefault(clothes[i][1],1)+1);
            }
        }
        for(Map.Entry<String,Integer> entry : hm.entrySet()){
            answer*=entry.getValue();
            
        }
        return answer-1;
    }
}