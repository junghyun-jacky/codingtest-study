import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 두 번째 원소를 기준으로 오름차순으로 정렬, 두 번째 원소가 같을 경우 첫 번째 원소를 오름차순으로 정렬
            // 따라서 compare 메소드는 유지하고 두번째 원소를 먼저 입력받음
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (e1, e2) -> {
            if(e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            // 두 번째 원소를 먼저 입력받았으므로 원래대로 뒤집에서 출력
            sb.append(arr[i][1]).append(" ").append(arr[i][0]).append("\n");
        }
        System.out.println(sb);
    }
}