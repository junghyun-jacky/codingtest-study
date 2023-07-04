import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp(N));
        }
    }

    private static int dp(int N) {
        if (N == 1) return 1;
        if (N == 2) return 2;
        if (N == 3) return 4;
        else return dp(N-1) + dp(N-2) + dp(N-3);
    }
}