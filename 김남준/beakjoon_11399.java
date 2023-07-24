package beakjoon;

import java.io.*;
import java.util.*;

public class beakjoon_11399 {
	public static void main(String[] args) throws IOException {
		// 입출력 코드
		// 모든 사람을 한번씩 순회해야하기 때문에 배열 자료구조를 이용합니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 무조건 사간이 적은 사람부터 기다리는 시간을 최소화할 수 있기 때문에, 오름차순으로 정렬해야함
		Arrays.sort(arr);
		
		// 걸린 시간의 누적값을 answer, 
		// 1~2,1~3... 1~n 번째 사람 각각이 걸린 시간을 담는 변수인 temp 선언 및 초기화  
		int answer = 0;
		int temp = 0;

		for(int i = 0; i < n; i++) {
			temp += arr[i];
			answer += temp;
		}
		
		System.out.print(answer);
	}
}
