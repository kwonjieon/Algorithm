import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        for(int i=0;i<n;i++){
            Set<Double> set = new HashSet<>();
            point[] points = new point[4];
            for(int j=0;j<4;j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[j] = new point(x,y);
            }
            double[] lens = new double[6];
            int count=0;
            for(int j=0;j<3;j++){
                for(int k=j+1;k<4;k++){
                    double len = Math.pow(points[k].x-points[j].x,2)+Math.pow(points[k].y-points[j].y,2);
                    lens[count++]=len;
                }
            }
            Arrays.sort(lens);
            if(lens[0]==lens[3]&&lens[4]==lens[5]){
                sb.append(1+"\n");
            }
            else{
                sb.append(0+"\n");
            }
        }
        System.out.print(sb);

    }
    static class point{
        int x;
        int y;
        point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}