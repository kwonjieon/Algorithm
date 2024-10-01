import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());//최대 1000*1000 n^2가능
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<number> pq = new PriorityQueue<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<N;i++){
            int count=0;
            if(!hs.contains(arr[i])){
                for(int j=i;j<N;j++){
                
                    if(arr[j]==arr[i]){
                        count++;
                        
                    }
                }
                hs.add(arr[i]);
            }
            pq.offer(new number(arr[i],count,i));
            
        }
        StringBuffer sb = new StringBuffer();
        while(!pq.isEmpty()){
            number Num = pq.poll();
            int size = Num.count;
            for(int i=0;i<size;i++){
                sb.append(Num.num+" ");
            }
            
        }
        System.out.println(sb);
        
    }
    static class number implements Comparable<number>{
        int num;
        int count;
        int start;
        number(int num,int count,int start){
            this.num=num;
            this.count=count;
            this.start=start;
        }
        @Override
        public int compareTo(number o1){
            if(o1.count==this.count){
                return this.start-o1.start;
            }
            return o1.count-this.count;
        }
    }
}