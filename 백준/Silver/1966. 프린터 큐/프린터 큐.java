import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int test_case=0;test_case<T;test_case++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int targetPage = Integer.parseInt(st.nextToken());
            int count=0;
            PriorityQueue<page> pq = new PriorityQueue<>(new Comparator<page>(){
                @Override
                public int compare(page o1,page o2){
                    return o2.imp-o1.imp;
                }
            });
            Queue<page> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                page temp = new page(i,Integer.parseInt(st.nextToken()));
                q.offer(temp);
                pq.offer(temp);
            }
            while(true){
                if(pq.peek().imp==q.peek().imp){
                    pq.poll();
                    int x=q.poll().num;
                    count++;
                    if(targetPage==x){
                        break;
                    }
                }else{
                    q.offer(q.poll());
                }
            }
            System.out.println(count);

        }
    }
    static class page{
        int num;
        int imp;
        page(int num,int imp){
            this.num=num;
            this.imp=imp;
        }
    }
}