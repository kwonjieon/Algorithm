import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count=0;
        st = new StringTokenizer(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<K;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0;i<K;i++){
            if(set.contains(list.get(i)))
                continue;
            if(set.size()<N){
                set.add(list.get(i));
                continue;
            }

            int maxIndex=-1;
            List<Integer> sub = list.subList(i+1,K);

            int val=0;

            for(int j: set){
                if(!sub.contains(j)){
                    val = j;
                    break;
                }

                int indexdiff = sub.indexOf(j);
                if(maxIndex<indexdiff){
                    maxIndex=indexdiff;
                    val=j;
                }
            }
            set.remove(val);
            set.add(list.get(i));
            count++;
        }
        System.out.println(count);
    }
}