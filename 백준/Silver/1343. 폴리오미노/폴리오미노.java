import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str=str.replace("XXXX","AAAA");
        str=str.replace("XX","BB");
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='X'){
                System.out.println("-1");
                return ;
            }
        }
        System.out.println(str);
    }
}