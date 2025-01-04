import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] ans = new int[N+1];
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stk = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            if(stk.isEmpty()){
                ans[i] = 0;
                stk.push(i);
                continue;
            }
            if(arr[stk.peek()]<arr[i]){
                while(!stk.isEmpty()){
                    if(arr[stk.peek()]<arr[i]){
                        stk.pop();
                    }
                    else{
                        break;
                    }
                }
                if(stk.isEmpty()){
                    ans[i]=0;
                }
                else{
                    ans[i] = stk.peek();
                }
                stk.push(i);
            }
            else{
                ans[i] = stk.peek();
                stk.push(i);
            }

        }
        for(int i=1;i<=N;i++){
            sb.append(ans[i]+" ");
        }
        System.out.println(sb);
    }
}