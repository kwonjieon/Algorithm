import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count =0;
        while(true){
            if(n<0){
                count=-1;
                break;
            }
            
            if(n%5==0){
                count+=n/5;
                break;
            }
            else{
                count++;
                n-=2;   
            }
        }
        System.out.println(count);
    }
}