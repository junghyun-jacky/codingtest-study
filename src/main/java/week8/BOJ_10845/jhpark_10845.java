package main.java.week8.BOJ_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class jhpark_10845 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        int last = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s) {
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    queue.add(last);
                    break;

                case "pop":
                    if(queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.poll()).append("\n");
                    }
                    break;

                case "size":
                    sb.append(queue.size()).append("\n");
                    break;

                case "empty":
                    if(queue.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "front":
                    if(!queue.isEmpty()) {
                        sb.append(queue.peek()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;

                case "back":
                    if(!queue.isEmpty()) {
                        sb.append(last).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
