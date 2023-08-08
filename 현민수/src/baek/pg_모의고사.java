import java.util.Arrays;
import java.util.Stack;
class Solution {
    public Object[] solution(int[] answers) {
        int[] person = new int[]{1,2,3};
       Stack<Integer> answer = new Stack<Integer>();
        int[] p1 = new int[]{1,2,3,4,5};
        int[] p2 = new int[]{2,1,2,3,2,4,2,5};
        int[] p3 = new int[]{3,1,2,4,5};  //01 23 45 67 89
                                        // 0 1 2 3 4 
        int[] cnt= new int[3];
        for(int i=0;i<answers.length;i++){
            if(p1[i%5]==answers[i])
                cnt[0]++;
            if(p2[i%8]==answers[i])
                cnt[1]++;
            if(p3[(i%10/2)]==answers[i])
                cnt[2]++;
        }
        int max = 0;
        for(int i=0;i<3;i++){
            if(max<cnt[i])
                max=cnt[i];
        }
        
        for(int i=0;i<3;i++){
            if(cnt[i]==max)
            {
                answer.push(i+1);
            }
        }
    
        return answer.toArray();
    }
}