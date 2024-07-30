import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> temp = new Stack<>();
        int index=0;
        for(int i=1;i<=order.length;i++){//상자번호
            
            while(!temp.isEmpty()&&temp.peek()==order[index]){
                index++;
                temp.pop();
            }
            if(i==order[index]){
                index++;
            }
            else if(i!=order[index]){
                temp.push(i);
            }
            
        }
        while(!temp.isEmpty()&&temp.peek()==order[index]){
            index++;
            temp.pop();
        }
        
        return index;
    }
}