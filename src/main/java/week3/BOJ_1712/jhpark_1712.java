package BOJ_1712;

import java.util.Scanner;

public class jhpark_1712 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int N, rslt;

        if (B >= C) {
            rslt = -1;
        }
        else {
            N = A / (C - B);
            rslt = N + 1;
        }

        System.out.println(rslt);
    }
}
