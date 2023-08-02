package algorithm_Study;

import java.util.Scanner;

public class num_03 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt(); // 테스트케이스 입력

		for (int i = 0; i < testCase; i++) { // 입력한 테스트케이스 수만큼 반복하겠다.
			int speed = 0; // 현재 속도
			int move = 0; // 이동거리
			int N = sc.nextInt(); // N개의 command가 필요하므로 우선 N 입력
			for (int j = 0; j < N; j++) { // N개의 command가 필요하므로 N번 반복
				int a = sc.nextInt(); // 속도유지=0, 가속=1, 감속=2
				if (a == 0) { // 만약 a=0(속도유지)이면
					move += speed; // 이동거리는 현재속도 + 현재속도
					continue; // 가속도 값 입력안함!
				}
				int b = sc.nextInt(); // 얼마나 감속, 또는 가속할지 입력
				if (a == 1) { // 만약 a=1(가속)이면
					speed += b; // speed는 기존의 speed + b
					move += speed;
				}
				else if (a == 2) { // 만약 a=2(감속)이면
					speed -= b; // speed는 기존의 speed - b
					if (speed < 0) { // 만약 스피드가 음수가 되면
						speed = 0; // 제약사항에 의해 speed=0
					}
					move += speed;
				}
			}
			System.out.println("#" + (i + 1) + " " + move); // 현재속도의 합을 다 더하면 N초동안 이동한 거리가 나옴.

		}
		sc.close();
	}

}
