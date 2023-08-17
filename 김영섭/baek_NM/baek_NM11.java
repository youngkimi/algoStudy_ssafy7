import java.util.Arrays;
import java.util.Scanner;

// 시간 초과 나는 풀이.

public class baek_NM11 {
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
			// 방문처리 안하는 문제임 (중복선택 가능)
			while (i < num-1 && arr[i] == arr[i+1])
				i++;
							
//			System.out.println(Arrays.toString(visited));
			
			ans[deep] = arr[i];
			rec(deep + 1);
		}
	}
}
