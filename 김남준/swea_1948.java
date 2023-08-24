;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	static int T;
	static int answer;
	static int[] accumulated_date = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };

	static int start_month;
	static int start_day;
	static int end_month;
	static int end_day;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/SWEA_1948_날짜계산기/input.txt"));
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		tc: for (int test_case = 1; test_case <= T; test_case++) {
			start_month = sc.nextInt();
			start_day = sc.nextInt();
			end_month = sc.nextInt();
			end_day = sc.nextInt();

			answer = (accumulated_date[end_month - 1] + end_day) - (accumulated_date[start_month - 1] + start_day) + 1;
			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
}
