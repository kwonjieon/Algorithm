import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Line> list = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Line(x,y));
        }
        int[] dp = new int[N];
        list.sort(null);
        for(int i=0;i<N;i++){
            for(int j=0;j<i;j++){
                if(list.get(i).end>list.get(j).end){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max = 0;
        for(int i=0;i<N;i++){
            max = Math.max(max,dp[i]);
        }
        System.out.println(N-1-max);
    }
}
class Line implements Comparable<Line>{
    int start;
    int end;
    Line(int start,int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Line o){
        return this.start-o.start;
    }
}