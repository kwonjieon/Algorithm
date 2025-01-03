import java.util.*;
import java.io.*;
public class Main{
    static final int INF = 100000000;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j){
                    map[i][j]=0;
                    continue;
                }
                map[i][j] = INF;
            }
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map[start][end] = Math.min(map[start][end],value);
        }
        //경유지
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    map[i][j] = Math.min(map[i][j],map[i][k]+map[k][j]);
                }
            }
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(map[i][j]==INF){
                    map[i][j]= 0;
                }
            }
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                //System.out.print(map[i][j]+" ");
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}