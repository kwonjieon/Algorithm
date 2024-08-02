import java.util.*;
import java.io.*;
public class Main{
    static int n;
    static int m;
    static LinkedList<point> homes = new LinkedList<>();
    static LinkedList<point> chicken = new LinkedList<>();
    static boolean[] open;
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());




        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int x=Integer.parseInt(st.nextToken());
                if(x==1){
                    homes.add(new point(j,i));
                }
                else if(x==2){
                    chicken.add(new point(j,i));
                }
            }
        }

        open = new boolean[chicken.size()];
        dfs(0,0);
        System.out.println(min);



    }
    static void dfs(int start,int depth){
        if(depth==m){
            int total=0;
            for(int i=0;i<homes.size();i++){
                int sum=Integer.MAX_VALUE;
                for(int j=0;j<chicken.size();j++){
                    if(open[j]){
                        int dis = Math.abs(homes.get(i).x-chicken.get(j).x)+Math.abs(homes.get(i).y-chicken.get(j).y);

                        sum=Math.min(sum,dis);
                    }
                }
                total+=sum;
            }
            min=Math.min(total,min);
        }
        for(int i=start;i<chicken.size();i++){
            if(!open[i]){
                open[i]=true;
                dfs(i+1,depth+1);
                open[i]=false;
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