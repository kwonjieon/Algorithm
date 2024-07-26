import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        int[] diff = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0;i<N-1;i++){
            diff[i] = Math.abs(arr[i]-arr[i+1]);
        }
        Arrays.sort(diff);
        int sum=0;
        for(int i=0;i<N-1-(K-1);i++){
            sum+=diff[i];
        }
        System.out.println(sum);
    }
}