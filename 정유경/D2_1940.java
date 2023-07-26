package D2;

import java.util.Scanner;

public class D2_1940 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int k=1; k<=T; k++) {
			int N = sc.nextInt();
			int speed = 0; //초기 속도
			int dist = 0; //초기 이동거리
			
			for(int i=0; i<N; i++) {
				int a = sc.nextInt();
				
				if(a == 0) {
					dist += speed;
				} else if(a == 1) {
					int b = sc.nextInt();
					speed += b;
					dist += speed;
				} else if(a == 2) {
					int b = sc.nextInt();
					speed -= b;
					if(speed < 0)
						speed = 0;
					dist += speed;
				}
			}
			System.out.printf("#%d %d\n", k, dist);
		}
	}
}
