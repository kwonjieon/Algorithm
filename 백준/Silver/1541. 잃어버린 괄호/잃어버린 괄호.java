import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        LinkedList<Integer> operand = new LinkedList<>();
        LinkedList<Character> operator = new LinkedList<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='+'||str.charAt(i)=='-'){
                operator.add(str.charAt(i));
            }
        }
        str = str.replace("+"," ");
        str = str.replace("-"," ");
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreTokens()){
            operand.add(Integer.parseInt(st.nextToken()));
        }
        for(int i=0;i<operator.size();i++){
            if(operator.get(i)=='+'){
                operator.remove(i);
                int x1 = operand.remove(i);
                int x2 = operand.remove(i);
                operand.add(i,x1+x2);
                i--;
            }
        }
        int answer = operand.removeFirst();
        for(int x:operand){
            answer-=x;
        }
        System.out.println(answer);

    }
}
