package baek;

import java.util.Scanner;

public class baek_2851 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score[] = new int[10];
		int ans = 0;
		for(int i=0;i<10;i++)
		{
			score[i]=sc.nextInt();		
		}
		
		for(int i=0;i<10;i++)
		{
			if(Math.abs(100-(ans+score[i])) <= Math.abs(100-ans))
			{
				ans+=score[i];
				continue;
				
			}
			System.out.println(ans);
			return;	
		}
		
		System.out.println(ans);
	}

}
