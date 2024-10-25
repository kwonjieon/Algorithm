import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int [] lines = new int[K];
        long min=0;
        long max=0;
        for(int i=0;i<K;i++){
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,lines[i]);
        }
        max++;
        while(max>min){
            long mid = (max+min)/2;
            if(countLine(lines,mid)<N){//max값 낮춤
                max=mid;
            }
            else{
                min=mid+1;
            }
        }
        System.out.println(min-1);

    }
    static long countLine(int[] lines,long length){
        long count=0;
        for (int line : lines) {
            count += line / length;
        }
        return count;

    }
}