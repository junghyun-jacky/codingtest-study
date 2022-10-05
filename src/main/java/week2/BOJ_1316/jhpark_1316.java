package BOJ_1316;

import java.util.Scanner;

public class jhpark_1316 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = N;

        /**
         * 1. 현재 알파벳과 다음 알파벳이 다를 경우
         * 2. 다음 알파벳이 전체 문장에 없으면 된다.
         */
        for(int i=0; i<N; i++) {
            String word = sc.next();
            boolean[] check = new boolean[26];

            for(int j=0; j<word.length()-1; j++) {
                if(word.charAt(j) != word.charAt(j+1)) {
                    if(check[word.charAt(j + 1) - 97] == true) {    // 그룹체커가 아니면 cnt에서 -1씩 해줌
                        cnt--;
                        break;
                    }
                }
                check[word.charAt(j) - 97] = true;
            }
        }
        System.out.println(cnt);

    }
}
