import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			int length = sc.nextInt();
			int answer = 0;
			int[][] map = new int[length][length];

			// 0, 1, 2가 담긴 100 * 100 크기의 이차원 배열 생성
			for (int row = 0; row < length; row++) {
				for (int col = 0; col < length; col++) {
					map[col][row] = sc.nextInt();
				}
			}

			for (int[] cols : map) {
				String stk = "";

				for (int j = 0; j < length; j++) {
					if (cols[j] == 0)
						continue;

					stk += cols[j];
					if (stk.contains("12")) {
						answer += 1;
						stk = "";
					}

				}
			}

			System.out.printf("#%d %d%n", i, answer);

		}
	}
}