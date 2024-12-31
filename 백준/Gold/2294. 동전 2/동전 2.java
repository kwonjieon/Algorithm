import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//n*k = 백만
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int[] dp = new int[k+1];
        for(int i=1;i<=n;i++){
            int tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp;
        }
        for(int i=1;i<=k;i++){
            for(int j=1;j<=n;j++){
                if(arr[j]==i){
                    dp[i]=1;
                }
                else if(arr[j]<i){
                    if(dp[i-arr[j]]!=0){
                        if(dp[i]!=0) {
                            dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                        }
                        else{
                            dp[i]=dp[i-arr[j]]+1;
                        }
                    }
                }
            }
        }
        if(dp[k]==0){
            System.out.println("-1");
        }
        else{
            System.out.println(dp[k]);
        }
    }
}