package SWEA;
import java.util.Scanner;

public class SWEA_1220 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int k=1; k<=10; k++) {
			int N = sc.nextInt(); //100 
			int[][] arr = new int[100][100];
			//100x100 행렬 입력받기
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int answer = 0; //교착 상태 개수 셀 변수
			for(int j=0; j<100; j++) {
				String str = "";
				for(int i=0; i<100; i++) {
					if(arr[i][j] != 0) {
						str += Integer.toString(arr[i][j]);
					}
				}
				for(int i=0; i<str.length()-1; i++) {
					if(str.substring(i,i+2).equals("12")) {
						answer++;
					}
				}
			}
			System.out.printf("#%d %d\n",k,answer);
		}
	}
}
