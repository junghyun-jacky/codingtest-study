package BOJ_25305;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 입력 범위 - N: 1~1000, 1 < K < N, 점수 0~10000
 * 1. N, K 입력
 * 2. N 만큼 점수 입력(공백)
 * 3. N 만큼이 배열 생성
 * 4. 배열에 입력받은 점수 할당
 * 5. 정렬
 * 6. (N-K)에 해당하는 배열 값 출력
 */

public class jhpark_25305 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] scoreArr = new int [N];
        while (st2.hasMoreTokens()) {
            for(int i=0; i<N; i++) {
                scoreArr[i] = Integer.parseInt(st2.nextToken());
            }
        }

        // 선택정렬로 오름차순 정렬
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(scoreArr[i] > scoreArr[j]) {
                    int tmp = scoreArr[i];
                    scoreArr[i] = scoreArr[j];
                    scoreArr[j] = tmp;
                }
            }
        }

        System.out.println(scoreArr[N-K]);

    }
}
