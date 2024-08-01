import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int m;
    static List<Integer>[] graph;
    static boolean[] visit;
    static int count=0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new LinkedList[n+1];
        visit = new boolean[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new LinkedList<>();
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        dfs(1);
        System.out.println(count-1);
        
    }
    static void dfs(int v){
        visit[v]=true;
        count++;
        for(int i: graph[v]){
            if(!visit[i]){
                dfs(i);
            }
        }
    }
    
}