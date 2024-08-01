import java.util.*;
import java.io.*;
public class Main{
    static int n;
    static int[][] map;
    static boolean[][] visit;
    static LinkedList<Integer> list = new LinkedList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];
        
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==1&&!visit[i][j]){
                    bfs(j,i);
                }
            }
        }
        list.sort(null);
        System.out.println(list.size());
        for(int x: list){
            System.out.println(x);
        }
        
    }
    static void bfs(int x,int y){
        Queue<point> q = new LinkedList<>();
        q.offer(new point(x,y));
        visit[y][x]=true;
        int count=1;
        while(!q.isEmpty()){
            point p = q.poll();
            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx>=n||ny>=n||nx<0||ny<0)
                    continue;
                if(map[ny][nx]==1&&!visit[ny][nx]){
                    q.offer(new point(nx,ny));
                    visit[ny][nx]=true;
                    count++;
                }
                
            }
        }
        list.add(count);
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