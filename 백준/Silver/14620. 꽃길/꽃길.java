import java.util.*;
import java.io.*;
public class Main{
    static int[][] map;
    static boolean[][] visit;
    static int n;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n][n];
        visit = new boolean[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<n-1;i++){
            for(int j=1;j<n-1;j++) {
                toggle(j,i);
                dfs(0, j, i, map[i][j]+map[i-1][j]+map[i+1][j]+map[i][j-1]+map[i][j+1]);
                toggle(j,i);
            }
        }
        System.out.println(min);

    }
    static void dfs(int depth,int x,int y,int sum){
        if(sum>=min) return;
        if(depth==2){
            if(min>sum){
                min=sum;
            }
        }
        for(int i=y;i<n-1;i++){
            for(int j=1;j<n-1;j++){
                if(!visit[i][j]&&!visit[i-1][j]&&!visit[i+1][j]&&!visit[i][j-1]&&!visit[i][j+1]){
                    toggle(j,i);
                    dfs(depth+1,j,i,sum+map[i][j]+map[i-1][j]+map[i+1][j]+map[i][j-1]+map[i][j+1]);
                    toggle(j,i);
                }
            }
        }



    }
    static void toggle(int x,int y){
        visit[y][x]=!visit[y][x];

        visit[y-1][x]=!visit[y-1][x];
        visit[y+1][x]=!visit[y+1][x];
        visit[y][x-1]=!visit[y][x-1];
        visit[y][x+1]=!visit[y][x+1];
    }
}