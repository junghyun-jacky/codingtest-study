import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;

    // 3가지 케이스 Cost[][] 배열
    // 누적합 저장할 DP[][] 함수
    static int[][] Cost;
    static int[][] DP;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Cost = new int [N][3];
        DP = new int [N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            Cost[i][Red] = Integer.parseInt(st.nextToken());
            Cost[i][Green] = Integer.parseInt(st.nextToken());
            Cost[i][Blue] = Integer.parseInt(st.nextToken());
        }

        // DP의 첫번째 값(집)은 각 색상비용의 첫번째 값으로 초기화
        DP[0][Red] = Cost[0][Red];
        DP[0][Green] = Cost[0][Green];
        DP[0][Blue] = Cost[0][Blue];

        System.out.println(Math.min(paintCost(N-1, Blue), Math.min(paintCost(N-1, Red), paintCost(N-1, Green))));
    }

    // 점화식을 이용하여 재귀함수로 구성한 뒤, 해당 배열을 아직 탐색하지 않았다면 재귀를 해주고, 그 외의 경우는 DP배열의 값을 반환
    static int paintCost(int N, int color) {

        // 탐색하지 않은 경우, DP 초기값 0
        if(DP[N][color] == 0) {

            // color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 DP에 저장
            if(color == Red) {
                DP[N][Red] = Math.min(paintCost(N-1,Green), paintCost(N-1,Blue)) + Cost[N][Red];
            }
            else if(color == Green) {
                DP[N][Green] = Math.min(paintCost(N-1, Red), paintCost(N-1, Blue)) + Cost[N][Green];
            } else {
                DP[N][Blue] = Math.min(paintCost(N-1, Red), paintCost(N-1, Green)) + Cost[N][Blue];
            }
        }
        return DP[N][color];
    }
}