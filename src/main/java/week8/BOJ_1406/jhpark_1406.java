package main.java.week8.BOJ_1406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/*
    The process of solving
    L : 커서를 한칸 왼쪽으로 -> 왼쪽 스택을 pop해 오른쪽 스택에 push
    D : 커서를 한칸 오른쪽으로 -> 오른쪽 스택을 pop해 왼쪽 스택에 push
    B : 커서 왼쪽에 있는 문자 삭제 -> 왼쪽 스택 pop
    P : 다음에 주어지는 문자를 커서 왼쪽에 삽입 -> 왼쪽 스택 push
 */

public class jhpark_1406 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int commandsCount = Integer.parseInt(br.readLine());

        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();

        for(int i=0; i<input.length(); i++) {
            leftStack.push(input.substring(i,i+1));
        }

        for(int i=0; i<commandsCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String c = st.nextToken();

            switch (c) {
                case "L":
                    if(!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case "D":
                    if(!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case "B":
                    if(!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case "P":
                    leftStack.push(st.nextToken());
                    break;
            }
        }

        while(!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while(!rightStack.isEmpty()) {
            bw.write(rightStack.pop());
        }

        bw.flush();
        bw.close();
    }

}
