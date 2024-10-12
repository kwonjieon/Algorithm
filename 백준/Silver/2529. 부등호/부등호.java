import java.util.*;
import java.io.*;
public class Main{
    static int n;
    static char[] signs;
    static LinkedList<String> answer = new LinkedList<>();
    static boolean[] visit;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        signs = new char[n];
        visit = new boolean[10];
        for(int i=0;i<n;i++){
            signs[i] = st.nextToken().charAt(0);
        }
        dfs(0,"");
        System.out.println(answer.get(answer.size()-1));
        System.out.println(answer.get(0));

    }
    static void dfs(int depth,String num){
        if(depth==n+1){
            answer.add(num);
            return;
        }
        for(int i=0;i<10;i++){
            if(!visit[i]&&(depth==0||check(num.charAt(depth-1),(char)('0'+i),signs[depth-1]))){
                visit[i]=true;
                dfs(depth+1,num+(char)('0'+i));
                visit[i]=false;
            }
        }
    }
    static boolean check(char a,char b,char sign){
        if(sign=='<'){
            if(a<b) return true;
        }
        else if(sign=='>'){
            if(a>b) return true;
        }
        return false;
    }
}