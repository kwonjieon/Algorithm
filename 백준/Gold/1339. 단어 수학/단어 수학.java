import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int[] arr= new int[26];
    static int n;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[str.charAt(j) - 'A'] += (int) Math.pow(10, (str.length() - 1 - j));
            }
        }
        Arrays.sort(arr);
        int i=25;
        int sum=0;
        int index=9;
        while(arr[i]!=0){
            sum+=arr[i]*index;
            i--;
            index--;
        }
        System.out.println(sum);
    }

}
