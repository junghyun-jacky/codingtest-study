package main.java.week9.BOJ_11655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jhpark_11655 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        for(int i=0; i< input.length; i++) {
            int ascii = (int)input[i];
            if(ascii>=65 && ascii <= 90) {
                if(ascii + 13 > 90){
                    input[i] = (char) (ascii - 13);
                }
                else {
                    input[i] = (char) (ascii + 13);
                }
            }
            else if(ascii>=97 && ascii<=122){
                if(ascii + 13 > 122){
                    input[i] = (char) (ascii - 13);
                }
                else {
                    input[i] = (char) (ascii + 13);
                }
            }
        }
        System.out.println(input);
    }
}
