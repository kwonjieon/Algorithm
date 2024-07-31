import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[1]-o2[1];
            }
        });
        int cur = targets[0][1];
        
        for(int[] x:targets){
            if(cur<=x[0]){
                cur=x[1];
                answer++;
            }
        }
        
        return answer;
    }
}