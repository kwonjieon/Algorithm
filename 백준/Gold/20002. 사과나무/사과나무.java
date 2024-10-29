import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][n+1];
        int[][] subSum = new int[n+1][n+1];
        StringTokenizer st;
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                dp[i][j]=map[i][j];
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                subSum[i][j]=subSum[i-1][j]+subSum[i][j-1]-subSum[i-1][j-1]+map[i][j];
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int max=dp[i][j];
                int ny=i;
                int nx=j;
                while(true){
                    nx++;
                    ny++;
                    if(nx>n||ny>n){
                        break;
                    }
                    int temp = subSum[ny][nx]-subSum[i-1][nx]-subSum[ny][j-1]+subSum[i-1][j-1];
                    if(max<temp){
                        max=temp;
                    }
                }
                dp[i][j]=max;
            }
        }
        int answer=-1001;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(dp[i][j]>answer){
                    answer = dp[i][j];
                }
            }
        }
        System.out.println(answer);
    }
}