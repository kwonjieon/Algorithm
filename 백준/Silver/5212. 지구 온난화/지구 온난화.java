import java.util.*;
import java.io.*;
public class Main{
    static int R;//y
    static int C;//x
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R+2][C+2];
        char[][] nextMap = new char[R+2][C+2];
        for(int i=0;i<=R+1;i++){//map초기화
            for(int j=0;j<=C+1;j++){
                map[i][j] = '.';
            }
        }
        for(int i=1;i<=R;i++){
            String str = br.readLine();
            for(int j=1;j<=C;j++){
                map[i][j] = str.charAt(j-1);//입력
            }
        }
        for(int i=1;i<=R;i++){
            for(int j=1;j<=C;j++){
                char c = map[i][j];
                if(c=='.'){
                    nextMap[i][j]=map[i][j];
                }
                else{
                    int count=0;
                    for(int k=0;k<4;k++){
                        int nx = j+dx[k];
                        int ny = i+dy[k];
                        if(map[ny][nx]=='.')
                            count++;
                    }
                    if(count>=3){
                        nextMap[i][j]='.';
                    }
                    else{
                        nextMap[i][j]='X';
                    }
                }
            }
        }
        int startX=0;
        int startY=0;
        int endX=0;
        int endY=0;

        for(int i=0;i<R+2;i++){//startY
            boolean existX  = false;
            for(int j=0;j<C+2;j++){
                if(nextMap[i][j]=='X'){
                    existX=true;
                }
            }
            if(existX){
                startY=i;
                break;
            }
        }
        for(int i=R+1;i>=0;i--){//endY
            boolean existX  = false;
            for(int j=0;j<C+2;j++){
                if(nextMap[i][j]=='X'){
                    existX=true;
                }
            }
            if(existX){
                endY=i;
                break;
            }
        }
        for(int i=0;i<C+2;i++){//startX
            boolean existX  = false;
            for(int j=0;j<R+2;j++){
                if(nextMap[j][i]=='X'){
                    existX=true;
                }
            }
            if(existX){
                startX=i;
                break;
            }
        }
        for(int i=C+1;i>=0;i--){//endX
            boolean existX  = false;
            for(int j=0;j<R+2;j++){
                if(nextMap[j][i]=='X'){
                    existX=true;
                }
            }
            if(existX){
                endX=i;
                break;
            }
        }
        for(int i=startY;i<=endY;i++){
            for(int j=startX;j<=endX;j++){
                System.out.print(nextMap[i][j]);
            }
            System.out.println();
        }
    }
}