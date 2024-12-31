import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] front = new int[N];
        int[] back = new int[N];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    front[i] = Math.max(front[i],front[j]+1);
                }
            }
        }
        for(int i=N-1;i>=0;i--){
            for(int j=N-1;j>i;j--){
                if(arr[i]>arr[j]){
                    back[i] = Math.max(back[i],back[j]+1);
                }
            }
        }
        for(int i=0;i<N;i++){
            max = Math.max(max,front[i]+back[i]);
        }
        System.out.println(max+1);

    }
}