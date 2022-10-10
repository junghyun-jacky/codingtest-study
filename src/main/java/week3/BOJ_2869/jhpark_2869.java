package BOJ_2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jhpark_2869 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        int day = (V - B) / (A - B);

        // 나머지가 있을 경우 (잔여 길이가 있을 경우)
        if ((V - B) % (A - B) != 0) {
            day++;
        }
        System.out.println(day);

    }
}
