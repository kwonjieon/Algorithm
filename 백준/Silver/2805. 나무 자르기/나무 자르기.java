import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        Long[] arr = new Long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        long min=1l;
        long max=2000000000l;
        long mid=0;
        while(max>min){
            mid = (max+min)/2;
            long sum=0;
            for(int i=0;i<N;i++){
                if(mid<arr[i]){
                    sum+=(arr[i]-mid);
                }
                if(sum>M)
                    break;
            }
            if(sum<M){
                max=mid;
            }
            else{
                min=mid+1;
            }
        }
        System.out.println(min-1);


    }
}