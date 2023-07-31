import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = new String[2];
		tmp = br.readLine().split(" ");

		int N = Integer.parseInt(tmp[0]);
		int power = Integer.parseInt(tmp[1]);
		int[] W = new int[N];
		int[] V = new int[N];

		int[] table = new int[power + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = power; j > 0; j--) // count_num = power
			{ // putting values
				if (W[i] > power || j - W[i] < 0)
					continue;
				else
					table[j] = Math.max(table[j], table[j - W[i]] + V[i]);
			}
		}

		System.out.println(table[power]);
	}
}