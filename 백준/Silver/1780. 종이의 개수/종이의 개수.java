import java.util.*;
import java.io.*;
public class Main{
    static int N;
    static int[][] map;
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;
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
        page(0,0,N);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
        
        
        
    }
    static void page(int x,int y,int size){
        if(check(x,y,size)){
            if(map[y][x]==-1){
                minus++;
            }
            else if(map[y][x]==0){
                zero++;
            }
            else if(map[y][x]==1){
                plus++;
            }
            return ;
        }
        int nextSize = size/3;
        for(int i=y;i<y+size;i+=nextSize){
            for(int j=x;j<x+size;j+=nextSize){
                page(j,i,nextSize);
            }
        }
        
    }
    
    static boolean check(int x,int y,int size){
        int tmp = map[y][x];
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(map[i][j]!=tmp)
                    return false;
            }        
        }
        return true;
    }
}