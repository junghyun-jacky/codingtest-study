package BOJ_4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jhpark_4948 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            boolean prime[] = new boolean[2*num+1];
            prime[0] = prime[1] = true;

            int cnt = 0;
            for (int i = 2; i < Math.sqrt(prime.length); i++) {
                    if (prime[i]) {
                        continue;
                    }
                    for(int j = i * i; j < prime.length; j += i) {
                        prime[j] = true;
                    }
            }

            for(int i = num + 1; i<=2*num; i++) {
                if(!prime[i]) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
