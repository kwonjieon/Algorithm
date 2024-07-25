import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        Stack<Character> stk = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int count=0;
        int index=0;
        while(index<str.length()&&count<K){
            if(stk.isEmpty()){
                stk.push(str.charAt(index));
                index++;
                continue;
            }
            if(stk.peek()-'0'<str.charAt(index)-'0'){
                stk.pop();
                count++;
            }
            else{
                stk.push(str.charAt(index));
                index++;
            }
        }
        while(index<str.length()){
            stk.push(str.charAt(index));
            index++;
        }
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        sb.reverse();
        str = sb.toString();
        System.out.println(str.substring(0,str.length()-(K-count)));
    }
}