import java.util.*;
import java.io.*;
public class Main{
    static int start;
    static int end;
    static ArrayList<Integer>[] graph;
    static int N;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        System.out.println(bfs());

    }
    static int bfs(){
        boolean[] visit = new boolean[N+1];
        Queue<Rel> q = new LinkedList<>();
        q.offer(new Rel(start,0));
        visit[start]=true;
        while(!q.isEmpty()){
            Rel p = q.poll();
            for(int i:graph[p.num]){
                if(!visit[i]){
                    if(i==end){
                        return p.count+1;
                    }
                    q.offer(new Rel(i,p.count+1));
                    visit[i]=true;
                }
            }


        }
        return -1;


    }
    static class Rel{
        int num;
        int count;
        Rel(int num,int count){
            this.num=num;
            this.count=count;
        }
    }
}