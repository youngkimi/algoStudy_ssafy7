package Baek_00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountNums_10807 {
	public static void main (String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       String text = br.readLine();
       int N = text.length();
       boolean bracket = false;
       int wordlen = 0;
       
       for (int i = 0; i < N; i++)
       {
    	   if (text.charAt(i) == '<')
    		   bracket = true;
    	   
    	   if (terminated(text.charAt(i)) && wordlen > 0)
    	   {
    		   for (int j = 0; j < wordlen; j++)
    		   {
    			   System.out.print(text.charAt(i-j-1) + ' ');
    		   }
			   //System.out.print(wordlen + ' ');
    		   wordlen = 0;
    		   
    	   }
    	   
    	   if (bracket)
    	   {
    		   System.out.print(text.charAt(i));
    		   if (text.charAt(i) == '>')
    				   bracket = false;
    	   }
    	   else
    		   wordlen++;
       }
   }

	
	
	public static boolean terminated(char c)
	{	
		boolean res = false;
		
		if (c == '<' || c == ' ')
			res = true;
		return res;		
	}

}