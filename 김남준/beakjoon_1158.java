package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class beakjoon_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> queue = new LinkedList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder answer = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		answer.append('<');

		int index = 0;

		while (queue.size() > 1) {
			for(int i = 0; i < K - 1; i++) {
				queue.offer(queue.poll());
			}
			answer.append(queue.poll()).append(", ");
		}

		answer.append(queue.remove()).append(">");
		System.out.println(answer);
	}

}
