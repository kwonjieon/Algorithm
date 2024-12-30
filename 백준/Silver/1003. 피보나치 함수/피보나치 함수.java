import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] zero = new int[41];
        int[] one = new int[41];
        zero[0] = 1;
        zero[1] = 0;
        zero[2] = 1;
        zero[3] = 1;
        for(int i=4;i<41;i++){//zerocount
            zero[i] = zero[i-1]+zero[i-2];
        }
        one[0] = 0;
        one[1] = 1;
        one[2] = 1;
        one[3] = 2;
        for(int i=4;i<41;i++){//onecount
            one[i] = one[i-1]+one[i-2];
        }

        for(int test_case=0;test_case<T;test_case++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(zero[N]+" "+one[N]);

        }
    }
}