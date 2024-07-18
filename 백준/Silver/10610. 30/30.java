import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] carr = str.toCharArray();
        Arrays.sort(carr);

        StringBuffer sb  = new StringBuffer();
        int sum=0;
        for(int i= carr.length-1;i>=0;i--){
            sum+=(carr[i]-'0');
            sb.append(carr[i]);
        }
        if(sum%3!=0||carr[0]!='0'){
            System.out.print(-1);
        }
        else{
            System.out.print(sb);
        }
    }
}