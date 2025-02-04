import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] ans = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            //ans[i] = -1;
        }
        Stack<Integer> stk = new Stack<>();
        //stk.push(0);
        for(int i=0;i<N;i++){
            if(stk.isEmpty()){
                stk.push(i);
                continue;
            }
            while(!stk.isEmpty()){
                if(arr[stk.peek()]<arr[i]){
                    ans[stk.pop()] = arr[i];
                }
                else break;
            }
            stk.push(i);

        }
        while(!stk.isEmpty()){
            ans[stk.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(ans[i]+" ");
        }
        System.out.println(sb);
    }
}