import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> date = new ArrayList<>();
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int N = progresses.length;
        for(int i=0;i<N;i++){
            int temp = (int)Math.ceil((100-progresses[i])/(double)speeds[i]);
            if(que.isEmpty()){
                que.offer(temp);
                continue;
            }
            if(que.peek()>=temp){
                que.offer(temp);
            }
            else{
                int size = que.size();
                date.add(size);
                while(!que.isEmpty()){
                    que.poll();
                }
                que.push(temp);
            }
            
        }
        date.add(que.size());
        int len = date.size();
        int[] answer = new int[len];
        for(int i=0;i<len;i++){
            answer[i] = date.get(i);
        }
        return answer;
        
    }
}