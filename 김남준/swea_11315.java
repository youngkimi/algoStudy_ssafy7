import java.util.*;
import java.io.*;

class Solution {

	static int N;
	static String[][] board;
	static String s;

	// 우, 하, 좌우 대각 방향
	static int[] dr = { 0, 1, 1, 1 };
	static int[] dc = { 1, 1, 0, -1 };

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/SWEA_11315/sample_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		tc: for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			s = sc.nextLine();

			board = new String[N][N];

			for (int i = 0; i < N; i++) {
				String str = sc.nextLine();
				board[i] = str.split("");
			}

			// 모든 행렬의 원소를 순회해서
			iteration_col: for (int col = 0; col < N; col++) {
				iteration_row: for (int row = 0; row < N; row++) {
					// 자기 자신과 하,우,상하대각 방향 중 4칸 이내 값이 0인 케이스가 있다면 테케를 종료하고 결과 출력
					if (board[col][row].equals("o") && checkBoard(col, row)) {
						System.out.printf("#%d %s%n", test_case, "YES");
						continue tc;
					}
				}
			}

			System.out.printf("#%d %s%n", test_case, "NO");
		}

	}

	public static boolean checkBoard(int col, int row) {
		// 4방향 별로
		direction: for (int d = 0; d < 4; d++) {
			boolean flag = true;
			// 인접한 4칸을 조사한다
			range: for (int i = 1; i <= 4; i++) {
				int newRow = row + dr[d] * i;
				int newCol = col + dc[d] * i;

				// 보드의 범위 초과 또는 . 이 발견되면 해당 순회를 중단하고 상위 반복문으로 돌아감
				if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= N || board[newCol][newRow].equals(".")) {
					flag = false;
					break;
				}
			}
			if (flag)
				return true;
		}
		return false;
	}
}
