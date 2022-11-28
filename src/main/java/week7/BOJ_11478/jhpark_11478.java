package main.java.week7.BOJ_11478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class jhpark_11478 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        String sub = "";

        HashSet<String> set = new HashSet<String>();

        for(int i=0; i<string.length(); i++) {
            sub = "";

            for(int j=i; j<string.length(); j++) {
                sub += string.substring(j,j+1);
                set.add(sub);
            }
        }
        System.out.println(set.size());
    }
}
