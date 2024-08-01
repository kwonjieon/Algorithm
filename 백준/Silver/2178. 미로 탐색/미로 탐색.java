import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n,m;
    static int[] dx = {0,1,0,-1};//하우상좌
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        for(int i=0;i<n;i++){
            String str=br.readLine();
            for(int j=0;j<m;j++){
                map[i][j]=str.charAt(j)-'0';
            }
        }
        bfs();
    }
     static void bfs(){
        Queue<point> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        q.offer(new point(0,0,1));
        visit[0][0]=true;

        while(!q.isEmpty()){
            point p = q.poll();
            int x = p.x;
            int y =p.y;
            int count = p.count;

            if(x==m-1&&y==n-1){
                System.out.println(count);
                return;
            }
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0&&ny>=0&&nx<m&&ny<n){
                    if(!visit[ny][nx]&&map[ny][nx]==1) {
                        q.offer(new point(nx, ny, count + 1));
                        visit[ny][nx] = true;
                    }
                }
            }
        }
    }
    static class point{
        int x;
        int y;
        int count;
        public point(int x,int y,int count){
            this.x=x;
            this.y=y;
            this.count=count;
        }
    }
}