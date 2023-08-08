class Solution {
    public int[] solution(int brown, int yellow) {
        int total_block = brown + yellow;
        int[] answer = new int[2];
        
        for (int i = 3; i < brown; i++) // 한 변은 무조건 3칸 이상
        {
			// 전체 블록수를 나눠가면서 만약 나눠떨어지고, 그때 만들수 있는 yellow 개수와 동일하면
			// 끝냅니다.

        	if (total_block % i == 0 && ((total_block/i)-2)*(i-2) == yellow)
            {
                if (i > (total_block/i))
                {
                    answer[0] = i;
                    answer[1] = total_block/i;
                }
                else
                {
                    answer[0] = total_block/i;
                    answer[1] = i;
                }
                break;
            }
        }        
        
        return answer;
    }
}