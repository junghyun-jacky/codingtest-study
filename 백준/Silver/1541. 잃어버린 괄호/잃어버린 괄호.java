import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int sum = Integer.MAX_VALUE;

        while (st.hasMoreTokens()) {
            int tmp = 0;

            // 덧셈 미리 계산
            StringTokenizer add = new StringTokenizer(st.nextToken(), "+");
            while(add.hasMoreTokens()) {
                tmp += Integer.parseInt(add.nextToken());
            }

            if(sum == Integer.MAX_VALUE) {
                sum = tmp;
            } else {
                sum -= tmp;
            }
        }
        System.out.println(sum);
    }

}
