import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        String word;
        for(int i=0;i<n;i++){
            word = br.readLine();
            set.add(word);
        }
        LinkedList<String> list = new LinkedList<>();
        for(String str:set){
            list.add(str);
        }
        
        list.sort(new Comparator<String>(){
            @Override
            public int compare(String o1,String o2){
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length()-o2.length();
            }
        });
        for(String str: list){
            System.out.println(str);
        }
        
    }
}