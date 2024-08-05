import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++){
            pq.offer(scoville[i]);
        }
        while(true){
            if(pq.size()==1)
                break;
            int x1 = pq.poll();
            int x2 = pq.poll();
            
            if(x1>=K){
                pq.offer(x1);
                pq.offer(x2);
                break;
            }
            pq.offer(x1+(x2*2));
            answer++;
        }
        if(pq.peek()<K)
            answer=-1;
        return answer;
    }
}