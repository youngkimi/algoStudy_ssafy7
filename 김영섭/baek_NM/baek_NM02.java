import java.util.Scanner;

public class baek_NM02 {
	static int[] arr;
	static boolean[] visited;
	static int num, N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		
		N = sc.nextInt(); // 타겟 깊이 
		
		arr = new int[num];
		
		for (int i = 1; i <= num; i++)
			arr[i-1] = i;
				
		visited = new boolean[num];
		
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
			if (visited[i]) continue;
			
			for (int j = 0; j <= i; j++)
				visited[j] = true;
			rec(path + arr[i] + " ", deep + 1);
			for (int j = 0; j <= i; j++)
				visited[j] = false;
		}
	}
}
