import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuffer s = new StringBuffer(br.readLine());
        int count=0;
        int index=0;
        while(count<K){
            if(index>=s.length())
                break;
            if(index>0){
                if(s.charAt(index-1)-'0'<s.charAt(index)-'0'){
                    s.deleteCharAt(index-1);
                    index--;
                    count++;
                    continue;
                }
            }
            index++;
        }
        String str = s.toString();
        System.out.println(str.substring(0,str.length()-(K-count)));
    }
}