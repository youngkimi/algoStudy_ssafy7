import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			int speed = 0;
			int pos = 0;

			while (N-- > 0) {
				int cmd = sc.nextInt();
				int ac = 0;

				if (cmd != 0)
					ac = sc.nextInt();

				if (cmd == 2)
					ac *= -1;

				speed += ac;

				if (speed < 0)
					speed = 0;

				pos += speed;
			}
			System.out.println("#" + test_case + " " + pos);
		}
	}
}
