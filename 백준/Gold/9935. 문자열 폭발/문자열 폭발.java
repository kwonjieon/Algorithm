import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String check = br.readLine();
        //Stack<Charater> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            if(sb.length()<check.length()){
                continue;
            }
            String ch = sb.substring(sb.length()-check.length());
            if(ch.equals(check)){
                sb = sb.delete(sb.length() - check.length(), sb.length());
            }
        }
        if(sb.length()==0){
            System.out.println("FRULA");
        }
        else {
            System.out.println(sb);
        }


    }
}