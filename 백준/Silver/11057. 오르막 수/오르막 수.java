import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][11];
        for(int i=1;i<=10;i++){
            dp[1][i] = 1;
        }
        for(int i=1;i<=N;i++){
            dp[i][1] = 1;
        }
        if(N==1){
            System.out.println("10");
            return;
        }
        for(int i=2;i<=N;i++){
            for(int j=2;j<=10;j++){
                dp[i][j] = (dp[i-1][j]+dp[i][j-1])%10007;
            }
        }
        int sum=0;
        for(int i=1;i<=10;i++){
            sum+=dp[N][i];
        }
        System.out.println(sum%10007);
    }
}