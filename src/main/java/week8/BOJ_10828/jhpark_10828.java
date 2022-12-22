package main.java.week8.BOJ_10828;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class jhpark_10828 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if(order.equals("pop")) {
                if(stack.empty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(stack.peek() + "\n");
                    stack.pop();
                }
            } else if(order.equals("size")) {
                bw.write(stack.size() + "\n");
            } else if(order.equals("empty")) {
                if(stack.empty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else if(order.equals("top")) {
                if(stack.empty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(stack.peek() + "\n");
                }
            }
        }

        bw.close();

    }
}
