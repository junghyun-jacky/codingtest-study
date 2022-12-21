package main.java.week7.BOJ_1269;

/*
  The process of solving
  - HashSet 사용 : 중복 허용x, 순서x
  1. A, B 개수 입력
  2. A, B 원소 입력
  3. removeAll() method - (A-B), (B-A) 구함
  4. count 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class jhpark_1269 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int countA = Integer.parseInt(st.nextToken());
        int countB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<countA; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<countB; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        HashSet<Integer> substract1 = new HashSet<>(setA);
        substract1.removeAll(setB);

        HashSet<Integer> substract2 = new HashSet<>(setB);
        substract2.removeAll(setA);

        int count = substract1.size() + substract2.size();
        System.out.println(count);
    }
}
