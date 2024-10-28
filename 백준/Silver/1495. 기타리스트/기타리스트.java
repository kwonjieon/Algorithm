import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] V = new int[N+1];
        boolean[][] dp = new boolean[N+1][M+1];
        st = new StringTokenizer(br.readLine());
        dp[0][S]=true;
        for(int i=1;i<=N;i++){
            V[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++){
            for(int j=0;j<=M;j++){
                if(dp[i-1][j]){
                    int plus = j+V[i];
                    int minus = j-V[i];
                    if(plus<=M){
                        dp[i][plus]=true;
                    }
                    if(minus>=0){
                        dp[i][minus]=true;
                    }
                }
            }
        }
        int last = -1;
        for(int i=M;i>=0;i--){
            if(dp[N][i]){
                last=i;
                break;
            }
        }
        System.out.println(last);

    }
}