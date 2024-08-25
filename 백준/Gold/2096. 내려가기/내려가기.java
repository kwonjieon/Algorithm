import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n+1][3];
        int[][] maxdp = new int[n+1][3];
        int[][] mindp = new int[n+1][3];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<=n;i++){
            maxdp[i][0]=Math.max(maxdp[i-1][0],maxdp[i-1][1])+arr[i][0];
            maxdp[i][1]=Math.max(Math.max(maxdp[i-1][0],maxdp[i-1][1]),maxdp[i-1][2])+arr[i][1];
            maxdp[i][2]=Math.max(maxdp[i-1][1],maxdp[i-1][2])+arr[i][2];
            
            mindp[i][0]=Math.min(mindp[i-1][0],mindp[i-1][1])+arr[i][0];
            mindp[i][1]=Math.min(Math.min(mindp[i-1][0],mindp[i-1][1]),mindp[i-1][2])+arr[i][1];
            mindp[i][2]=Math.min(mindp[i-1][1],mindp[i-1][2])+arr[i][2];
        
        }
        int max=Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            max=Math.max(maxdp[n][i],max);
            min=Math.min(mindp[n][i],min);
        }
        System.out.println(max+" "+min);
        
        
    }
}