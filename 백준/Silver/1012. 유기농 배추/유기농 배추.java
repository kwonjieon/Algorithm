import java.util.*;
import java.io.*;

public class Main{
    static int[][] map;
    static boolean[][] visit;
    static int[] dx ={0,0,-1,1};//상하좌우
    static int[] dy ={-1,1,0,0};
    static int M;
    static int N;

    public static void main(String[] args)throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for(int test_case=0;test_case<T;test_case++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visit = new boolean[N][M];

            int count=0;
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[y][x]=1;
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!visit[i][j]&&map[i][j]==1){
                        bfs(j,i);
                        count++;
                    }
                }
            }
            sb.append(count+"\n");

        }
        System.out.println(sb);

    }
    public static void bfs(int x,int y){
        Queue<point> q = new LinkedList<>();
        visit[y][x]=true;
        q.offer(new point(x,y));
        int count=0;
        while(!q.isEmpty()){
            point p = q.poll();
            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx>=M||ny>=N||nx<0||ny<0)
                    continue;
                if(map[ny][nx]==1&&!visit[ny][nx]){
                    q.offer(new point(nx,ny));
                    visit[ny][nx]=true;
                }

            }
        }

    }
    static class point{
        int x;
        int y;
        point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}