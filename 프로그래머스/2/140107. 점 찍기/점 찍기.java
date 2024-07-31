class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(long i=0;i<=d;i+=k){
            long x = (long)Math.sqrt(((long)d*d)-(i*i));
            answer+=(x/k)+1;
        }
        
        return answer;
    }
}