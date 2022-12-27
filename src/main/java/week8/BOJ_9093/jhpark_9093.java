package main.java.week8.BOJ_9093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class jhpark_9093 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            Stack stack = new Stack();
            String s = br.readLine();

            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == ' '){
                    while(!stack.empty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                } else {
                    stack.push(s.charAt(j));
                }
            }
            while(!stack.empty()) {
                sb.append(stack.pop());
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
