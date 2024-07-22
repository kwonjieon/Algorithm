import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.offer(Integer.parseInt(br.readLine()));
        }
        int count=0;
        while(true){
            if(q.size()==1)
                break;
            int x=q.poll();
            int y= q.poll();
            count+=x+y;
            q.offer(x+y);

        }
        System.out.print(count);


    }
}
