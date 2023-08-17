import java.util.Arrays;
import java.util.Scanner;

// 시간 초과 나는 풀이.

public class baek_NM12 {
	static int[] arr, ans;
	static int[] visited;
	static int num, N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		
		N = sc.nextInt(); // 타겟 깊이 
		
		arr = new int[num];
		ans = new int[num];
		visited = new int[num];
		
		for (int i = 0; i < num; i++)
			visited[i] = -1;
		
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
			if (visited[i] != -1) continue;
			
			// 중복되는 문자열 중 마지막 문자열까지 밀어준다.
			// 이후 deep 에서는 그 전 문자가 마지막 문자열이 된다.
			
			
			
			
			while (i < num-1 && arr[i] == arr[i+1])
				i++;
			
			for (int j = 0; j < num; j++)
			{
				if (arr[j] == arr[i]) break;
				
				if (arr[j] < arr[i] && visited[j] == -1) visited[j] = deep;
			}
							
			ans[deep] = arr[i];
			
			rec(deep + 1);
			
			for (int j = 0; j < num; j++)
			{
				if (arr[j] == arr[i]) break;
				
				if (arr[j] < arr[i] && visited[j] == deep) visited[j] = -1;
			}
			
		}
	}
}
