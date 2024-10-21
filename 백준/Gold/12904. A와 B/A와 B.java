import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer str = new StringBuffer(br.readLine());
        StringBuffer target = new StringBuffer(br.readLine());
        while(str.length()!=target.length()){
            if(target.charAt(target.length()-1)=='A'){
                target = target.deleteCharAt(target.length()-1);
            }
            else{
                target = target.deleteCharAt(target.length()-1);
                target = target.reverse();
            }
        }
        if(str.toString().equals(target.toString())){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        }
        
        
    }
}