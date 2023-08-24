public class Solution {
	public class STACK {
		int[] stack = new int[100000];
		
		int idx = -1;
		
		public int getSize() {
			return idx + 1;
		}
		
		public void add(int num) {
			stack[++idx] = num;
		}
		
		public int pop() {
			return stack[idx--];
		}
		
		public int peek(int idx) {
			if (idx < 0 || idx >= getSize())
				return -1;
			
			return stack[idx];
		}
	}
	
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        STACK uncleared = new STACK();
        
        // 큐 이용.
        for (int i = 0; i < prices.length; i++)
        {
        	for (int j = uncleared.getSize() - 1; j >= 0; j--)
        	{
        		if (prices[uncleared.peek(j)] > prices[i])
        		{
        			int num = uncleared.pop();
        			answer[num] = i - num;
        		}
        		else break;
        	}
        	uncleared.add(i);
        }
        
        while (uncleared.getSize() != 0)
        {
        	int num = uncleared.pop();
			answer[num] = prices.length - num - 1;
        }
        
        return answer;
    }
}