import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> box = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] crane = new int[N];
        for(int i=0;i<N;i++){
            crane[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            box.add(Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(crane);
        box.sort(Collections.reverseOrder());
        int answer=0;
        while(!box.isEmpty()){
            if(box.get(0)>crane[N-1]){
                answer=-1;
                break;
            }
            answer++;
            for(int i=N-1;i>=0;i--){
                int size = box.size();
                for(int j=0;j<size;j++){
                    if(box.get(j)<=crane[i]){
                        box.remove(j);
                        break;
                    }
                }
            }
        }
        System.out.println(answer);

    }
}