import java.util.*;
import java.io.*;
public class Main{
    static int M;
    static int N;
    static int K;
    static boolean[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static LinkedList<Integer> answer = new LinkedList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());//y
        N = Integer.parseInt(st.nextToken());//x
        K = Integer.parseInt(st.nextToken());
        map = new boolean[M][N];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            for(int l = startX;l<endX;l++){
                for(int m=startY;m<endY;m++){
                    map[m][l] = true;
                }
            }
        }
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(!map[i][j]){
                    bfs(new point(j,i));
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for(int i:answer){
            System.out.print(i+" ");
        }



    }
    static void bfs(point cur){
        Queue<point> q = new LinkedList<>();
        q.offer(cur);
        int count=1;
        map[cur.y][cur.x]=true;
        while(!q.isEmpty()){
            point p = q.poll();
            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx>=N||ny>=M||nx<0||ny<0)
                    continue;
                if(!map[ny][nx]){
                    map[ny][nx]=true;
                    q.offer(new point(nx,ny));
                    count++;
                }
            }
        }
        answer.add(count);

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
