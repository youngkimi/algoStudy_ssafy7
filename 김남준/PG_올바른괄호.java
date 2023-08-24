public class Solution {
        boolean solution(String s) {
        int cnt = 0;
        
        if (s.charAt(0) == ')' || s.charAt(s.length() - 1) == '('){
            return false;  
        }
        
        for (int i = 0; i < s.length(); i++) {
            cnt += s.charAt(i) == '(' ? 1 : -1; 
            if (cnt < 0) return false; 
        }
        
        return cnt == 0;
    }
}


// class Solution {
//     boolean solution(String s) {
//         int cnt = 0;
        
//         if (s.charAt(0) == ')' || s.charAt(s.length() - 1) == '('){
//             return false;  
//         }
        
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '(') {
//                 cnt += 1;
//             } else {
//                 cnt -= 1;
//             }
//         }
        
//         return cnt == 0 ? true : false;
//     }
// }