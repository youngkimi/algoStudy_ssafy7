import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        int[] answer = new int[2];
        List<String> word = new ArrayList<String>();
        word.add(words[0]);
        for(int i =1;i<words.length;i++)
        {
            if(word.contains(words[i]) || words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0))
            {
                answer[0]=i%n+1;
                answer[1]=(int)i/n+1;
                return answer;
            }
            word.add(words[i]);
        }
        
        return answer;
    }
}