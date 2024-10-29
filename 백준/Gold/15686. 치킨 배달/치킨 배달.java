import java.util.*;
import java.io.*;
public class Main{
    static int N;
    static int M;
    static int[][] map;
    static ArrayList<point> chickens = new ArrayList<>();
    static ArrayList<point> houses = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static boolean[] visit;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    houses.add(new point(j,i));
                }
                else if(map[i][j]==2){
                    chickens.add(new point(j,i));
                }
            }
        }
        visit = new boolean[chickens.size()];
        dfs(0,0);
        System.out.println(min);


    }
    static void dfs(int depth,int at){
        if(depth==M){
            int total=0;
            for(int i=0;i<houses.size();i++){
                int temp = Integer.MAX_VALUE;
                for(int j=0;j<chickens.size();j++){
                    if(visit[j]){
                        int dis = Math.abs(houses.get(i).x- chickens.get(j).x) + Math.abs(houses.get(i).y - chickens.get(j).y);
                        temp = Math.min(temp,dis);

                    }
                }
                total+=temp;
            }
            min = Math.min(total,min);
            return;
        }
        for(int i=at;i<chickens.size();i++){
            if(!visit[i]){
                visit[i]=true;
                dfs(depth+1,i+1);
                visit[i]=false;
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