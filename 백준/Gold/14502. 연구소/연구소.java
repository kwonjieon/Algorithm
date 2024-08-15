import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int max=0;
    static int[] dx = {0,0,-1,1};//상하좌우
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(max);

    }
    static void dfs(int depth){
        if(depth==3){
            bfs();
            return;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==0){
                    map[i][j]=1;
                    dfs(depth+1);
                    map[i][j]=0;
                }
            }
        }
    }
    static void bfs(){
        int[][] reMap = new int[n][m];
        for(int i=0;i<n;i++){
            reMap[i]=Arrays.copyOf(map[i],m);
        }
        Queue<virus> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(reMap[i][j]==2)
                    q.offer(new virus(j,i));
            }
        }
        while(!q.isEmpty()){
            virus p = q.poll();
            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx>=m||nx<0||ny>=n||ny<0)
                    continue;
                if(reMap[ny][nx]==0){
                    q.offer(new virus(nx,ny));
                    reMap[ny][nx]=2;
                }
            }
        }
        Count(reMap);

    }
    static void Count(int[][] reMap){
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(reMap[i][j]==0){
                    count++;
                }
            }
        }
        if(count>max)
            max=count;
    }
}
class virus{
    int x;
    int y;
    virus(int x,int y){
        this.x=x;
        this.y=y;
    }
}
