import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] DP;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st0;
        StringTokenizer st1;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            DP = new int[2][n+1];

            st0 = new StringTokenizer(br.readLine());
            st1 = new StringTokenizer(br.readLine());

            DP[0][1] = Integer.parseInt(st0.nextToken());
            DP[1][1] = Integer.parseInt(st1.nextToken());

            for (int j = 2; j <= n; j++) {
                DP[0][j] = Math.max(DP[1][j-1], DP[1][j-2]) + Integer.parseInt(st0.nextToken());
                DP[1][j] = Math.max(DP[0][j-1], DP[0][j-2]) + Integer.parseInt(st1.nextToken());
            }

            System.out.println(Math.max(DP[0][n], DP[1][n]));
        }
    }
}