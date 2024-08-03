import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int n = phone_book.length;
        Arrays.sort(phone_book);
        HashSet<String> hs = new HashSet<>();
        for(String str:phone_book){
            for(int i=1;i<=str.length();i++){
                String s = str.substring(0,i);
                if(hs.contains(s)){
                    return false;
                }
            }
            hs.add(str);
        }
        return answer;
    }
}