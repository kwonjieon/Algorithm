import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0]=0;
        dp[1]=arr[1];
        if(n>=2){
            dp[2]=arr[2]+dp[1];
        }
        for(int i=3;i<=n;i++){
            dp[i] = Math.max(dp[i-1],Math.max(dp[i-2],dp[i-3]+arr[i-1])+arr[i]);
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(max<dp[i])
                max=dp[i];
        }
        System.out.println(max);
        
        
    }
}