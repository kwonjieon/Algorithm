import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int total=0;
        int count=0;
        int i=n-1;
        for(;i>=0;i--){
            total=Math.max(total,arr[i]*(count+1));
            count++;
        }
        System.out.println(total);
    }
}