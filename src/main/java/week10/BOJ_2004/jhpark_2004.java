package main.java.week10.BOJ_2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jhpark_2004 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        long five_count = five(N) - five(N-M) - five(M);
        long two_count = two(N) - two(N-M) - two(M);

        System.out.println(Math.min(five_count, two_count));
    }

    static long five(long n) {
        int count = 0;
        while(n >= 5) {
            count += n/5;
            n /= 5;
        }

        return count;
    }

    static long two(long n) {
        int count = 0;
        while(n >= 2) {
            count += n/2;
            n /= 2;
        }

        return count;
    }
}
