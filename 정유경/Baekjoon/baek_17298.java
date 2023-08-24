package Baekjoon;
import java.io.*;
import java.util.*;
public class baek_17298 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N]; //수열 배열
        int[] answer = new int[N]; //정답 배열
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.push(0); //처음에는 stack이 항상 비어있으므로 최초값을 push해서 초기화
        for (int i = 1; i < N; i++) {
            //스택이 비어있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                answer[stack.pop()] = arr[i]; //정답 배열에 오큰수를 현재 수열로 저장
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            //반복문을 다 돌고 나왔는데 스택이 비어있지 않다면 빌 때까지
            answer[stack.pop()] = -1; //스택에 쌓인 index에 -1 넣고
        }
        for (int i = 0; i < N; i++) {
            sb.append(answer[i] + " "); //출력
        }
        System.out.print(sb);
    }
}
