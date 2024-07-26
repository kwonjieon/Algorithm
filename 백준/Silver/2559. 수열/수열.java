import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            int x = Integer.parseInt(st.nextToken());

            q.offer(x);
            sum+=x;
            if(q.size()>K) {
                sum -= q.poll();
            }
            if(q.size()==K) {
                if (max < sum) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }
}