import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static ArrayList<Integer>[] graph;
    static StringBuffer sb;
    static int[] ans;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v;
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuffer();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        ans = new int[n];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        for(int i=1;i<=n;i++){
            Collections.sort(graph[i]);
        }
        boolean[] visit = new boolean[n+1];
        ans[0]=v;
        visit[v]=true;
        dfs(v,visit);
        sb.append("\n");
        visit = new boolean[n+1];
        bfs(v,visit);
        System.out.println(sb);


    }
    static void dfs(int at,boolean[] visit){

        visit[at]=true;

        sb.append(at+" ");
        for(int i : graph[at]){
            if(!visit[i]){
                dfs(i,visit);
            }
        }

    }
    static void bfs(int at,boolean[] visit){
        q.add(at);
        visit[at]=true;
        while(!q.isEmpty()){
            at =q.poll();
            sb.append(at+" ");
            for(int i: graph[at]){
                if(!visit[i]){
                    q.add(i);
                    visit[i]=true;
                }
            }
        }

    }
}
