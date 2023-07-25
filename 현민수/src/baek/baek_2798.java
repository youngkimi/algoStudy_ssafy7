package baek;

import java.util.Scanner;

public class baek_2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] card = new int[N];
		int ans=0;
		for(int i=0;i<N;i++)
		{
			card[i]=sc.nextInt();
		}
		
		for(int i=0;i<N-2;i++)
			for(int j=i+1;j<N-1;j++)
				for(int k=j+1;k<N;k++)
				{
					if(card[i]+card[j]+card[k]<=M)
						ans = Math.max(ans, card[i]+card[j]+card[k]);
				}
		System.out.println(ans);
	}

}
