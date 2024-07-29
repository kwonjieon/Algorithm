import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int l;

    static boolean[][] isApple;
    static boolean[][] snake;
    static int[] dx = {1,0,-1,0};//3시부터 시계방향
    static int[] dy = {0,1,0,-1};
    static int dir = 0;
    static int time = 1;
    static Deque<point> q = new LinkedList<>();
    static Map<Integer,Character> map = new HashMap<>();

    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        isApple = new boolean[n][n];
        for(int i=0;i<k;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            isApple[y-1][x-1] = true;
        }
        l = Integer.parseInt(br.readLine());
        for(int i=0;i<l;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            char v = st.nextToken().charAt(0);
            map.put(k,v);
        }
        snake = new boolean[n][n];
        q.offer(new point(0,0));
        snake[0][0]=true;
        while(true){
            point p = q.peekLast();

            int nx = p.x+dx[dir];
            int ny = p.y+dy[dir];
            if(nx<0||nx>=n||ny<0||ny>=n||snake[ny][nx])
                break;
            if(isApple[ny][nx]){
                q.offer(new point(nx,ny));
                snake[ny][nx]=true;
                isApple[ny][nx]=false;
            }
            else{
                q.offer(new point(nx,ny));
                snake[ny][nx]=true;
                point temp=q.removeFirst();
                snake[temp.y][temp.x]=false;
            }
            if(map.containsKey(time)){
                if(map.get(time).equals('L')){
                    dir = (dir+4-1)%4;
                }
                else{
                    dir = (dir+1)%4;
                }
            }
            time++;
        }
        System.out.println(time);
    }
    static class point{
        int x;
        int y;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
