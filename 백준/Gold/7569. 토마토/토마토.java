import java.util.*;
import java.io.*;
public class Main{
    static int H;
    static int M;
    static int N;
    static int[][][] map;
    static boolean[][][] visit;
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dh = {0,0,0,0,-1,1};
    static Queue<point> q = new LinkedList<>();
    
    public static void main(String[] args)throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());//x
        N = Integer.parseInt(st.nextToken());//y
        H = Integer.parseInt(st.nextToken());//h
        map = new int[H][N][M];
        visit = new boolean[H][N][M];
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<M;k++){
                    int value = Integer.parseInt(st.nextToken());
                    map[i][j][k] = value;
                    if(value==1){
                        visit[i][j][k]=true;
                        q.offer(new point(k,j,i));
                    }
                }
            }
        }
        int answer = bfs();
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(map[i][j][k]==0){
                        answer=-1;
                    }
                }
            }
        }
        System.out.println(answer);
        
    }
    static int bfs(){
        int count=0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                point p = q.poll();
                for(int j=0;j<6;j++){
                    int nx = p.x+dx[j];
                    int ny = p.y+dy[j];
                    int nh = p.h+dh[j];
                    if(nx>=M||ny>=N||nh>=H||nx<0||ny<0||nh<0)
                        continue;
                    if(map[nh][ny][nx]==0&&!visit[nh][ny][nx]){
                        map[nh][ny][nx]=1;
                        visit[nh][ny][nx]=true;
                        q.offer(new point(nx,ny,nh));
                    }
                }
                
            }
            count++;
        }
        return count-1;
        
    }
    static class point{
        int x;
        int y;
        int h;
        point(int x,int y,int h){
            this.x=x;
            this.y=y;
            this.h=h;
        }
    }
}