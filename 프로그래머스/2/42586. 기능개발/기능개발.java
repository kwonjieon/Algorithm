import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int n = speeds.length;
        int day=0;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            
            while(progresses[i]+(speeds[i]*day)<100){
                day++;
            }
            q.offer(day);
        }
        int count=0;
        int pre = q.poll();
        for(int x:q){
            count++;
            if(pre<x){
                list.add(count);
                count=0;
                pre=x;
            }
        }
        list.add(count+1);
        return list;
    }
}