package BOJ_18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  1. 개수 입력 + 개수만큼 숫자 입력받는 배열과 카운트 배열 생성 - 카운트 배열 0으로 초기화
 *  2. 숫자 입력 + 각 숫자 배열에 할당
 *  3. 인덱스 0부터 N까지 숫자 배열을 각 자리와 비교한 후 비교 대상보다 큰 경우 카운트 배열의 카운트 ++
 *  4. 카운트 배열 출력
 *  ---
 *  Map 써야 함
 */


public class jhpark_18870 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numberArray = new int[N];
        int[] countArray = new int[N];

        for (int i = 0; i < N; i++) {
            countArray[i] = 0;
        }

        String string = br.readLine();
        StringTokenizer st = new StringTokenizer(string);

        for (int i = 0; i < N; i++) {
            numberArray[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (numberArray[i] > numberArray[j]) {
                    countArray[i]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(countArray[i] + " ");
        }
    }
}
