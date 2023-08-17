import java.util.Scanner;

public class Solution {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스 10개
		for(int tc=1; tc<=10; tc++) {
			int TestCase = sc.nextInt();
			
			String[] arr = new String[100]; //String 문자열 입력
			//배열에 값 입력 받기
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.next();
			}
			
			int maxCount = -1; //최대 길이 저장할 변수
			
			//가로순회(뒤에서부터)
			row: for (int k = 100; k >= 1; k--) {
				for(int i = 0; i < 100; i++) { //행 고정
					for (int j = 0; j <= 100-k ; j++) { //열 우선 탐색
						int start = j; //시작 인덱스
	 					int end = j + k - 1;; //끝 인덱스
	 					boolean flag = true; //맨 처음 한글자는 회문
	 					for(int l=0; l<=(end-start)/2; l++) { //회문 탐색
	 						if(arr[i].charAt(start+l) != arr[i].charAt(end-l)) { //회문 아니면
	 							flag = false;
	 							break;
	 						}
	 						
	 					}
	 					if(flag == true) { //회문이면
 							if(maxCount < k) 
 								maxCount = k; //최대값 갱신
 							break row;
 						}
					}
				}
			} //row
			
			//세로순회(뒤에서부터)
			column: for (int k = 100; k >= 1; k--) {
				for(int j = 0; j < 100; j++) { //열 고정
					for (int i = 0; i <= 100-k; i++) { //행 우선 탐색
						int start = i; //시작 인덱스
	 					int end = i + k - 1;; //끝 인덱스
	 					boolean flag = true; //맨 처음 한글자는 회문
	 					for(int l=0; l<=(end-start)/2; l++) { //회문 탐색
	 						if(arr[start+l].charAt(j) != arr[end-l].charAt(j)) { //회문 아니면
	 							flag = false;
	 							break;
	 						}
	 						
	 					}
	 					if(flag == true) { //회문이면
 							if(maxCount < k) 
 								maxCount = k; //최대값 갱신
 							break column;
 						}
					}
				}
			} //column
					
			//출력
			System.out.printf("#%d %d\n", TestCase, maxCount);
		} //test case
	} //main
}
