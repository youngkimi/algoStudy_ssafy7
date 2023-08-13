import java.util.Scanner;

// 시간 초과 나는 풀이.

public class baek_NM03 {
	static int[] arr;
	static int num, N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		
		N = sc.nextInt(); // 타겟 깊이 
		
		arr = new int[num];
		
		for (int i = 1; i <= num; i++)
			arr[i-1] = i;
		
		rec("", 0);
		
		sc.close();
	}
	
	public static void rec(String path, int deep)
	{
		if (deep == N)
		{
			System.out.println(path);
			return;
		}
		
		for (int i = 0; i < num; i++)
		{			
			rec(path + arr[i] + " ", deep + 1);
		}
	}
}
