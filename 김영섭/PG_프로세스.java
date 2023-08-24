class Solution {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        
        Q programs = new Q();
        
        for (int i = 0; i < priorities.length; i++)
        	programs.add(priorities[i]);
                
        here : while (programs.size() != 0)
        {
        	int num = programs.poll();
        	
        	for (int i = 0; i < programs.size(); i++)
        	{
        		if (num < programs.peek(i))
        		{
        			programs.add(num);
        			location --;
        			if (location < 0)
        				location = programs.size() - 1;
        			
        			continue here;
        		}
        	}
        	
        	answer ++;
        	
        	if (location == 0) return answer;
        	
        	// 맨 앞 숫자가 출력된다. 
        	location --;
        }
        
        return answer;
    }
    
     static class Q {
    	int[] arr = new int[101];
    	int idx = -1;
    	
    	Q () {};
    	
    	public void add(int num)
		{
    		arr[++idx] = num;
		}
    	
    	public int poll()
    	{
    		int num = arr[0];
    		
    		for (int i = 0; i < idx; i++)
    		{
    			arr[i] = arr[i+1];
    		}
    		
    		arr[idx--] = 0;
    		
    		return num; 
    	}
    	
    	public int peek(int index)
    	{
    		if (idx < index) return -1;
    		
    		return arr[index];
    	}
    	
    	public int size()
    	{
    		return idx + 1;
    	}
    }
}