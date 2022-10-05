package BOJ_5622;

import java.util.Scanner;

public class jhpark_5622 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String word = sc.next();
        int rslt = minTime(word);

        System.out.println(rslt);
    }

    public static int minTime(String str) {

        int cnt = 0;

        String[] strArray = str.split("");

        // switsh case 로 비꿔보기
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].equals("A") || strArray[i].equals("B") || strArray[i].equals("C")) {
                cnt += 3;
            } else if (strArray[i].equals("D") || strArray[i].equals("E") || strArray[i].equals("F")) {
                cnt += 4;
            } else if (strArray[i].equals("G") || strArray[i].equals("H") || strArray[i].equals("I")) {
                cnt += 5;
            } else if (strArray[i].equals("J") || strArray[i].equals("K") || strArray[i].equals("L")) {
                cnt += 6;
            } else if (strArray[i].equals("M") || strArray[i].equals("N") || strArray[i].equals("O")) {
                cnt += 7;
            } else if (strArray[i].equals("P") || strArray[i].equals("Q") || strArray[i].equals("R") || strArray[i].equals("S")) {
                cnt += 8;
            } else if (strArray[i].equals("T") || strArray[i].equals("U") || strArray[i].equals("V")) {
                cnt += 9;
            } else if (strArray[i].equals("W") || strArray[i].equals("X") || strArray[i].equals("Y") || strArray[i].equals("Z")) {
                cnt += 10;
            }
        }
        return cnt;
    }
}

