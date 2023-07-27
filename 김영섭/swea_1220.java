import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int map[][] = new int[N][N];
			int impasse = 0;

			for (int i = 0; i < N * N; i++)
				map[i / 100][i % 100] = sc.nextInt();

			for (int i = 0; i < N; i++) {
				boolean Nth = false;
				for (int j = 0; j < N; j++) {
					if (map[j][i] == 1 && !Nth) // S극 처음 나옴
						Nth = true;
					if (map[j][i] == 2 && Nth) // S극 나왔고, N극 나옴
					{
						impasse++;
						Nth = false;
					}
				}
			}
			System.out.println("#" + test_case + " " + impasse);
		}
	}
}