/**
 * !! indexOf 사용 !!
 * indexOf는 문자열에서 특정 문자가 시작되는 위치(인덱스)를 리턴한다.
 * !! contains 사용 !!
 * contains는 문자열에서 특정 문자열이 포함되어 있는지의 여부를 리턴한다.
 */

import java.util.Scanner;

public class jhpark_10809 {

    public static void main(String[] args) {

        String [] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        int [] abLoc = new int [26];
        for (int i=0; i<abLoc.length; i++) {
            abLoc[i] = -1;
        }

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        for(int i=0; i<alphabet.length; i++) {
            if(input.contains(alphabet[i])) {
                abLoc[i] = input.indexOf(alphabet[i]);
            }
        }

        for(int i=0; i<abLoc.length; i++) {
            System.out.print(abLoc[i] + " ");
        }

    }
}