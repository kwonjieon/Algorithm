import java.util.*;
import java.io.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer>  q = new LinkedList<>();
        int curWeight=0;
        for(int i=0;i<truck_weights.length;i++){
            int truck = truck_weights[i];
            
            while(true){
                if(q.isEmpty()){
                    q.add(truck);
                    answer++;
                    curWeight+=truck;
                    break;
                }
                else if(q.size()==bridge_length){
                    curWeight-=q.poll();
                }
                else {
                    if(curWeight+truck<=weight){
                        q.add(truck);
                        answer++;
                        curWeight+=truck;
                        break;
                    }
                    else{
                        q.add(0);
                        answer++;
                    }
                    
                    
                }
            }
            
        }
        return answer+bridge_length;
    }
}