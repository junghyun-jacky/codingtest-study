package main.java.week8.BOJ_14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class jhpark_14425 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        HashSet<String> words = new HashSet<>();

        for(int i=0; i<N; i++) {
            words.add(br.readLine());
        }

        for(int i=0; i<M; i++) {
            if(words.contains(br.readLine())) {
                count++;
            }
        }

        System.out.println(count);
    }
}
