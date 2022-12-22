package main.java.week8.BOJ_1874;

/*
    The process of solving
    입력받은 value 값까지 push 한 이력이 없을 경우 stack에 value까지 push 한 후 마지막 원소를 pop
    StringBuilder 사용
    -> 반복문이 정상적으로 끝날 경우 저장해둔 문자열을 한 번에 출력,
    그 외의 경우 이미 "NO"가 출력되어 프로그램이 종료된 상태이므로 출력될 일x
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class jhpark_1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        int start = 0;

        while(N -- > 0) {
            int value = Integer.parseInt(br.readLine());
            if (value > start) {
                for (int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append("+\n");
                }
                start = value; // 오름차순이어야 하므로 이전에 어디까지 입력받았는지 알기 위해
            } else if (stack.peek() != value) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-\n");
        }

        System.out.println(sb);
    }
}
