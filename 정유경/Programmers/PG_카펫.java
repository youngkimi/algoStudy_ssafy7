package Programmers;
class PG_카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        int garo = 0;
        int sero = 0;
        for(int i=1; i<=sum; i++){
            garo = i;
            if(sum%garo == 0)
                sero = sum/garo;
            
            if(sero>garo) continue;
            
            if(((garo-2) * (sero-2)) == yellow){
                answer[0] = garo;
                answer[1] = sero;
                break;
            }
        }
        return answer;
    }
}