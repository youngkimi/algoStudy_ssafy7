import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        
		for(int i=0;i<arr.length;i++) {
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }
			else if(stack.peek()!=arr[i]) {
				stack.push(arr[i]);
			}
		}
        int N = stack.size();
        answer = new int[N];
        for(int i=N-1;i>-1;i--){
            answer[i]=stack.pop();
        }
        return answer;
    }
}