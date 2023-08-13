import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        if(citations[citations.length-1]==0)
            return 0;
        int h_index = 0;
        int up;
        int down;
        while(true){
            up = 0;
            down = 0;
            for(int i=0;i<citations.length;i++){
                if(citations[i]<=h_index)
                    up++;
                else
                    down++;
            }
            System.out.println(h_index+" "+up+" "+down);
            if(h_index>=up && h_index>=down)
                break;
            h_index++;
        }
        
        return h_index;
    }
}