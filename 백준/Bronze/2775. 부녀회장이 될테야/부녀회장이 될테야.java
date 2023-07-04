import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(recur(k, n));

        }
    }

    private static int recur(int k, int n) {
        if (n == 1) return 1;
        if (k == 0) return n; // 없을 경우 stackoverflow 발생

        int sum = 0;
        for (int i = n; i > 0; i--) {
            sum += recur(k-1, i);
        }
        return sum;
    }

}