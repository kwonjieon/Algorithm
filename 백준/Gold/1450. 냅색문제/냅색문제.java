import java.util.*;
import java.io.*;
public class Main{
    static int N;
    static int C;
    static int[] arr;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        dfs(0,0,N/2,0,listA);
        dfs(N/2,N/2,N,0,listB);

        listB.sort(null);
        int sum=0;
        for(int numA:listA){
            sum+=binarySearch(numA,listB);
        }
        System.out.println(sum);
    }
    static int binarySearch(int num,ArrayList<Integer> list){
        int min=0;
        int max = list.size();
        while(max>min){
            int mid = (max+min)/2;
            if(list.get(mid)+num>C){
                max=mid;
            }
            else{
                min=mid+1;
            }
        }
        return min;
    }
    static void dfs(int depth,int start,int end,int sum,ArrayList<Integer> list){
        if(sum>C){
            return;
        }
        if(depth==end){
            list.add(sum);
            return ;
        }
        dfs(depth+1,start,end,sum,list);
        dfs(depth+1,start,end,sum+arr[depth],list);

    }
}