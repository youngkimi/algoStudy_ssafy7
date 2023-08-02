package baek;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class swea_1940 {

	public static void main(String args[])throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		String temp="";
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			int ans=0;
			int speed=0;
			int cnt = sc.nextInt();
			sc.nextLine();
			for(int i=0;i<cnt;i++)
			{	

				char[] a = new char[3];
				temp=sc.nextLine();
				for(int j=0;j<temp.length();j++)
				{
					a[j]=temp.charAt(j);

				}
				
				if(a[0]=='0')
				{
					ans+=speed;
				}
				else if(a[0]=='1')
				{
					speed+=Character.getNumericValue(a[2]);
					ans+=speed;
					
				}
				else
				{	
					speed-=Character.getNumericValue(a[2]);
					if(speed<0)
						speed=0;
					ans+=speed;
				}
				
			}
			System.out.println("#"+test_case+" "+ans);
	
		}
	}

}
