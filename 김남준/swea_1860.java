import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	static int T;

	static int N; // 손님수
	static int M; // 단위 시간(초)
	static int K; // M초 투입시 만들수 있는 붕어빵의 총 개수 K

	static int[] board;
	static int total_bread;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/SWEA_1860/input.txt"));
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		tc: for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();

			board = new int[N];

			for (int i = 0; i < N; i++) {
				board[i] = sc.nextInt();
			}
			Arrays.sort(board);

			if (board[0] == 0) {
				System.out.printf("#%d %s%n", test_case, "Impossible");
				continue tc;
			}

			for (int i = 0; i < N; i++) {
				total_bread = (board[i] / M) * K;
				if (total_bread < i + 1) {
					System.out.printf("#%d %s%n", test_case, "Impossible");
					continue tc;
				}
			}

			System.out.printf("#%d %s%n", test_case, "Possible");

		}
	}
}