import java.util.*;
import java.io.*;
public class Main{
    static int N;
    static int[][] map;
    
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int k=0;k<N;k++){//경유지
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][k]==1&&map[k][j]==1){
                        map[i][j]=1;
                    }
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        
        
    }
}