import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        for(int[] card: sizes){
            int w = Math.max(card[0], card[1]);
            int h = Math.min(card[0], card[1]);
            width = Math.max(width, w);
            height = Math.max(height, h);
        }
        return width * height;
    }
}
