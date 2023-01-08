package main.java.week10.BOJ_1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jhpark_1676 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        // 5만 세기 위해, 5의 배수만 완전히 고려
        while(N >= 5) {
            count = count + N/5;
            N /= 5;
        }

        System.out.println(count);
    }
}
