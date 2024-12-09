import java.util.*;
import java.io.*;
public class Main{
    
    static int N;
    static int M;
    static int K;
    static int X;
    static ArrayList<Integer>[] list;
    
    
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            list[src].add(dst);
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(X);
        dist[X] = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int p = q.poll();
            if(dist[p]>K) break;
            if(dist[p]==K) ans.add(p);
            for(int i: list[p]){
                if (dist[i] != -1) continue;//이미방문했는지 확인
                dist[i] = dist[p]+1;
                q.add(i);
            }
        }
        Collections.sort(ans);
        if(ans.size()==0){
            System.out.println(-1);
        }
        else{
            for(int i:ans){
                System.out.println(i);
            }
        }
        
    }
}