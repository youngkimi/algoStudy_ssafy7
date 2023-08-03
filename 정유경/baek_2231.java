import java.util.*;

public class baek_2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0; //0으로 초기화

		for(int i=0; i<N; i++) {
			int number = i;
			int sum = 0;
			
			//각 자릿수의 합 구하기
			while(number != 0) {
				sum += number % 10;
				number /= 10;
			}
			
			//i값과 각 자릿수 누적합이 같은 경우(생성자 찾음)
			if(sum + i == N) {
				answer = i;
				break; //최솟값 구하는 것이므로 break문으로 탈출
			}
		}
		System.out.println(answer);
	}
}