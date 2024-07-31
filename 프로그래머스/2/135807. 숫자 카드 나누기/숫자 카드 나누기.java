import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for(int i=1;i<arrayA.length;i++){
            gcdA = gcd(gcdA,arrayA[i]);
            gcdB = gcd(gcdB,arrayB[i]);
        }
        int max=0;
        if(isDivide(gcdA,arrayB)){
            max=Math.max(max,gcdA);
        }
        if(isDivide(gcdB,arrayA)){
            max=Math.max(max,gcdB);
        }
        
        
        return max;
    }
    public boolean isDivide(int gcd,int[] arr){
        for(int x: arr){
            if(x%gcd==0){
                return false;
            }
        }
        return true;
        
    }
    public int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}