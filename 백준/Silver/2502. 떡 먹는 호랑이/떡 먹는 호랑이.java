import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] DP = new int[d];

        for (int i = 1; i <= k/2; i++) {
            for (int j = i+1; j < k; j++) {
                DP[0] = i;
                DP[1] = j;
                for (int l = 2; l < d; l++) {
                    DP[l] = DP[l-1] + DP[l-2];
                }
                if(DP[d-1] == k) {
                    System.out.println(DP[0]);
                    System.out.println(DP[1]);
                    System.exit(0);
                }
            }
        }

    }
}