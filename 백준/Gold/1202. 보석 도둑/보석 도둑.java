import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        LinkedList<jewelry> list  = new LinkedList<>();//무게순서정렬
        int[] bags = new int[K];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new jewelry(m,v));
        }
        for(int i=0;i<K;i++){
            bags[i] = Integer.parseInt(br.readLine());
        }
        list.sort(new Comparator<jewelry>() {
            @Override
            public int compare(jewelry o1, jewelry o2) {
                return o1.weight-o2.weight;
            }
        });
        Arrays.sort(bags);
        long sum=0;
        int j=0;
        for(int i=0;i<K;i++){
            while(!list.isEmpty()&&bags[i]>=list.get(j).weight){
                pq.offer(list.poll().value);
            }
            if(!pq.isEmpty()) {
                sum += pq.poll();
            }
        }
        System.out.print(sum);



    }
    static class jewelry{
        int weight;
        int value;
        jewelry(int weight,int value){
            this.weight=weight;
            this.value=value;
        }
    }
}
