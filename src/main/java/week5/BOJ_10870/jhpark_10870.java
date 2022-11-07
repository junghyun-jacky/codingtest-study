package BOJ_10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jhpark_10870 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int fib = Fibonacci(N);
        System.out.println(fib);
    }

    public static int Fibonacci(int N) {
        if(N == 0) {
            return 0;
        }
        if(N == 1) {
            return  1;
        }
        return N = Fibonacci(N-1) + Fibonacci(N - 2);
    }
}
