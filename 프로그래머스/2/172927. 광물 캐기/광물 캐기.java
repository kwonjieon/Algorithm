import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int picksum = picks[0]+picks[1]+picks[2];
        if(minerals.length>picksum*5){
            minerals = Arrays.copyOfRange(minerals,0,picksum*5);
        }
        LinkedList<mine> list = new LinkedList<>();
        int sum=0;
        int dia=0;
        int iron=0;
        int stone=0;
        for(int i=0;i<minerals.length;i++){
            if(i!=0&&i%5==0){
                list.add(new mine(dia,iron,stone,sum));
                sum=0;//피로도
                dia=0;
                iron=0;
                stone=0;
            }
                
            if(minerals[i].equals("diamond")){
                dia++;
                sum+=25;
            }
            else if(minerals[i].equals("iron")){
                iron++;
                sum+=5;
            }
            else{
                stone++;
                sum+=1;
            }
        }
        list.add(new mine(dia,iron,stone,sum));
        Collections.sort(list);
        int i=0;
        for(mine x: list){
            
            int div=0;
            
            while(i!=3&&picks[i]==0)
                i++;
            if(i==3)
                break;
            picks[i]--;
            if(i==0)
                div=25;
            else if(i==1){
                div=5;
            }
            else if(i==2){
                div=1;
            }
            
            answer+=(x.dia*Math.ceil(25/(double)div));//다이아채굴 피로도
            answer+=(x.iron*Math.ceil(5/(double)div));//철채굴 피로도
            answer+=(x.stone*Math.ceil(1/(double)div));//돌채굴 피로도
            
            
        }
        
        
        return answer;
    }
}
class mine implements Comparable<mine>{
    int dia;
    int iron;
    int stone;
    int stamina;
    mine(int dia,int iron,int stone,int stamina){
        this.dia=dia;
        this.iron=iron;
        this.stone=stone;
        this.stamina=stamina;
    }
    @Override
    public int compareTo(mine o1){
        return o1.stamina-this.stamina;
        
    }
}