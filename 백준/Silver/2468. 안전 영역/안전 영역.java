import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max=0;
        for(int k=0;k<=100;k++){//물높이
            int count=0;
            visit = new boolean[n][n];
            for(int i=0;i<n;i++){//y
                for(int j=0;j<n;j++){//x
                    if(map[i][j]>k&&!visit[i][j]){
                        bfs(j,i,k);
                        count++;
                    }
                }
            }
            if(count==0)
                break;
            max=Math.max(max,count);
        }
        System.out.println(max);

    }
    static void bfs(int x,int y,int rain){
        Queue<point> q = new LinkedList<>();
        q.offer(new point(x,y));
        visit[y][x]=true;
        while(!q.isEmpty()){
            point p = q.poll();
            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx>=n||ny>=n||nx<0||ny<0)
                continue;
                if(map[ny][nx]>rain&&!visit[ny][nx]){
                    visit[ny][nx]=true;
                    q.offer(new point(nx,ny));
                }
            }

        }

    }
    static class point{
        int x;
        int y;
        point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}