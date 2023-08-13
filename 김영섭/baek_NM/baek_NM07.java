import java.util.Arrays;
import java.util.Scanner;

//시간 초과 나는 풀이.

public class baek_NM07 {
	static int[] arr, ans;
	static boolean[] visited;
	static int num, N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		
		N = sc.nextInt(); // 타겟 깊이 
		
		arr = new int[num];
		ans = new int[num];
//		visited = new boolean[num];
		
		for (int i = 0; i < num; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		rec(0);
		
		sc.close();
	}
	
	public static void rec(int deep)
	{
		if (deep == N)
		{
			for (int i = 0 ; i < N; i++)
			{
				System.out.print(ans[i]);
				System.out.print(" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < num; i++)
		{			
//			if (visited[i]) continue;
//			
//			for (int j = 0; j < i; j++)
//				visited[j] = true;
			
			ans[deep] = arr[i];
			rec(deep + 1);
			
//			for (int j = 0; j < i; j++)
//				visited[j] = false;
		}
	}
}
