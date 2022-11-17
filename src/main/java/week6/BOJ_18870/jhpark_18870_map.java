package BOJ_18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class jhpark_18870_map {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] origin = new int[N];
        int[] sorted = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();

        String string = br.readLine();
        StringTokenizer st = new StringTokenizer(string);
        for (int i = 0; i < N; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        int count = 0;
        for(int n : sorted) {
            if(!map.containsKey(n)){
                map.put(n, count);
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int key : origin) {
            sb.append(map.get(key)).append(" ");
        }
        String result = sb.toString();
        System.out.println(result);
    }
}
