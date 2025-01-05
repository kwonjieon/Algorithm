import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int bCount = 0;
        int wCount = 0;
        int left = 0;
        int right = 0;
        int max = 0;
        String str = br.readLine();

        while(right<N){
            char cR = str.charAt(right);
            if(cR=='B'){
                bCount++;
            }
            else if(cR=='W'){
                wCount++;
            }
            if(wCount>=W && bCount<=B){
                max = Math.max(max,right-left+1);
            }
            else if (bCount>B){
                while(bCount>B){
                    char cL = str.charAt(left);
                    if(cL=='W'){
                        wCount--;
                    }
                    else{
                        bCount--;
                    }
                    left++;
                    if(left>right)
                        break;
                }
            }
            right++;
        }

        System.out.println(max);

    }
}