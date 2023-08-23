import java.util.*;

public class Solution {
    Queue <Integer> publishes = new LinkedList<> ();
    
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        int idx = 0;
        
        while (idx < progresses.length)
        {
        	for (int i = idx; i < progresses.length; i++)
        		progresses[i] += speeds[i];
        	
        	int doneCnt = 0;
        	
        	while (idx < progresses.length && progresses[idx] >= 100)
        	{
        		idx++;
        		doneCnt++;
        	}
        	
        	
        	if (doneCnt != 0)
        		publishes.add(doneCnt);
        }
        
        answer = new int[publishes.size()];
        
        for (int i = 0; i < answer.length; i++)
        	answer[i] = publishes.poll();
        
        return answer;
    }
}