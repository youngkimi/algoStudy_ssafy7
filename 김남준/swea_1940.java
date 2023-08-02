import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
        {
            Scanner sc = new Scanner(System.in);
            int T;
            T=sc.nextInt();

            for(int i = 1; i <= T; i++)
            {
                int N = sc.nextInt();
                int RC = 0; // 해당 케이스에서 RC카의  현재 속도 RC 
                int answer = 0; // N초 동안 이동한 거리의 누적값 

                for(int j = 1; j <= N; j++){
                    int time = sc.nextInt();

                    if(time == 1) RC += sc.nextInt();
                    if(time == 2) RC -= sc.nextInt();
                    if( RC < 0 ) RC = 0;

                    answer += RC;
                }
                
                System.out.printf("#%d %d %n", i, answer);
        }
    }
}