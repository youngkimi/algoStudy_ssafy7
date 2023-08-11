// 코드 
import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		//진행방향을 표기할 플래그
		final int LEFT = 1, RIGHT = 2, UP = 3;

		for (int test_case = 1; test_case <= 10; test_case++) {
			final int TEST_NUMBER = sc.nextInt();
			final int[][] map = new int[100][100];

			int row = 99;
			int col = 0;
			int flag = UP;

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 2) {
						col = j;
					}
				}
			}

			while (row > 0) {
				if (flag == UP) {
					if (col - 1 >= 0 && map[row][col - 1] == 1) {
						col--;
						flag = LEFT;
					} else if (col + 1 < 100 && map[row][col + 1] == 1) {
						col++;
						flag = RIGHT;
					} else {
						row--;
					}
				} else if (flag == RIGHT) {
					if (col + 1 < 100 && map[row][col + 1] == 1) {
						col++;
					} else {
						row--;
						flag = UP;
					}
				} else {
					if (col - 1 >= 0 && map[row][col-1] == 1) {
						col--;
					} else {
						row--;
						flag = UP;
					}
				}
			}

			System.out.printf("#%d %d%n", TEST_NUMBER, col);
		}
	}
}
