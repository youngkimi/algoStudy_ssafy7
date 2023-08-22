import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        int len = s.length();
    
        for(int i=0;i<len;i++){
            char temp = s.charAt(i);
            if(stack.isEmpty() && temp==')'){
                return false;
            }
            if(temp=='('){
                stack.push(temp);
            }
            else{
                stack.pop();
            }
        }
        if(!stack.isEmpty())
            return false;
        return answer;
    }
}