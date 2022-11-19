package BOJ_2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jhpark_2231 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i=0; i<N; i++) {
            int numberOfDigits = i;
            int sum = 0;

            while(numberOfDigits != 0) {
                sum += numberOfDigits % 10;
                numberOfDigits /= 10;
            }

            if(sum + i == N) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
