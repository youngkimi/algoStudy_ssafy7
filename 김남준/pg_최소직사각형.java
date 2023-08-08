class Solution {
    public int solution(int[][] sizes) {
        int max_width = 0;
        int max_height = 0;
        
        for(int[] wh : sizes){
            max_width = Math.max(Math.max(wh[0], wh[1]), max_width);
            max_height = Math.max(Math.min(wh[0], wh[1]) , max_height);
        }
        
        return max_width * max_height;
        
    }
}