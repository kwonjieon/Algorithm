import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int count=1;
        int num=666;
        while(count!=n){
            num++;
            if(String.valueOf(num).contains("666")){
                count++;
            }
        }
        System.out.println(num);
    }
}