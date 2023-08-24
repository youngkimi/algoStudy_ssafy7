import java.util.*;

public class Solution {
    Queue <Integer> queue = new LinkedList<> ();

    public int[] solution(int []arr) {
        int[] answer = {};
        int lastElement = arr[0];
        
        queue.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++)
        {
        	if (arr[i] == lastElement)
        		continue;
        	
        	queue.add(arr[i]);
        	lastElement = arr[i];
        }
        
        answer = new int[queue.size()];
        int idx = 0;
        
        while (queue.size() != 0)
        	answer[idx++] = queue.poll();
        
        return answer;
    }
}