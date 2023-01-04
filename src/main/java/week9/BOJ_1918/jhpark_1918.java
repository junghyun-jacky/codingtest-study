package main.java.week9.BOJ_1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class jhpark_1918{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<input.length(); i++) {
            char operator = input.charAt(i);

            if(operator >= 'A' && operator <= 'Z'){
                sb.append(operator);
            } else if(operator == '(') {
                stack.push('(');
            } else if (operator == ')') {
                while(!stack.empty()) {
                    if(stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    sb.append(stack.pop());
                }
            }
            else {
                while (!stack.empty() && priority(stack.peek()) >= priority(operator)) {
                    sb.append(stack.pop());
                }
                stack.push(operator);
            }
        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    static int priority(char operator) {
        if(operator == '(' || operator == ')') {
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else {
            return 2;
        }
    }

}
