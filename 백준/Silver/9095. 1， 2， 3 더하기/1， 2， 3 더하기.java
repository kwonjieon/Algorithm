import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4;i<=11;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        for(int test_case=0;test_case<T;test_case++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
             
        }
        
    }
}