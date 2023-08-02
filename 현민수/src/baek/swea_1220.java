package baek;

import java.util.ArrayList;
import java.util.Scanner;

public class swea_1220 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<11;tc++)
		{
			int n=sc.nextInt();
			int ans=0;
			int[][] arr = new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<100;j++)
					arr[i][j]=sc.nextInt();
			
			for(int i=0;i<100;i++)
			{
				String temp="";
				
				for(int j=0;j<100;j++)
				{
					if(arr[j][i]==0)
						continue;
					temp+= Integer.toString(arr[j][i]);
				}
				char[] ch = temp.toCharArray();
				for(int j=0;j<ch.length-1;j++)
				{
					if(ch[j]=='1' && ch[j+1]=='2')
						ans+=1;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}

	}

}

