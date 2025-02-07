import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static int E;
    static int start;
    static List<Node>[] graph;
    static int[] dist;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        dist = new int[V+1];
        for(int i=1;i<=V;i++){
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e,w));
        }
        dist[start]=0;
        dijkstra();
        for(int i=1;i<=V;i++){
            if(dist[i]==Integer.MAX_VALUE){
                System.out.println("INF");
                continue;
            }
            System.out.println(dist[i]);

        }


    }
    static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.weight-o2.weight);
        pq.offer(new Node(start,0));
        boolean[] visit = new boolean[V+1];
        while(!pq.isEmpty()){
            Node p = pq.poll();

            if(visit[p.end])
                continue;
            visit[p.end]=true;
            for(Node next: graph[p.end]){
                if(dist[next.end]>dist[p.end]+next.weight){
                    dist[next.end]=dist[p.end]+next.weight;
                    pq.offer(new Node(next.end,dist[next.end]));
                }
            }
        }

    }
}
class Node{
    int end;
    int weight;
    Node(int end,int weight){
        this.end = end;
        this.weight = weight;
    }
}