import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<time> list = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new time(s,e));
        }
        list.sort(new Comparator<time>() {
            @Override
            public int compare(time o1, time o2) {
                if(o1.start==o2.start)
                    return o1.end- o2.end;
                return o1.start-o2.start;
            }
        });
        int count=0;
        pq.add(list.remove(0).end);
        for(time t:list){
            if(pq.peek()<=t.start){
                pq.poll();
            }
            pq.offer(t.end);
        }
        System.out.print(pq.size());
    }
    static class time{
        int start;
        int end;
        time(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
}
