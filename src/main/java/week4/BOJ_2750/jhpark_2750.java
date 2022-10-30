package BOJ_2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 입력 범위 -1000 ~ 1000
 * 1. 숫자의 개수 입력받기
 * 2. cnt 크기의 배열에 입력값들 할당
 * 3. 선택정렬
 * 4. 배열 출력
 */

public class jhpark_2750 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int cnt = Integer.parseInt(br.readLine());
        int[] numArr = new int [cnt];

        // 입력값 배열에 할당
        for(int i=0; i<cnt; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
        }

        // 선택정렬로 오름차순 정렬
        for(int i=0; i<cnt-1; i++) {
            for(int j=i+1; j<cnt; j++) {
                if(numArr[i] > numArr[j]) {
                    int tmp = numArr[i];
                    numArr[i] = numArr[j];
                    numArr[j] = tmp;
                }
            }
        }

        // 출력
        for(int i=0; i<cnt; i++) {
            System.out.println(numArr[i]);
        }
    }
}
