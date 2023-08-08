import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] score = {0 , 0 , 0};
        
        for(int i = 0; answers.length > i; i++){
            
            if(answers[i] == person1[i % person1.length]){
                score[0] += 1;
            }
            if(answers[i] == person2[i % person2.length]){
                score[1] += 1;
            }
            if(answers[i] == person3[i % person3.length]){
                score[2] += 1;
            }
            
        }
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0; i<score.length; i++) 
            if(max == score[i]) ans.add(i+1);
        
        int[] answer = new int[ans.size()];
        
        for(int i=0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}