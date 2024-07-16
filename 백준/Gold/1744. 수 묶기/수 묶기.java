import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> plus = new LinkedList<>();
        LinkedList<Integer> minus = new LinkedList<>();
        LinkedList<Integer> zeros = new LinkedList<>();//0은 마이너스가 홀수일때 한번만 사용
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0) {
                zeros.add(x);
            }
            else if(x>0){
                plus.add(x);
            }
            else{
                minus.add(x);
            }
        }
        plus.sort(Collections.reverseOrder());
        minus.sort(null);
        int sum=0;
        while(minus.size()>=2){
            sum+= (minus.removeFirst()* minus.removeFirst());
        }
        if(minus.size()==1){
            if(zeros.size()==0){
                sum+= minus.get(0);
            }
        }
        while(plus.size()>=2){
            int x1 = plus.removeFirst();
            int x2 = plus.removeFirst();
            if(x1>1&&x2>1){
                sum+=(x1*x2);
            }
            else{
                sum+=x1+x2;
            }
        }
        if(plus.size()==1)
            sum+= plus.get(0);
        System.out.println(sum);

    }
}
