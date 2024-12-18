import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count=0;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i-1)!=str.charAt(i)){
                count++;
            }
        }
        count++;
        System.out.println(count/2);
    }
}