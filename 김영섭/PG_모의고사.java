class Solution {
    public int[] solution(int[] answers) {
        int[] point = new int[3];
        
        int[] answer1 = new int[] {1, 2, 3, 4, 5};
        int[] answer2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i = 0; i < answers.length; i++)
        {
            if (answers[i] == answer1[i%5])
                point[0]++;
            if (answers[i] == answer2[i%8])
                point[1]++;
            if (answers[i] == answer3[i%10])
                point[2]++;
        }
        
        int max_point = 0;
        int max_persons = 0;
        
        for (int i = 0; i < 3; i++)
        {
            if (point[i] > max_point)
            {
                max_point = point[i];
                max_persons = 1;
            }
            else if (point[i] == max_point)
            {
                max_persons++;
            }
        }
        
        int[] answer = new int[max_persons];
        int idx = 0;
        
        for (int i = 0; i < 3; i++)
        {
            if (point[i] == max_point)
            {
                answer[idx++] = (i+1);
            }
        }
        
        return answer;
    }
}