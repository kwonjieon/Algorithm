import java.util.*;
import java.io.*;
public class Main{
    static int N;
    static int[][] map;
    static int[] dx = {1,1,0};//시계방향
    static int[] dy = {0,1,1};


    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();



    }
    static void bfs(){
        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(1,0,0));
        int count=0;
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0;i<3;i++){
                if(p.dir==0&&i==2) continue;
                else if(p.dir==2&&i==0) continue;
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx>=N||ny>=N||nx<0||ny<0) continue;
                if(map[ny][nx]==1) continue;
                if(i==1) {
                    if (map[p.y][p.x + 1] == 1 || map[p.y + 1][p.x] == 1)
                        continue;
                }
                if(ny==N-1&&nx==N-1){
                    count++;
                    continue;
                }

                q.offer(new Point(nx,ny,i));

            }
        }
        System.out.println(count);


    }
    static class Point{
        int x;
        int y;
        int dir;
        Point(int x,int y,int dir){
            this.x=x;
            this.y=y;
            this.dir=dir;
        }
    }
}