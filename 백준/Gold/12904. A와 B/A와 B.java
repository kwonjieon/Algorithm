import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer S = new StringBuffer(br.readLine());
        StringBuffer T = new StringBuffer(br.readLine());
        while(S.length()!=T.length()){
            if(T.charAt(T.length()-1)=='A'){
                T = T.deleteCharAt(T.length()-1);
            }
            else{
                T = T.deleteCharAt(T.length()-1);
                T = T.reverse();
            }
        }
        if(T.toString().equals(S.toString())){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        }

    }
}