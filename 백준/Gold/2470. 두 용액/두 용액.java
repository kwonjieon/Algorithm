import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = n-1;
        int min = Integer.MAX_VALUE;
        int minleft = left;
        int minright = right;
        while(left<right){
            int x = arr[left]+arr[right];
            if(Math.abs(min)>Math.abs(x)){
                min = Math.min(Math.abs(min),Math.abs(x));
                minleft=left;
                minright=right;

            }
            if(x==0){
                minleft=left;
                minright=right;
                break;
            }
            else if(x>0){
                right--;
            }
            else
                left++;
        }
        System.out.println(arr[minleft]+" "+arr[minright]);


    }
}