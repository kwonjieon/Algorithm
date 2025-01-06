import java.util.*;
import java.io.*;
public class Main{
    static int n;
    static int m;
    static int[][] map = new int[n][m];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visit;
    static Queue<point> tmp = new LinkedList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int oneCount = 0;
        int time=0;
        int lastCount=0;
        while(!isAllZero()){

            visit = new boolean[n][m];

            bfs(new point(0,0));

            lastCount = tmp.size();
            time++;
            while(!tmp.isEmpty()){
                point p2 =tmp.poll();
                map[p2.y][p2.x]=0;
            }

        }
        System.out.println(time);
        System.out.println(lastCount);


    }
    static void bfs(point p){
        Queue<point> q = new LinkedList<>();


        visit[p.y][p.x] = true;
        q.offer(p);
        while(!q.isEmpty()){
            point p1 = q.poll();
            for(int i=0;i<4;i++){
                int nx = p1.x+dx[i];
                int ny = p1.y+dy[i];
                if(nx>=m||ny>=n||nx<0||ny<0)
                    continue;
                if(visit[ny][nx])
                    continue;
                if(map[ny][nx]==0){
                    q.offer(new point(nx,ny));
                    visit[ny][nx] = true;
                }
                else{
                    tmp.offer(new point(nx,ny));
                    visit[ny][nx] = true;
                }

            }
        }





    }
    static boolean isAllZero(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==1){
                    return false;
                }
            }
        }
        return true;
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