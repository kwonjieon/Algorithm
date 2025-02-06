import java.util.*;
import java.io.*;
public class Main{

    static int V;
    static int E;
    static int start;
    static LinkedList<Node>[] graph;
    static int[] dist;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        graph = new LinkedList[V+1];
        for(int i=1;i<=V;i++){
            graph[i] = new LinkedList<Node>();
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(t,w));
        }
        dist = new int[V+1];
        dijkstra();
        for(int i=1;i<=V;i++){
            if(dist[i]==1000000){
                System.out.println("INF");
                continue;
            }
            System.out.println(dist[i]);
        }


    }
    static void dijkstra(){

        for(int i=1;i<=V;i++){
            dist[i] = 1000000;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        dist[start]=0;
        boolean[] visit = new boolean[V+1];
        while(!pq.isEmpty()){
            Node p = pq.poll();
            if(visit[p.next])
                continue;
            visit[p.next]=true;
            for(Node i : graph[p.next]){
                if(dist[i.next]>dist[p.next]+i.weight){
                    dist[i.next] = dist[p.next]+i.weight;
                    pq.offer(new Node(i.next,dist[i.next]));
                }
            }
        }
    }

}
class Node implements Comparable<Node>{
    int next;
    int weight;
    Node(int next,int weight){
        this.next = next;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o){
        return this.weight-o.weight;
    }
}