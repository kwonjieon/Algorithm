import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            ArrayList<score> list = new ArrayList<>();
            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                list.add(new score(x1,x2));
            }
            Collections.sort(list, (a, b) -> a.x1 - b.x1);
            int count =1;
            int min2 = list.get(0).x2;
            for(int j=1;j<list.size();j++){
                if(min2>list.get(j).x2){
                    min2 = list.get(j).x2;
                    count++;
                }
            }
            System.out.println(count);
        }


    }
    static class score{
        int x1;
        int x2;
        score(int x1,int x2){
            this.x1=x1;
            this.x2=x2;
        }
    }
}