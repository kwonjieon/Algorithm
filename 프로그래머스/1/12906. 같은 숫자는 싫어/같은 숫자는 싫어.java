import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stk = new Stack<>();
        int n = arr.length;
        for(int i=n-1;i>=0;i--){
            if(stk.isEmpty()){
                stk.push(arr[i]);
                continue;
            }
            if(stk.peek()!=arr[i]){
                stk.push(arr[i]);
            }
        }
        answer=new int[stk.size()];
        int i=0;
        while(!stk.isEmpty()){
            answer[i++]=stk.pop();
        }

        return answer;
    }
}