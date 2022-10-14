package BOJ_1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jhpark_1978 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()) {

            // 소수일 때 true, 아닐 때 false
            boolean isPrime = true;

            // 입력받은 수를 하나하나 num에 대입
            int num = Integer.parseInt(st.nextToken());

            if(num == 1) {
                continue;
            }
            for(int i=2; i<=Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
