import java.util.HashSet;

class Solution {
    static String[] number;
    static int ans=0;
    static String subNum;
    static HashSet<Integer> set;
    
    public int solution(String numbers) {
        number = numbers.split("");
        set = new HashSet<Integer>();
        Subset(0,"");
        return ans;
    }
    
    static void Subset(int cnt,String num){
        if(cnt==number.length){// 부분집합
            if(num.length()>0) 
            {
                //순열 조합
                perm(0,0,"",num);


            }
            return;
        }   
        Subset(cnt+1,num+number[cnt]);
        Subset(cnt+1,num);
        
    }
    static void prime(int n){  // 소수판단
        if(n==1 || set.contains(n))
            return;
        for(int i=2;i<(int)(Math.sqrt(n))+1;i++){
            if(n%i==0)
            {
                return;
            }
        }
        set.add(n);
        ans++;
        return;
    }
    
    static void perm(int cnt,int flag, String p_num, String subset){   //해당 집합의 순열 만들기
        if(cnt==subset.length())  //기저조건
        {  
            if(p_num.length()>0 && !(p_num.charAt(0)=='0'))
                prime(Integer.parseInt(p_num));
            return;
        }
        for(int i=0;i<subset.length();i++)
        {
            if((flag & 1<<i)!=0) continue;
            perm(cnt+1,flag | 1<<i,p_num+subset.charAt(i),subset);
            
        }
    }
    
}