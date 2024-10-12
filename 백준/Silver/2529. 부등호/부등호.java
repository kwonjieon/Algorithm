import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n;
    static String str;
    static StringBuffer sb;
    static List<String> ans = new ArrayList<>();

    static boolean[] visit;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        str = br.readLine();
        visit = new boolean[10];
        str = str.replaceAll(" ","");
        sb = new StringBuffer();
        dfs(0,"");
        System.out.println(ans.get(ans.size()-1));
        System.out.println(ans.get(0));
    }
    static void dfs(int depth,String num){
        if(depth==n+1){
            ans.add(num);
            return;
        }
        for(int i=0;i<10;i++){
            if(!visit[i]&&(depth==0||check(num.charAt(depth-1),(char)(i +'0'),str.charAt(depth-1)))){
                visit[i]=true;
                dfs(depth+1,num+Integer.toString(i));
                visit[i]=false;
            }
        }

    }
    static boolean check(char a,char b,char c){

        if(c=='<'){
            if(a<b) return true;
        }
        if(c=='>'){
            if(a>b) return true;
        }
        return false;
    }
}
