> PR 제목은 문제명_이름으로 작성해주세요.

OX퀴즈

## 🔗 문제 링크

https://www.acmicpc.net/problem/8958

### ✏ 나의 풀이

- 문제 풀기전 설계(문제를 처음보고 이런 느낌이 들었다, 이렇게 풀면 되겠다는 생각을 했다, 자료구조를 사용했다, ~~해서 시간복잡도를 줄이려고했다 등등)
  => 조건문과 반복문으로 풀 수 있을 것 같다.
  => 쉬운 난이도 같다.
  [예상풀이]
1. 우선 testCase 개수 입력받고
2. testCase 개수만큼 순회하는 for문 작성
3. for문 안에 testCase 개수만큼 OX퀴즈 결과 입력
4. 입력한 결과(문자열)의 범위 지정 (0<결과<80)
5. 각 결과를 순회하며 "0"을 만나면 +1 후 처음으로 돌아오기
   만약 X를 만나면 +1 하지 않고, 만난 X의 위치부터 순회하기
6. 나온 값을 더하기(앞에 int sum = 0; 선언 미리 해둘 것)

```JAVA

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCase = sc.nextInt();
		sc.nextLine();

		// testCase만큼 순회하는 for문 작성
		for (int i = 0; i < testCase; i++) {
			int sum = 0; // 결과 점수 선언
			String ox_result = sc.nextLine(); // ox 결과 입력
			String[] result = ox_result.split(""); // 입력받은 결과 값만큼의 배열 생성

			int cnt = 0; // 연속되는 "O"의 개수

			for (int j = 0; j < result.length; j++) { // 결과값의 개수만큼 순회하며 OX확인
				if (result[j].equals("O")) { // 만약 j번째 결과값이 "O"라면
					cnt++; // "O"의 개수 증가
					sum = sum + cnt;  // 구한 "O"의 개수만큼 누적 더하기
				}else { // X를 만나면
					cnt=0; // X를 만나면 cnt = 0
				}

			}
			System.out.println(sum);
		}

	}

}


```

### 😎 느낀 점 및 회고
