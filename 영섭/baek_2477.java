import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // melon for 1m2
		String tmp[] = new String[2];
		int map[][] = new int[6][2]; // direct / len

		for (int i = 0; i < 6; i++) {
			tmp = br.readLine().split(" ");
			int dir = Integer.parseInt(tmp[0]);
			int len = Integer.parseInt(tmp[1]);
			map[i][0] = dir;
			map[i][1] = len;
		}

		if (map[0][0] == map[2][0])
			if (map[1][0] == map[3][0])
				System.out.println((map[4][1] * map[5][1] - map[1][1] * map[2][1]) * N);
			else
				System.out.println((map[4][1] * map[3][1] - map[1][1] * map[0][1]) * N);
		else if (map[0][1] > map[2][1])
			if (map[1][0] == map[3][0])
				System.out.println((map[0][1] * map[5][1] - map[2][1] * map[3][1]) * N);
			else
				System.out.println((map[0][1] * map[1][1] - map[4][1] * map[3][1]) * N);
		else {
			if (map[1][1] > map[3][1])
				System.out.println((map[2][1] * map[1][1] - map[4][1] * map[5][1]) * N);
			else
				System.out.println((map[2][1] * map[3][1] - map[0][1] * map[5][1]) * N);
		}
	}
}