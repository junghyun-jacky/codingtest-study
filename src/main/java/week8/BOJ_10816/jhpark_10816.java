package main.java.week8.BOJ_10816;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class jhpark_10816 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        HashMap<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (!map.containsKey(number)) {
                map.put(number, 1);
            } else {
                int value = map.get(number) + 1;
                map.put(number, value);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            int number = Integer.parseInt(st.nextToken());
            if(map.containsKey(number)) {
                bw.write(map.get(number) + " ");
            } else {
                bw.write(0 + " ");
            }
        }

        bw.flush();
        bw.close();

    }
}
