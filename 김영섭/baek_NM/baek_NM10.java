import java.util.Arrays;
import java.util.Scanner;

public class baek_NM10 {
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
			
			while (i < num-1 && visited[i+1] == -1 && arr[i] == arr[i+1])
				i++;
			
			// 선택한 문자보다 작은 문자들은 모조리 방문처리 해줘야한다.
			// 근데 이전 deep에서 선택한 문자들은 건너뛰어야한다.
			// 여기서 새로 방문처리하면 아래 방문 해제 시 같이 풀려버린다.
			
			for (int j = 0; j < num; j++)
			{
				if (arr[j] == arr[i]) break;
				
				if (arr[j] < arr[i] && visited[j] == -1) visited[j] = deep;
			}
				
			visited[i] = deep;
			
			// 여기서 방문처리 했던 요소들만 다시 해제해줘야한다..
			// 방문을 표시하는 val을 deep으로 설정해주면, 어느 deep에서
			// 방문 처리 된 것인지를 알 수 있다.
			
//			System.out.println(Arrays.toString(visited));
			
			ans[deep] = arr[i];
			rec(deep + 1);
			
			for (int j = 0; j < num; j++)
			{
				if (arr[j] == arr[i]) break;
				
				if (arr[j] < arr[i] && visited[j] == deep) visited[j] = -1;
			}
			
			visited[i] = -1;
		}
	}
}
