import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long now = Long.parseLong(st.nextToken());
        long target = Long.parseLong(st.nextToken());
        PriorityQueue<point> pq = new PriorityQueue<>();
        pq.offer(new point(now,1));
        while(!pq.isEmpty()) {
            point po = pq.poll();
            if (po.x > target) {
                System.out.println("-1");
                return;
            }
            if (po.x == target) {
                System.out.println(po.count);
                return;
            }
            long y1 = (po.x * 10) + 1;
            long y2 = po.x * 2;
            if (y1 <= target) {
                pq.offer(new point(y1, po.count + 1));
            }
            if (y2 <= target) {
                pq.offer(new point(y2, po.count + 1));
            }
        }
        System.out.println("-1");
    }
    static class point implements Comparable<point>{
        long x;
        int count;
        point(long x, int count){
            this.x=x;
            this.count=count;
        }
        @Override
        public int compareTo(point o1){
            return (int)(this.x-o1.x);
        }
    }
}