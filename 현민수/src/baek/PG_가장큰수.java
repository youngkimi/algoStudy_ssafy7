import java.util.Comparator;
import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[][] temp = new String[numbers.length][2];
        for(int i=0;i<numbers.length;i++){
            String s = String.valueOf(numbers[i]);
            temp[i][0] = String.valueOf(i);
            temp[i][1] = s.concat(s).concat(s).concat(s);
        }
        Arrays.sort(temp,new Comparator<String[]>() {
        	public int compare(String[] o1, String[] o2) {
                if(o1[1].toString().contentEquals(o2[1].toString()))
                    return o1[0].toString().compareTo(o2[0].toString());
                else
                    return o1[1].toString().compareTo(o2[1].toString());
            }
        });
        

        for(int i=numbers.length-1;i>-1;i--) {
        	answer+=Integer.toString(numbers[Integer.parseInt(temp[i][0])]);
        }
        if(answer.charAt(0)=='0')
            return "0";
        return answer;
    }
}