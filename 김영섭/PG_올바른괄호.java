class Solution {
    boolean solution(String s) {
        char[] stack = new char[50000];
        
        int idx = -1;
        
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
                stack[++idx] = s.charAt(i);
            else
            {
                if (idx == -1)
                    return false;
                
                idx --;
            }
        }
        
        return (idx == -1);
    }
}