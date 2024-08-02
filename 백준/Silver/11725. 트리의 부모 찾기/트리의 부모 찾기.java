import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static LinkedList<Integer>[] graph;
    static int[] answer;
    static boolean[] visit;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = new int[n+1];
        visit = new boolean[n+1];
        graph = new LinkedList[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new LinkedList<>();

        }
        StringTokenizer st;
        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        bfs();

        StringBuffer sb = new StringBuffer();
        for(int i=2;i<=n;i++){
            sb.append(answer[i]+"\n");
        }
        System.out.println(sb);



    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int x: graph[cur]){
                if(!visit[x]){
                    q.offer(x);
                    visit[x]=true;
                    answer[x]=cur;
                }
            }
        }
    }
}