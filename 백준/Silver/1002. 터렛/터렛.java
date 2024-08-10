import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int len = (int)(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));//두점사이거리

            if(x1==x2&&y1==y2&&r1==r2){
                sb.append(-1+"\n");
            }
            
            else if(len==Math.pow(r1+r2,2)||len==Math.pow(r1-r2,2)){
                sb.append(1+"\n");

            }
            else if(len>Math.pow(r1+r2,2))
                sb.append(0+"\n");
            else if(len<Math.pow(r1-r2,2)){
                sb.append(0+"\n");
            }
            else{
                sb.append(2+"\n");
            }
        }
        System.out.println(sb);


    }
}