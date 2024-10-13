import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int ans=0;
    static boolean[][] visit;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n][n];
        for(int i=0;i<n;i++){
            visit[0][i]=true;
            dfs(1);
            visit[0][i]=false;
        }
        System.out.println(ans);

    }
    static void dfs(int depth){
        if(depth==n){
            ans++;
            return ;
        }
        for(int i=0;i<n;i++){
            if(checkVisit(i,depth)){
                visit[depth][i]=true;
                dfs(depth+1);
                visit[depth][i]=false;
            }
        }
    }
    static boolean checkVisit(int x,int y){
        int dx=x;
        int dy=y;
        while(true){//왼쪽위
            dx--;
            dy--;
            if(dx<0||dx>=n||dy<0||dy>=n)break;
            if(visit[dy][dx])return false;
        }
        dx=x;
        dy=y;
        while(x>=0&&y>0&&x<n&&y<n){//위
            dy--;
            if(dx<0||dx>=n||dy<0||dy>=n)break;
            if(visit[dy][dx])return false;
        }
        dx=x;
        dy=y;
        while(x>=0&&y>0&&x<n&&y<n){//오른쪽위
            dx++;
            dy--;
            if(dx<0||dx>=n||dy<0||dy>=n)break;
            if(visit[dy][dx])return false;
        }
        return true;
    }
}
