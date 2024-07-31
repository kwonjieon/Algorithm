import java.util.*;
class Solution {
    static boolean[] visit;
    static int depth;
    public int solution(int[] cards) {
        int answer = 0;
        int n = cards.length;
        List<Integer> list = new LinkedList<>();
        visit = new boolean[n];
        for(int i=0;i<n;i++){
            
            depth=0;
            dfs(i,cards);
            list.add(depth);
            
        }
        Collections.sort(list,Collections.reverseOrder());
        list.sort(Collections.reverseOrder());
        if(list.size()<2)
            return 0;
        answer=list.get(0)*list.get(1);
        
        return answer;
    }
    public void dfs(int x,int[] cards){
        if(!visit[x]){
            visit[x]=true;
            depth++;
            dfs(cards[x]-1,cards);
        }
        
    }
}