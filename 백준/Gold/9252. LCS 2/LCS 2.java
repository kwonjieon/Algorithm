import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }
                else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        int i=len1;
        int j=len2;
        while(i>0&&j>0){
            if( str1.charAt(i-1)==str2.charAt(j-1) ){
                list.addFirst(i-1);
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        System.out.println(dp[len1][len2]);
        if(dp[len1][len2]!=0){
            for(int k:list){
                System.out.print(str1.charAt(k));
            }
        }

    }
}