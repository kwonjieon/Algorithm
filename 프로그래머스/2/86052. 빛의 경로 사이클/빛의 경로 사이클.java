import java.util.*;
class Solution {
    static int[] dx = {0,1,0,-1};//위부터 시계방향
    static int[] dy = {-1,0,1,0};//L이면 +3%4 R이면 +1%4
    static int N;
    static int M;
    static boolean[][][] visit;
    public ArrayList<Integer> solution(String[] grid) {
        ArrayList<Integer> answer = new ArrayList<>();
        N = grid.length;
        M = grid[0].length();
        
        visit = new boolean[4][N][M];//위부터 시계방향
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                for(int k=0;k<4;k++){
                    if(!visit[k][i][j]){
                        answer.add(bfs(grid,i,j,k));
                    }
                }
            }
        }
        
        Collections.sort(answer);
        
        
        
        return answer;
    }
    static int bfs(String[] grid,int y,int x,int dir){
        int count=0;
        while(!visit[dir][y][x]){
            count++;
            visit[dir][y][x]=true;
            if(grid[y].charAt(x)=='L'){
                dir = (dir+3)%4;
            }
            else if(grid[y].charAt(x)=='R'){
                dir = (dir+1)%4;
            }
            y = (y+dy[dir]+N)%N;
            x = (x+dx[dir]+M)%M;
            
        }
        return count;
        
        
    }
    static class point{
        int x;
        int y;
        int count;
        point(int x, int y, int count){
            this.x=x;
            this.y=y;
            this.count=count;
        }
    }
}