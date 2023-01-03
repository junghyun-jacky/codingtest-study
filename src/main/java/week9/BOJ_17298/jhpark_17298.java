package main.java.week9.BOJ_17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 스택이 비어있지않으면서 seq[stack.peek()] < seq[i] 일 경우 stack.pop() 하며 pop 한 인덱스의 원소를 seq[i] 으로 바꾸기
 * 스택의 모든 원소를 pop 하면서 해당 인덱스의 원소를 -1로 초기화
 */

public class jhpark_17298 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++) {
            while(!stack.empty() && seq[stack.peek()] < seq[i]) {
               seq[stack.pop()] = seq[i];
            }
            stack.push(i);
        }

        while(!stack.empty()) {
            seq[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(seq[i]).append(" ");
        }

        System.out.println(sb);
    }
}
