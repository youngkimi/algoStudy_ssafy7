import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/// 방향이 중요;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String map[] = new String[8]; //
		int iMap[] = new int[8];

		for (int i = 0; i < 4; i++) {
			map = br.readLine().split(" ");
			for (int j = 0; j < 8; j++) {
				iMap[j] = Integer.parseInt(map[j]);
			} // converting to integer
			System.out.println(sol(iMap));
		}
	}

	public static String side(int A, int B, int tar) {

		if (tar < A)
			return "l";
		else if (tar == A)
			return "a";
		else if (tar == B)
			return "b";
		else if (tar > B)
			return "r";
		else
			return "m";
	}

	public static String sol(int[] map) {
		String p1x = side(map[0], map[2], map[4]);
		String p2x = side(map[0], map[2], map[6]);

		String p1y = side(map[1], map[3], map[5]);
		String p2y = side(map[1], map[3], map[7]);

		if (p2x == "l" || p1x == "r") {
			return "d"; // outside
		} else if (p2x == "a" || p1x == "b") {
			if (p2y == "l" || p1y == "r")
				return "d"; // outside
			else if (p2y == "a" || p1y == "b")
				return "c"; // point
			else
				return "b"; // line
		} else if (p2y == "l" || p1y == "r")
			return "d"; // outside
		else if (p2y == "a" || p1y == "b")
			return "b"; // line
		else
			return "a"; // rec
	}
}